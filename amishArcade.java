import java.io.*;
import java.util.*;
public class amishArcade{
    public String s;
    public String r;
    
    private InputStreamReader isr;
    private BufferedReader in;

    public static int displayGames(){
	int choice=0;
        InputStreamReader in=new InputStreamReader(System.in);
	BufferedReader isr = new BufferedReader(in);  	
		String s= "Choose Your Game! clifford\n";
		
		
		String r= "________________" +"\n" +"|               |"+"\n"+"| 1 MasterMind  |"+"\n"+"________________\n";
		System.out.print(r);
		System.out.println(s);
		try{
		    choice = Integer.parseInt(isr.readLine());
		}
		catch( IOException e){}
		if(choice==1){
		    MasterMind david = new MasterMind();
		    david.play();
		}
		if(choice==2){
		    connect4 david = new connect4();
		    david.play();
		}
		return choice;
}
    public boolean playgame(){
	return true;
    }
    public void play(){
	int choice=0;
	while(playgame()){
	    choice = displayGames();
	    System.out.println(choice);
	    if(choice==1){
		System.out.println("mop");
		MasterMind david = new MasterMind();
		david.play();
	    }
	}
    }
	public static void main(String[] args){
	    displayGames();
	}
}
