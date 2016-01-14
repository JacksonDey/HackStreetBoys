import java.io.*;
import java.util.*;
public class connect4 extends Game {
    private String[][] board;
    private boolean player;
    public connect4(){
	board =new String[8][8];
    }
    public  void fill(){
	for(int i=0; i<8; i++){
	    for(int s=0; s<8;s++){
		board[i][s]= "| |";
	    }
	}
    }
    public void replace(int c){
	int r = bigEmpty(c);
	if(player){
	    board[r][c]="|X|";
	}
	else {
	    board[r][c]="|O|";
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
		System.out.println(tot);
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
		System.out.println(tot);
	    }
	}
	return false;
    }	
    public boolean wincheckdi(){
	for(int i=0;i<8;i++){
	    int tot =0;
	    for (int c=0;c<8;c++){
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
	    
	
    public static void main(String[] Args){
	connect4 donald = new connect4();
	donald.fill();
	System.out.println(donald);
	donald.replace(1);
	donald.replace(2);
	donald.replace(2);
	donald.replace(2);
	donald.replace(3);
	donald.replace(3);
	donald.replace(4);
	System.out.println(donald);
	donald.replace(1);
	donald.replace(1);
	donald.replace(1);
	System.out.println(donald);
	System.out.println(donald.wincheckrow());
	System.out.println(donald.wincheckcol());
	System.out.println(donald.wincheckdi());

    }
}	
