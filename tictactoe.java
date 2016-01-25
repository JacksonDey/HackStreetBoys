import java.io.*;
import java.util.*;
public class tictactoe extends Game{
    private String[][] board;
    private boolean player;
    private InputStreamReader isr;
    private BufferedReader in;
    int turnctr = 0;
    boolean check;
    int nay = 0;
    
    public tictactoe(){
        board= new String[3][3];
        fill();
        isr = new InputStreamReader( System.in );
	    in = new BufferedReader( isr );
    }
    public void fill(){
        for(int i=0;i<3;i++){
            for(int c=0;c<3;c++){
                board[i][c]="|   |";
            }
        }
    }
    public void makemove(int i, int c){
        if(player){
            board[i][c]="| X |";
        }
        else{
            botdavid();
        }
    }
    public int corners(){
        int retint=0;
        for(int i=0;i<3;i+=2){
            for(int c=0;c<3;c+=2){
                if(board[i][c].equals("|   |")){
                    retint+=1;
                }
            }
        }
        return retint;
    }
    public boolean isEmpty(int i, int c){
        return board[i][c].equals("|   |");
    }
    public boolean mine(int i, int c){
        return board[i][c].equals("| O |");
    }
    public int movecount(){
        int count=0;
        for(int i=0;i<3;i++){
            for(int c=0;c<3;c++){
                if(!board[i][c].equals("|   |")){
                    count+=1;
                }
            }
        }
        return count;
    }
    
    public void botdavid(){
        int move=0;
        boolean choice1=isEmpty(0,0);
        boolean choice2=isEmpty(0,2);
        boolean choice3=isEmpty(2,0);
        boolean choice4=isEmpty(2,2);
        boolean choice5=mine(0,0);
        boolean choice6=mine(0,2);
        boolean choice7=mine(2,0);
        boolean choice8=mine(2,2);
        boolean choice9=isEmpty(2,1);
        boolean choice10=isEmpty(1,0);
        boolean choice11=isEmpty(0,1);
        boolean choice12=isEmpty(1,2);
        while(move<1){
        if (movecount()<4){
            
        
        if(choice1){
            board[0][0]="| O |";
             move++;
             break;
        }
        if(choice4){
            board[2][2]="| O |";
             move++;
             break;
        }
        if(choice2){
            board[0][2]="| O |";
             move++;
             break;
        }
        if(choice3){
            board[2][0]="| O |";
             move++;
             break;
        }
        }
        if (corners()<3){
        if(choice5 && choice8 && isEmpty(1,1)){
            board[1][1]="| O |";
             move++;
             break;
        }
        else if(choice5 && choice8 && choice2){
            board[0][2]="| O |";
             move++;
             break;
        }
        else if(choice5 && choice8 && choice3){
            board[2][0]="| O |";
             move++;
             break;
        }
        else if(choice6&& choice7 && isEmpty(1,1)){
            board[1][1]= "| O |";
             move++;
             break;
        }
        else if(choice6&&choice7&&choice1){
            board[0][0]="| O |";
             move++;
             break;
        }
        else if(choice6&&choice7&&choice4){
            board[2][2]="| O |";
            move++;
            break;
        }
    }
        if(choice5&& choice6&& choice11){
            board[0][1]="| O |";
            move++;
            break;
        }
        else if(choice5&& choice7 &&choice10){
            board[1][0]="| O |";
            move++;
            break;
        }
        else if(choice5&& choice8&&isEmpty(1,1)){
            board[1][1]="| O |";
            move++;
            break;
        }
        else if(choice6&& choice7&&isEmpty(1,1)){
            board[1][1]="| O |";
             move++;
             break;
        }
        else if(choice6&& choice8&&choice12){
            board[1][2]="| O |";
             move++;
             break;
        }
        else if(choice8&& choice7 && choice9){
            board[2][1]="| O |";
             move++;
             break;
        }
        else{
            board[(int)Math.random()*3][(int)Math.random()*3]="| O |";
            move++;
                break;
            }   
        
            }
            move=0;
       }       
             

        
    public boolean notcheck(){
        check = false;
        if(
            
            
            
            board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && board[0][2].equals("| X |") ||
            board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) && board[1][2].equals("| X |") ||
            board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) && board[2][2].equals("| X |") ||
            board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[2][2].equals("| X |") ||
            board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && board[2][0].equals("| X |") ||
            board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && board[2][0].equals("| X |") ||
            board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && board[2][1].equals("| X |") ||
            board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && board[2][0].equals("| X |") ||
            board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && board[2][2].equals("| X |")
           ){
               check = true;
               System.out.println("Wow, you won!");;
           }
   else if( board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && board[0][2].equals("| O |") ||
            board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) && board[1][2].equals("| O |") ||
            board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) && board[2][2].equals("| O |") ||
            board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[2][2].equals("| O |") ||
            board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && board[2][0].equals("| O |") ||
            board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && board[2][0].equals("| O |") ||
            board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && board[2][1].equals("| O |") ||
            board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && board[2][0].equals("| O |") ||
            board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && board[2][2].equals("| O |") 
           ){
               check = true;
               System.out.println("Wow, you LOST!  Way to go");
           }
           else{
               check = false;
           }
           return check;
    }
    public String toString(){
    String rowerino="";
    	for(int i=0;i<3;i++){
    	    for(int c=0; c<3; c++){
    		    rowerino+=board[i][c];
    	    }
    	    rowerino+="\n";
	}
	
	return rowerino;
    }   
    public boolean wincheck(){
        int ret=0;
        for(int i=0;i<3;i++){
            for(int c=0;c<3;c++){
                if((board[i][c].equals("| X |") )|| (board[i][c].equals("| O |"))){
                    ret+=1;
                }
            }
        }
        return ret==9|| check;
    }

    public void play(){
        int c = 0;
        int r = 0;
        player=true;
        System.out.println("Lets get ready to ruuuuuuuummmmmmmmmmbleee");
        while(!wincheck()){
            player=true;
            System.out.println(this);
            System.out.println("Where ya wanna go, eh punk? Which row?");
            try{
                 c = Integer.parseInt(in.readLine());
             }
            catch( IOException e ) { }
            System.out.println("Ay bucko! I almost forgot to ask the collumn!");
            try{
                 r = Integer.parseInt(in.readLine());
            }
            catch( IOException e ) { }
            makemove(c , r);
            player = false;
            makemove(0,0);
            notcheck();
            
        }//end while
        if(!check){
            System.out.println("Wowee, a tie!...Not bad for a scrub");
        }
        System.out.println("Wanna play some more games? Yee(1) or naw(2)");
                try{
                nay = Integer.parseInt(in.readLine());
                }
                catch( IOException e ) { }
                if(nay == 1){
                amishArcade.displayGames();

            }
    }//end play
    public static void main(String[] Args){
        tictactoe david = new tictactoe();
        david.play();

    }
    
}//end class
