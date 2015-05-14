import java.io.*;
import java.util.*;
import java.lang.*;

public class EquationCircuit extends Circuit {
	
	private Map<String,Interrupteur> nameInterrupteurs = new LinkedHashMap<String,Interrupteur>();
	private Map<String,Vanne> nameVannes = new LinkedHashMap<String,Vanne>();
	private List<Boolean> valeurs = new ArrayList<Boolean>();
	
	public EquationCircuit(String n){
	    super(n);
	}
	
	public List<Boolean> getValuesArray(){
		return valeurs;
	}
	
	public Map<String,Interrupteur> getNameInterrupteurs(){
		return nameInterrupteurs;
	}
	
	public Map<String,Vanne> getNameVannes(){
		return nameVannes;
	}
	
	
	public Interrupteur getInterrupteur(String name){
		return nameInterrupteurs.get(name);
	}
	
	public void ajoutComposant(Composant c){
		super.ajoutComposant(c);
	}
	
	public void description(){
		System.out.println("Description du circuit:");
		super.description();
		System.out.print("\n");
	}
	
	public void eval(){
		int i=0;
		int j=0;
		for(Interrupteur x : nameInterrupteurs.values()){
			i=0;
			for(boolean y : valeurs){
				if(i==j){
					if(y==true) x.on();
					if(y==false) x.off();
				}
				i++;
			}
			j++;
		}
		System.out.println("Evaluation du circuit:");
		super.traceEtats();
		System.out.print("\n");
	}
	
}
