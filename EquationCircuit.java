import java.io.*;
import java.util.*;
import java.lang.*;

public class EquationCircuit extends Circuit {
	
	protected Map<String,Interrupteur> nameInterrupteurs = new LinkedHashMap<String,Interrupteur>();
	protected Map<String,Vanne> nameVannes = new LinkedHashMap<String,Vanne>();
	
	public EquationCircuit(String n){
	    super(n);
	};
	
	public void setMapInterrupteurs(List<String> l){				
		for(String x : l){
			Interrupteur in = new Interrupteur();
			in.setName(x);
			nameInterrupteurs.put(x,in);
			this.ajoutComposant(in);	
		}
	}

	public void setMapVannes(List<String> l){		
		for(String x : l){
			Vanne out = new Vanne();
			out.setName(x);
			nameVannes.put(x,out);
			this.ajoutComposant(out);
		}
	}
	
	public Interrupteur getInterrupteur(String name){
		return nameInterrupteurs.get(name);
	}
	
	public void ajoutComposant(Composant c){
		super.ajoutComposant(c);
	}
	
	public void description(){
		super.description();
	}
	
	public void eval(List<String> l){
		int i=0;
		int j=0;
		for(Interrupteur x : nameInterrupteurs.values()){
			i=0;
			for(String y : l){
				if(i==j){
					if(y=="true") x.on();
					if(y=="false") x.off();
				}
				i++;
			}
			j++;
		}
		super.traceEtats();
	}
	
}
