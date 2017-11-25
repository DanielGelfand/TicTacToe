import cs1.Keyboard;

public class Tic{

    private static final  String[][] BOARD = {

	{"1","2","3"},
	{"4","5","6"},
	{"7","8","9"}
    };
	

    private String[][] _board;
    
    public Tic(){
        //allocated memory for _board
	_board = new String[BOARD.length][BOARD[0].length];
	for(int sub = 0; sub < BOARD.length; sub +=1){
	    for(int i = 0; i < BOARD[0].length;i+=1){
		_board[sub][i] = BOARD[sub][i];
	    }
	}
    }


    //postcond: prints each row of 2D int array a on its own line
    //uses a FOREACH loop
    public static void print( String[][] a )
    {
	String result = "{";
	for(String[] sub: a){
	    for(String i: sub){
		result +=   i + ",";
	    }
	    //.substring() used to remove last comma
	    System.out.println(result.substring(0,result.length()-1) + "}");
	    //reset result for next row
	    result = "{";
	}
    }

    //used to play a game of tic-tac-toe
    public void play(){

	System.out.println("Player 1 is x");
	System.out.println("Player 2 is o");
	System.out.println();

	print(_board);

	//avoids asking other player for input if the other has already won
	if(win() == false){
	System.out.println("Player 1 - Input a position(1-9): ");
	int xPos = Keyboard.readInt();
	replace(xPos,"x","o");
	
	print(_board);
	}

	if(win()==false){
	System.out.println("Player 2 - Input a position(1-9): ");
	int oPos = Keyboard.readInt();
	replace(oPos,"o","x");
	
	print(_board);
	}
    }
    
    //replaces a board number with an x or an o
    public void replace(int pos, String str, String opp){
	
	
	if(pos < 4){
	    //avoids replacing other player's input
	    if(!_board[0][pos-1].equals(opp))
		{ _board[0][pos-1] = str;}
	    
	}
	else if(pos < 7){
	    if(!_board[1][pos-4].equals(opp))
		{_board[1][pos-4] = str;}
	    	
	}
	else{
	    if(!_board[2][pos-7].equals(str))
		{_board[2][pos-7]=str;}
	}
    }

    public boolean win(){

	return 	checkRow() || checkColumn() || checkDiagonal();
        
    }

    //checks if one of the columns have all x's or all o's
    public boolean checkColumn(){

	for(int j = 0; j < _board[0].length; j+=1){
	    if(_board[1][j].equals(_board[1][j]) && _board[1][j].equals(_board[2][j])){
	
		return true;
	    }
	}
	return false;
    }

    //checks if one of the rows have all x's or all o's
    public boolean checkRow(){
	for(int i = 0; i < _board.length; i+=1){
	    if(_board[i][0].equals(_board[i][1]) && _board[i][1].equals(_board[i][2])){
	
		return true;
	    }
	  
	}
	return false;
    }

    //checks if diagonals have all x's or all o's
    public boolean checkDiagonal(){

	return( _board[0][0].equals(_board[1][1]) && _board[1][1].equals(_board[2][2])) ||
	    (_board[0][2].equals(_board[1][1]) && _board[1][1].equals(_board[2][0]));

    }
		
	        
    
    public static void main(String[] args){
	Tic game1 = new Tic();
	
        while(game1.win() == false){
	    game1.play();
	}
	System.out.println();
	System.out.println("We have a winner!");
	    

    }

}//end class
