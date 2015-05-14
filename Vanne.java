/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */

public class Vanne extends Composant {
	
	protected Composant in;
	private String name;
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
    	name = n;
  	}
    
	public void setIn(Composant comp) {
		in = comp;
		}
	
	public String description(){
		String info;
		if(in != null) info = in.getId();
		else info = "non connecte";
		return this.getId() + " name: " + this.getName() + " in : " + info ;
		}
	
	public boolean getEtat() throws NonConnecteException {
		if (in == null) throw new NonConnecteException();
		else return in.getEtat();
		}
		
}
