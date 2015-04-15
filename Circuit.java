import java.util.*;

public class Circuit{
    
	protected List<Composant> composants = new ArrayList<Composant>();
	protected String name;
	protected SondesTable tableSondes = new SondesTable();
    
	
    
    public Circuit(String nom){
        name = nom;
    }
    
    public Circuit(String nom, Composant[] cps){
        name = nom;
        //for(Composant x : cps) composants.add(x);
        composants.addAll(Arrays.asList(cps));
        Collections.sort(composants);
    }
    
    public void ajoutComposant(Composant c){
			  composants.add(c);
		}
    
    public List<String> nomenclature(){
        List<String> tmp = new ArrayList<String>();
        //for(int i=0; i<composants.size();i++)   tmp.get(i) = composants.get(i).getId();    
        for(Composant x : composants) {tmp.add(x.getId());}
        return tmp;
    }
    
    public void description(){
        System.out.println(name);
        System.out.println(this.nomenclature());
    }
    
    public void traceEtats(){
        System.out.println(name);
        for(Composant x : composants)   System.out.println(x.traceEtat());
    }
    
    public List<Interrupteur> getIns(){
        List<Interrupteur> list_interrupteurs = new ArrayList<Interrupteur>();
        for(Composant x : composants) {
            if((x instanceof Interrupteur)==true) list_interrupteurs.add((Interrupteur)x);
            }
        return list_interrupteurs;
    }
    
    public List<Vanne> getOuts(){
        List<Vanne> list_vannes = new ArrayList<Vanne>();
        for(Composant x : composants) {
            if((x instanceof Vanne)==true) list_vannes.add((Vanne)x);
            }
        return list_vannes;
    }
    
    public void probe(){
    	for(Composant x : composants){
    	    if(x instanceof Porte)	((Porte)x).probe(tableSondes);
    	    }
    }
    
    public void resetSondes(){
    	for(Composant x : composants){
    		if(x instanceof LazySonde) ((LazySonde)x).reset();
    	}
    }
    
    public void unProbe(){
    	for(Composant x : composants){
    	    if(x instanceof Porte)	((Porte)x).unProbe(tableSondes);
    	}
    }
    
}
