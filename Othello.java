import java.io.*;
import java.util.*;

public class Othello extends Game{
    
    public final String[] sides = { "X " , "O " };
    public final String[][] board = new String[8][8];
    int turnctr;
    boolean gameover;
    //READERS
    private InputStreamReader isr;
    private BufferedReader in;
    
    public Othello() {
	turnctr = 0;
	gameover = false;
	
 	fill();
 	
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	

    }//end constructor

    public void fill(){//fill board
        for(int r = 0; r < 8; r ++){
            for(int c = 0; c < 8; c ++){
                board[r][c] = "* ";
                
            }
        }
        //special cases for the board start
        board[3][3] = sides[0];
        board[4][4] = sides[0];
        board[3][4] = sides[1];
        board[4][3] = sides[1];
    }
    
    public void flip(int r, int c){
        if( board[r][c] == sides[0] ) {
           board[r][c] = sides[1];
       }  
        else{
            board[r][c] = sides[0];
        }
    }
    public void move(int r, int c,int player){
        board[r][c]=sides[player];
    }
    public boolean winCheck(){
        int i=0;
        for(int c=0;c<8;c++){
            for(int r=0;r<8;r++){
                if(board[c][r].equals("#") || board[c][r].equals("O")){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void horflip(int r, int c, int player){
       int left = horCheckL(r, c, player);
       int right = horCheckR(r, c, player);
       if(!(left == -1)){
       for(int le = 1; le < left; le++){
           flip(r, c - le);
       }
       }
       if(!(right == -1)){
       for(int re = 1; re < right; re++){
           flip(r, c + re);
       }
       }
    }//end hor
    
    public void vertflip(int r, int c, int player){
        int up = vertCheckUp(r, c, player);
        int down = vertCheckDown(r, c, player);
        if(!(up == -1)){
        for(int le = 1; le < up; le++){
           flip(r - le, c);
        }
        }//end if
        if(!(down == -1)){
       for(int re = 1; re < down; re++){
           flip(r + re, c);
        }
        }//end if

    }//end vert
    
    public void diagflip(int r, int c, int player){
        int UL = diagCheckUL(r, c, player);
        int UR = diagCheckUR(r, c, player);
        int DL = diagCheckDL(r, c, player);
        int DR = diagCheckDR(r, c, player);
    if(!(UL == -1)){
    for(int upl = 1; upl < UL; upl++){
        flip(r - upl, c - upl);
    }//end for
    }//end if
    if(!(UR == -1)){
    for(int upr = 1; upr < UL; upr++){
        flip(r - upr, c + upr);
    }//end for
    }//end if
    
    if(!(DL == -1)){
    for(int dol = 1; dol < UL; dol++){
        flip(r + dol, c - dol);
    }//end for
    }//end if
    
    if(!(DR ==-1)){
    for(int dor = 1; dor < UL; dor++){
        flip(r + dor, c + dor);
    }//end for
    }//end if
    
    }//end diag
    
    public int horCheckL(int r, int c, int player){
        int val = 0;
        boolean check = false;
        for(int t = c - 1; t > 0; t--){
            if(board[r][t] == sides[player]){
                val = t;
                check = true;
                break;
                
            }    
        }
        if (check){
            return val;
        }
        else{
            return -1;
        }
    }
    public int horCheckR(int r, int c, int player){
        int val = 0;
        boolean check = false;
        for(int t = 0; t < 7 - r; t++){
            if(board[r][t] == sides[player]){
                val = t;
                check = true;
                break;
            }
        } 
      if (check){
            return val;
        }
        else{
            return -1;
        }   
        
    }
    public int vertCheckDown(int r, int c, int player){
        int val = 0;
        boolean check = false;
        for(int t = 0; t < 7 - c; t++){
            if(board[r][t] == sides[player]){
                val = t;
                check = true;
                break;
            }
        } 
      if (check){
            return val;
        }
        else{
            return -1;
        }   
        
        
    }
    public int vertCheckUp(int r, int c, int player){
        int val = 0;
        boolean check = false;
        for(int t = r - 1; t > 0; t--){
            if(board[r][t] == sides[player]){
                val = t;
                check = true;
                break;
                
            }    
        }
        if (check){
            return val;
        }
        else{
            return -1;
        }
        
        
    }
    public int diagCheckUR(int r, int c, int player){
        int _r = r - 2;
        int _c = c + 2;
        int val = 0;
        boolean check = false;
        int loop = 1;
        if(c > 5 || r < 2){
            val= -1;
        }//no matchee matchee out there
        
        while( _r > 0 && _c < 8 && check == false){
            if(board[_r][_c] == sides[player]){
                val = loop;
                check = true;
                
            }//end if
            loop++;
            _r--;//going up!
            _c++;//going... right!
        }
        if(check){
            return val;
        }
        else{
            return -1;
        }    
        
        
        
    }
    public int diagCheckUL(int r, int c, int player){
        int _r = r - 2;
        int _c = c - 2;
        int val = 0;
        boolean check = false;
        int loop = 1;
        if(c < 2 || r < 2){
            val= -1;
        }
        while( _r > 0 && _c > 0 && check == false){
            if(board[_r][_c] == sides[player]){
                val = loop;
                check = true;
                
            }//end if
            loop++;
            _r--;//going up!
            _c--;//going... left!
        }
        if(check){
            return val;
        }
        else{
            return -1;
        } 
        
    }
    
    public int diagCheckDR(int r, int c, int player){
        int _r = r + 2;
        int _c = c + 2;
        int val = 0;
        boolean check = false;
        int loop = 1;
        if(c > 5 || r > 5){
            val = -1;
        }//no matches over there
        while( _r < 8 && _c <8 && check == false) {
            if(board[_r][_c] == sides[player]){
                val = loop;
                check = true;
                
            }//end if
            loop++;
            _r++;//going down!
            _c++;//going... right!
        }
        if(check){
            return val;
        }
        else{
            return -1;
        } 
        
    }
    public int diagCheckDL(int r, int c, int player){
        int _r = r + 2;
        int _c = c - 2;
        int val = 0;
        boolean check = false;
        int loop = 1;
         if(c < 2 || r > 5){
            return -1;
        }//sike no matches
         while( _r < 8 && _c > 0 && check == false) {
            if(board[_r][_c] == sides[player]){
                val = loop;
                check = true;
                
            }//end if
            loop++;
            _r++;//going down!
            _c--;//going... left!
        }
        if(check){
            return val;
        }
        else{
            return -1;
        }
        
        
    }
    
    public String toString(){
        
	String rowerino="";
	for(int i=0;i<8;i++){
	    for(int c=0; c<8; c++){
		rowerino += "" + board[i][c];
	    }
	    rowerino += "\n";
	
	    }
	
   return rowerino;
	    
	}//end toString
	
	public void masterFlip(int r, int c, int player){
	    horflip(r, c, player);
	    vertflip(r, c, player);
	    diagflip(r, c, player);
	}
	
    public void play(){
        String choice = "";
        String one = "1";
        String two = "2";
        int c = 0;
        int r = 0;
        System.out.println("Lets get to flipping around!");
        System.out.println( this );
        System.out.println( "One player(1) or two?(2)");
        try{
            choice = in.readLine();
            }
            catch( IOException e ) { }
        if(choice.equals(one)){//one player
        //oyve
        }//end one player
        if(choice.equals(two)){
            System.out.println("Two it is then!");
            System.out.println("Ok player one, you're X");
            System.out.println("Pick your column!");
            try{
             c = Integer.parseInt(in.readLine());
            }
            catch( IOException e ) { }
            
            System.out.println("And your row, dear sir or ma'am");
            try{
             r = Integer.parseInt(in.readLine());
            }
            catch( IOException e ) { }
            board[r][c] = sides[0];
            System.out.println(this);
            System.out.println("Lets see what flips!");
            try{
                Thread.sleep(1000);//pauses for a second
            }
            catch(InterruptedException e) { }
            masterFlip(r, c, 0);
            System.out.print(this);
            
            
            }//end two player    
        
    }//end play
    
    
    
    public boolean wincheck(){
        return gameover;
    }
    
    
    public static void main(String[] args){
        Othello game = new Othello();
        game.play();
        
        
    }//end main
	
}//end class