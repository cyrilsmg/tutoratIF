grammar eqBoolAST;

@members { EquationCircuit circ = new EquationCircuit("toto");}

expr_bool returns [Composant c] :
	PARG expr_bool PARD { $c = $expr_bool.c;}
	|ID { $c = circ.getInterrupteur($ID.text);}
	|e1=expr_bool ET e2=expr_bool {And a = new And(); a.setIn1($e1.c); a.setIn2($e2.c); circ.ajoutComposant(a);}
	|e1=expr_bool OU e2=expr_bool {Or o = new Or(); o.setIn1($e1.c); o.setIn2($e2.c); circ.ajoutComposant(o);}
	|NON e1=expr_bool {Not n = new Not(); n.setIn($e1.c); circ.ajoutComposant(n);}
	;

equation :  ID '=' out=expr_bool ';'{} ;

circuit : 
	'eq_circuit(' in=listeid {circ.setMapInterrupteurs($in.l);} ') returns (' 
	out=listeid {circ.setMapVannes($out.l);} ')' equation+ 'end' ;

commande : 'descr()' {circ.description();} | 'eval(' llb=listeb ')' {circ.eval($llb.lb);} ;

prog : circuit commande+ ;

listeid returns [List<String> l] : ID s=suiteid* {List<String> l_id = new ArrayList<String>(); l_id.add($ID.text); l_id.addAll($s.ls); $l=l_id;};
suiteid returns [List<String> ls] : ',' ID {List<String> ls_id = new ArrayList<String>() ; ls_id.add($ID.text); $ls=ls_id;};

listeb returns [List<String> lb] : bool sb=suiteb* {List<String> l_b = new ArrayList<String>(); l_b.add($bool.text); l_b.addAll($sb.lsb); $lb=l_b;};
suiteb returns [List<String> lsb] : ',' bool {List<String> ls_b = new ArrayList<String>(); ls_b.add($bool.text); $lsb=ls_b;};

PARG : '(' ;
PARD : ')' ;
ID : [a-zA-Z0-9]+  ;
NON : '!' ;
ET : '&' ;
OU : '|' ;
bool : 'true' | 'false' ;
WS : [ \t\r\n]+ -> skip ;
