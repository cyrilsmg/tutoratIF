/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */


public class Interrupteur extends Composant {
	
	public String description(){
		return this.getId() + " name: " +  this.getName();
		}
	
	private String name;
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
    	name = n;
  	}
    
	protected boolean etat;
	public void on() {
		etat = true;
	}    
	public void off() {
		etat = false;
	}
	
	public boolean getEtat() throws NonConnecteException {
		return etat;	
	}
	
	protected Composant in;
	public void setIn(Composant cp){
		in = cp;
	}
	
}
