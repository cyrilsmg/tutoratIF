/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */

	import java.io.*;

	public class TestCircuits {
	
		static void PrintIds(Composant[] c){
		for(int i=0;i<c.length;i++){
		    System.out.print(c[i].getId()+"\n");
		    }
	    	}

		static void descriptions(Composant[] c){
		for(int i=0;i<c.length;i++){
			System.out.println(c[i].description());
			}
		}
		
		static void traceEtats(Composant[] c){
		for(int i=0;i<c.length;i++){
                	System.out.println(c[i].traceEtat());
			}
		}
		
		static void test(Circuit circ){
		System.out.println("\n\tnomenclature du circuit");
		System.out.println(circ.nomenclature());
		System.out.println("\n\tdescription du circuit");
		circ.description();
		System.out.println("\n\tentrees du circuit");
		System.out.println(circ.getIns());
		System.out.println("\n\tsortie du circuit");
		System.out.println(circ.getOuts());
		System.out.println("\n\tetat du circuit");
		circ.traceEtats();
		System.out.println("\n\tprobe() resetSondes() et unProbe()");
		circ.probe();
		circ.traceEtats();
		circ.resetSondes();
		circ.traceEtats();
		circ.unProbe();
		circ.traceEtats();
		}
	    public static void main(String[] args) {
			//Construction
		Vanne v = new Vanne();
		Interrupteur i1 = new Interrupteur();
		Interrupteur i2 = new Interrupteur();
		Interrupteur secu = new Interrupteur();
		And a = new And();
		Or o = new Or();
		Not n = new Not();
		Composant composants[]={i1,i2,secu,o,n,a,v};	
			
			
			
			//Connexions
		Circuit c = new Circuit("gumball",composants);
		o.setIn1(i1);
		o.setIn2(i2);
		n.setIn(secu);
		//n.setIn(new LazySonde(secu,"in"));
		a.setIn1(o);
		a.setIn2(n);
		//a.setIn2(new LazySonde(a,"in2"));
		v.setIn(a);
		//v.setIn(new LazySonde(a,"in"));
		
		i1.on();
		i2.off();
		secu.on();

			//Affichage
		System.out.println("\nBonjour !");
		System.out.println("\n\tListe des composants");
		PrintIds(composants);
		System.out.println("\n\tDescription des composants");			
		descriptions(composants);
		System.out.println("\n\tEtats des composants");
		traceEtats(composants);
		System.out.println("\n\tTP4");
		test(c);
		System.out.println("\nAu revoir!\n");
		}
	}
