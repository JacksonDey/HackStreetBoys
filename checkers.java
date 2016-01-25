import java.io.*;
import java.util.*;
public class checkers{
    private String[][] board;
    private boolean player;
    private int pieces1;
    private int pieces2;

     private InputStreamReader isr;
     private BufferedReader in;
    
    public checkers(){
	board=new String[8][8];
	pieces1= 12;
	pieces2= 12;
	fill();
	filler();
	player=true;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	
    }
    public  void fill(){
		for(int i=3; i<5; i++){
	    	for(int s=0; s<8;s++){
			board[i][s]= "| |";
	    	}
		}
    }//end fill
    public void filler(){
	for(int s=0;s<8;s+=2){
		board[0][s]="| |";
	    }
	for(int s=1;s<8;s+=2){
		board[0][s]="|X|";
	    }
	for(int s=0;s<8;s+=2){
		board[2][s]="| |";
	    }
	for(int s=1;s<8;s+=2){
		board[2][s]="|X|";
	    }
	for(int s=0;s<8;s+=2){
		board[6][s]="| |";
	    }
	for(int s=1;s<8;s+=2){
		board[6][s]="|O|";
	    }
	 
	
	
	for(int s=0;s<8;s+=2){
		board[5][s]="|O|";
	    }
	for(int s=1;s<8;s+=2){
		board[5][s]="| |";
	    }
    
    
    for(int s=0;s<8;s+=2){
		board[7][s]="|O|";
	    }
   for(int s=1;s<8;s+=2){
		board[7][s]="| |";
	    }
    
	for(int s=0;s<8;s+=2){
		board[1][s]="|X|";
	    }
    
    for(int s=1;s<8;s+=2){
		board[1][s]="| |";
	    }
    }
   public String toString(){
        
	String rowerino="   ";
	for(int i=0;i<8;i++){
	    rowerino+=i+"  ";
	}
	rowerino+="\n";
    
	for(int i=0;i<8;i++){
	    rowerino+=i+" ";
	    for(int c=0; c<8; c++){
		rowerino += "" + board[i][c];
	    }
	    rowerino += "\n";
	
	    }
	
   return rowerino;
	    
	}
    public boolean wincheck(){
	return (pieces1==0 || pieces2==0);
    }
    public boolean checkspace(int r1, int c1){
    	if(board[r1][c1].equals("|X|")){
    		return true;
    	}
    	return false;
    }
    public boolean checkspacec(int r1, int c1){
    	if(board[r1][c1].equals("|O|")){
    		return true;
    	}
    	return false;
    }
    public boolean kill(int r1, int c1){
    	if(checkspace(r1,c1)){
    		pieces2-=1;
    		board[r1][c1]="| |";
    		return true;
    	}
    	return false;
    }
    public boolean killc(int r1, int c1){
    	if(checkspacec(r1,c1)){
    		pieces2-=1;
    		board[r1][c1]="| |";
    		return true;
    	}
    	return false;
    }
    public void movereg(int r, int c, int r1, int c1){
    	if(c1>c&&kill(r1,c1)&&player){
    		board[r1-1][c1+1]=board[r][c];
    		}
    	else if(c1<c&&kill(r1,c1)&&player){
    		board[r1-1][c1-1]=board[r][c];
    	}
    	else if(player){
    	board[r1][c1]=board[r][c];
    	}
    	else{
    		if(c1>c&&!(killc(r1,c1))&&!player){
    			board[r1+1][c1+1]=board[r][c];
    			}	
    		else if(c1<c&&killc(r1,c1)&&!player){
    			board[r1+1][c1-1]=board[r][c];
    			}
    		else{
    			board[r1][c1]="|X|";
    		}
    	}
    	board[r][c]="| |";
    }
    public void play(){
    int nay = 0;
	int choice1 =0;
	int choice2 = 0;
	int choice3 =0;
	int choice4 = 0;
    InputStreamReader in =new InputStreamReader(System.in);
	BufferedReader isr = new BufferedReader(in);
		System.out.print(this);
        while(wincheck() ==false){
            System.out.print("Ok player 1, its your turn!" + "\n" + " Which piece would you like to move, \n Enter row: ");
            try{
		choice1 = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
            
        	System.out.print(" What collumn ");
            try{
		choice2 = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
            
            System.out.print("Where would you like to move this piece? (If attacking enter cordinates of the piece you are attacking) \n Enter row: ");
            try{
		choice3 = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
            
            System.out.print("Enter collumn:");
            try{
		choice4 = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
	    movereg(choice1,choice2,choice3,choice4);
	    System.out.print(this);
	    player=false;
	    System.out.print("Ok player 2, its your turn!" + "\n" + " Which piece would you like to move, \n Enter row: ");
            try{
		choice1 = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
            
        	System.out.print(" Enter Collumn:");
        	try{choice2 = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
            
            System.out.print("Where would you like to move this piece? (If attacking enter cordinates of the piece you are attacking) \n Enter row: ");
            try{
		choice3 = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
            
            System.out.print("what column ");
            try{
		choice4 = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
        movereg(choice1,choice2,choice3,choice4);
	    System.out.print(this);
	    
        }//end while
	System.out.println("You win my homiee");
	System.out.println("Do you wanna play some more games?");
	System.out.println("psst.  type 1 for yes, 2 for no" + "\n");
	try{
        nay = Integer.parseInt(isr.readLine());
        }
        catch( IOException e ) { }
        if(nay == 1){
            amishArcade.displayGames();
             }
    }
    public static void main(String[] args){
    	checkers david= new checkers();
    	david.play();
    }
}
