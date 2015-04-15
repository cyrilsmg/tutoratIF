 
public abstract class Porte2Entrees extends Porte {
    
    protected Composant in1;
    protected Composant in2;
    
    public void setIn1(Composant comp1){
	in1=comp1;}
    public void setIn2(Composant comp2){
	in2=comp2;}
    
    public String description(){
		String info1,info2;
		if(in1 != null) info1 = in1.getId();
		else info1 = "non connecte";
		if(in2 != null) info2 = in2.getId();
		else info2 = "non connecte";
		return this.getId()+" in1 : "+info1+" in2 : "+info2;
		}
    
    abstract boolean eval() throws NonConnecteException;
    public boolean getEtat() throws NonConnecteException{
		
		if (in1 == null || in2 == null) {
			
			throw new NonConnecteException();
			
		} else {
			
			return this.eval();
			
		}
	}

	public void probe(SondesTable tableSondes){
		if(in1 instanceof Interrupteur) {
		    this.setIn1(tableSondes.getSonde((Interrupteur)in1,this,"in1"));
		    }
		if(in2 instanceof Interrupteur) {
		    this.setIn2(tableSondes.getSonde((Interrupteur)in2,this,"in2"));
		    
		    }
		}
	
	public void unProbe(SondesTable tableSondes){
		 if(in1 instanceof LazySonde)   
		    this.setIn1(tableSondes.getInterrupteur((LazySonde)in1));
		 if(in2 instanceof LazySonde)   
		    this.setIn2(tableSondes.getInterrupteur((LazySonde)in2));
		}
}
