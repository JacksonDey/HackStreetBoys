
import java.io.*;
import java.util.*;

public class MasterMind extends Game{
    
    public final String[] SYMBOL = new String[]{"1","2","3","4","5","6"};
    public final String[][] board = new String[12][4];
    int turnctr;
    //public String[] input;
    public String[] code = new String[4];
    boolean gameover;
    String choice = "";
    
    private InputStreamReader isr;
    private BufferedReader in;
    
    
    
    public MasterMind(){
	turnctr = 0;
	gameover = false;
	randomize();
	fill();
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	

    }//end constructor
    
    //HELPER FUNCTIONS
    
    public void fill() {//fill board
        for(int r = 0; r <12; r ++){
            for(int c = 0; c <4; c ++){
                board[r][c] = "o";
                
            }
        }
        
    }
    public String printCode(){
        String retStr = "";
        for(int u = 0; u < 4; u++){
            retStr += "" + code[u];
        }
        return retStr;
    }
    
    public void randomize(){
            for(int r = 0;r< 4; r++){
            code[r] = SYMBOL[(int)(Math.random()*5)];
            }

    }//end randomize
        
    
 
    public int check_spot(String choice){
        int ctr = 0;
        for(int i = 0; i < 4; i++){
            if( code[i].equals(choice.substring(i, i + 1))){
                ctr++;
            }//end if
        }//end for
        return ctr;
    }//end check_spot
    
    public int check_type(String choice){
        int ctr = 0;
        for(int i = 0; i <4; i++){
            for(int b = 0; b <4; b++){
                if( code[i] .equals(choice.substring(b, b+ 1))){
                    ctr++;
                    break;
                }
            }//end second four
            
        }//end for
        return ctr;
    }//end check_type
    
    public String toString(){
    String rowerino="";
    	for(int i=0;i<12;i++){
    	    for(int c=0; c<4; c++){
    		    rowerino+=board[i][c];
    	    }
    	    rowerino+="\n";
	}
	
	return rowerino;
    }   
    
    public void fillerUp(String input,int row){
        String mock = input;
        for(int i = 0 ;i < 4 ; i++){
            board[row][i] = mock.substring(i, i + 1);
        }
    }
    public String print(String[] c){
        String retStr = "";
        for(int i = 0; i < 4; i++){
            retStr = "" + c[i];
        }
        return retStr;
    }
    
    //PLAY
    public void play(){
        fill();
        System.out.print("In Mastermind, you must attempt to guess the secreat pattern within twelve tries.\n It is a four letter combination involving the number 1-6. \n You will be told if any part of the combo you guessed was correct.\n Good Luck!\n\n\n SAMPLE guess: 1234");
        while(turnctr < 12 && gameover == false){
            int correct = 0;
            int right_type = 0;
            System.out.println(this);
            
            System.out.print("Ok friend, make your guess!" + "\n" + "Pick your choices! ");
            
            try{
            choice = in.readLine();
            }
            catch( IOException e ) { }
            
            System.out.println("Let's see how you did, shall we?");
            correct = check_spot(choice);
            right_type = check_type(choice);
            fillerUp(choice , turnctr);
            if( correct == 4 ){ 
                gameover = true;
                System.out.print("YOU GOT IT RIGHT! My homie you goood!!!  It only took you " + turnctr +" tries!");
                }
                
            else{
            System.out.println("Well, " + right_type + " , are the right kind, and exactly " + correct + " are in the right spot!");
                }//end else
                
            turnctr++;
       
        }//end while
        gameover=true;
            int ye =0;
            System.out.println("You tried kiddo. Here's the actual code:" );
            System.out.println( printCode() );
            System.out.println("\n" + "Wanna play again?" + "\n" + "psst.  type 1 for yes, 2 for no" + "\n");
            try{
            ye = Integer.parseInt(in.readLine());
            }
            catch( IOException e ) { }
            if(ye == 1){
            //we can get rid of it for now
                MasterMind game = new MasterMind();
                play() ;
                turnctr = 0;
                
            }//end if
            //end the gameover if
            int nay = 0;
            System.out.print("Wanna play more games?" + "\n" + "psst.  type 1 for yes, 2 for no" + "\n");
            try{
            nay = Integer.parseInt(in.readLine());
            }
            catch( IOException e ) { }
            if(nay == 1){
                amishArcade.displayGames();

            }
        
    }//end play
    public boolean wincheck(){
        
        return gameover;
        
        
    }
    public static void main(String[] args){
        MasterMind game = new MasterMind();
        game.play();
        
        
    }//end main
    
}//end class
