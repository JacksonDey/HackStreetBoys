import java.io.*;
import java.util.*;
public class connect4{
    private String[][] board;
    private boolean player;

    private InputStreamReader isr;
    private BufferedReader in;
    public connect4(){
	board =new String[8][8];
	this.fill();
    }
    public  void fill(){
	for(int i=0; i<8; i++){
	    for(int s=0; s<8;s++){
		board[i][s]= "| |";
	    }
	}
    }
    public void replace(int c){
	InputStreamReader in =new InputStreamReader(System.in);
	BufferedReader isr = new BufferedReader(in);
	int choice=0;
	int r = bigEmpty(c);
	if(r==-1&&player){
	    System.out.println("Collumn full, make another choice");
	     try{
		choice = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
	     replace(choice);
	}
	else{
	     
	if(player){
	    board[r][c]="|X|";
	}
	else {
	    board[r][c]="|O|";
	}
	}
    }
    public int bigEmpty(int c){
	for(int i=7; i>=0; i--){
	    if(board[i][c].equals("| |")){
		return i;
	    }
	}
	return -1;
    }
    public String toString(){
	String rowerino="";
	for(int i=0;i<8;i++){
	    for(int c=0;c<8;c++){
		rowerino+=board[i][c];
	    }
	    rowerino+="\n";
	}
	return rowerino;
    }
    public boolean wincheckrow(){
	for(int i=0;i<8;i++){
	    int tot=1;
	    for(int c=1;c<8;c++){
		if((board[i][c]!="| |") && 
		   board[i][c].equals(board[i][c-1])){
		    tot+=1;
		}
		else{ 
		    tot=1;
	    }
		if (tot>=4){
		    return true;
		}
	    }
	}
	return false;
    }
    public boolean wincheckcol(){
	for(int i=0;i<8;i++){
	    int tot=1;
	    for(int c=1;c<8;c++){
		if((board[c][i]!="| |") && 
		   board[c][i].equals(board[c-1][i])){
		    tot+=1;
		}
		else{ 
		    tot=1;
	    }
		if (tot>=4){
		    return true;
		}
	    }
	}
	return false;
    }	
    public boolean wincheckdi(){
	for(int i=1;i<8;i++){
	    int tot =0;
	    for (int c=1;c<8;c++){
		if(i + c>=8){ break;}
		if (board[i +c][c]!= "| |" &&
		    board[i+ c-1][c-1]== board[i +c][c]){
		    tot+=1;
		}
		else {
		    tot=1;
		}
		if(tot>=4){
		    return true;
		}
	    }
	}
	return false;
    }
    public boolean wincheck(){
	return wincheckdi() || wincheckrow() || wincheckcol();
    }
    public void play(){
	int choice =0;
        InputStreamReader in =new InputStreamReader(System.in);
	BufferedReader isr = new BufferedReader(in);
        while(wincheck() ==false){
            System.out.print("Ok friend, its your turn!" + "\n" + "Pick your collumn! ");
            try{
		choice = Integer.parseInt(isr.readLine());
            }
            catch( IOException e ) { }
            player =true;
	    replace(choice);
	    player=false;
	    replace((int)(Math.random()*8));
	    System.out.print(this);
	    
        }//end while
	System.out.println("You win");
    }
	
    public static void main(String[] Args){

    }
}
