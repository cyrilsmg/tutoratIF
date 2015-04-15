import java.io.*;
import java.util.*;
import java.lang.*;

public class Sonde extends Composant {

    private Composant in;
    private String s;
    	    
    public Sonde(Composant connecte, String connecteur){
    	in = connecte;
    	s = connecteur;
    	};
    
    public boolean getEtat(){
	System.out.println(s +" de "+ in.description() +", true or false?");
	Scanner in = new Scanner(System.in);
	String ret = in.nextLine();
	if(ret.equals("true"))
		return true;
	else if(ret.equals("false"))
		return false;
	else
		return getEtat();
	}

}


