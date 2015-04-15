/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */

public abstract class Composant implements Comparable<Composant>{
	
	public void setIn(Composant comp) {}
	
	public int compareTo(Composant c) {
		return (this.getId().compareTo(c.getId()));
		}
	
	public String getId() {
		return super.toString(); // class@numero renvoye par Object	
		}
	
	public String description(){
		return this.getId();
		}
	
	public String traceEtat(){
		try {return(this.description() +" "+ this.getEtat());}
		catch (NonConnecteException ex) {return(this.description() +" "+  (this+" non connecte"));}
		}
	
	public abstract boolean getEtat() throws NonConnecteException;	

	
}
