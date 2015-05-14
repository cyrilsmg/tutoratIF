grammar eqBoolAST;

@members {EquationCircuit circ = new EquationCircuit("toto");}

expr_bool returns [Composant c] :
	PARG e1=expr_bool PARD { $c = $e1.c;}
	|ID { $c = circ.getInterrupteur($ID.text);}
	|e1=expr_bool ET e2=expr_bool {And a = new And(); a.setIn1($e1.c); a.setIn2($e2.c); circ.ajoutComposant(a); $c=a;}
	|e1=expr_bool OU e2=expr_bool {Or o = new Or(); o.setIn1($e1.c); o.setIn2($e2.c); circ.ajoutComposant(o); $c=o;}
	|NON e1=expr_bool {Not n = new Not(); n.setIn($e1.c); circ.ajoutComposant(n); $c=n;}
	;

equation :  ID '=' expr=expr_bool ';'{ Vanne v = circ.getNameVannes().get($ID.text); v.setIn($expr.c);} ;

circuit : 'eq_circuit' PARG listein  PARD 'returns' PARG	listeout  PARD equation+ 'end' ;

commande : 'descr()' {circ.description();} | 'eval' PARG listebool PARD {circ.eval();} ;

prog : circuit commande+ ;

listein :	ID { Interrupteur in=new Interrupteur(); in.setName($ID.text); circ.ajoutComposant(in); 
					circ.getNameInterrupteurs().put($ID.text, in); }
			| ID ',' listein { Interrupteur in=new Interrupteur(); in.setName($ID.text); 
								circ.ajoutComposant(in); circ.getNameInterrupteurs().put($ID.text, in); };

listeout :	ID { Vanne out=new Vanne(); out.setName($ID.text); circ.ajoutComposant(out); 
					circ.getNameVannes().put($ID.text, out); }
			| ID ',' listeout { Vanne out=new Vanne(); out.setName($ID.text); 
								circ.ajoutComposant(out); circ.getNameVannes().put($ID.text, out); };

listebool :	bool { circ.getValuesArray().add(new Boolean($bool.text)); }
			| bool ',' listebool { circ.getValuesArray().add(new Boolean($bool.text)); };

PARG : '(' ;
PARD : ')' ;
ID : [a-zA-Z0-9]+  ;
NON : '!' ;
ET : '&' ;
OU : '|' ;
bool : 'true' | 'false' ;
WS : [ \t\r\n]+ -> skip ;
