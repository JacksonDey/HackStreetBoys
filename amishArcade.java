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
		String s= "Choose Your Game! \n";
		
		
		String r = "________________" +"\n" +"|               |"+"\n"+"| 1 MasterMind  |"+"\n"+"________________\n";
		String q = "________________" +"\n" +"|               |"+"\n"+"| 2 ConnectFour |"+"\n"+"________________\n";
		String v = "________________" +"\n" +"|               |"+"\n"+"| 3  Othello    |"+"\n"+"________________\n";
		String w = "________________" +"\n" +"|               |"+"\n"+"| 4  Tictac     |"+"\n"+"________________\n";
		String e = "________________" +"\n" +"|               |"+"\n"+"| 5  Checkers   |"+"\n"+"________________\n";
		System.out.print(r);
		System.out.print(q);
		System.out.print(v);
		System.out.print(w);
		System.out.print(e);
		System.out.println(s);
		try{
		    choice = Integer.parseInt(isr.readLine());
		}
		catch( IOException ey){}
		if(choice==1){
		    Game david = new MasterMind();
		    david.play();
		}
		if(choice==2){
		    Game jackson = new connect4();
		    jackson.play();
		}
		if(choice==3){
		    Game louisa = new Othello();
		    louisa.play();
		}
		if(choice==4){
		    Game jaaaaack = new tictactoe();
		    jaaaaack.play();
		}
		if(choice==5){
		    Game matt = new checkers();
		    matt.play();
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
