public class KnightBoard {
  private int[][] board,moves;
  private int[] rowMove,colMove;
  private int counter;

  /**
  *@throws IllegalArgumentException when either parameter is negative
  */
  public KnightBoard(int startingRows, int startingCols) {
  	//if either parameter is negative
  	if (startingRows < 0 || startingCols < 0) {
  		throw new IllegalArgumentException("parameters can't be negative");
  	}
  	board = new int[startingRows][startingCols];
  	//int num = 1;
  	for (int i = 0; i < board.length; i++) {
  		for (int j = 0; j < board[0].length; j++) {
  			board[i][j] = 0;
        //board[i][j] = num;
  			//num++;
  		}
  	}
  	moves = new int[startingRows][startingCols];
    fillMoves(); //fills the new board with how many moves are possible from each square
    rowMove = new int[]{-2,-2,-1,1,2,2,-1,1}; //row component of all 8 moves
    colMove = new int[]{-1,1,2,2,-1,1,-2,-2}; //col component of all 8 moves
    counter = 0;
  }

  public void fillMoves() {
    if (moves.length > 3 && moves[0].length > 3) {
	  	for (int i = 0; i < moves.length; i++) {
	  		for (int j = 0; j < moves[0].length; j++) {
	  			if (i < 2 || i > moves.length-3 || j < 2 || j > moves[0].length-3) {
	  				if ((i == 0 || i == moves.length-1) && (j == 0 || j == moves[0].length-1)) {
	  					moves[i][j] = 2; //corners
	  				} else if ((i == 1 && j == 0) ||
	  									 (i == 1 && j == moves[0].length-1) ||
	  									 (i == 0 && j == 1) ||
	  									 (i == 0 && j == moves[0].length-2) ||
	  									 (i == moves.length-2 && j == 0) ||
	  									 (i == moves.length-2 && j == moves[0].length-1) ||
	  									 (i == moves.length-1 && j == 1) ||
	  									 (i == moves.length-1 && j == moves[0].length-2)) {
	  					moves[i][j] = 3; //next layer
	  				} else if (i == 0 ||
	  									i == moves.length-1 ||
	  									j == 0 ||
	  									j == moves[0].length-1 ||
	  									(i == 1 && j == 1) ||
	  									(i == 1 && j == moves[0].length-2) ||
	  									(i == moves.length-2 && j == 1) ||
	  									(i == moves.length-2 && j == moves[0].length-2)) {
	  					moves[i][j] = 4; //next layer
	  				} else if (i == 1 || i == moves.length-2 || j == 1 || j == moves[0].length-2){
	  					moves[i][j] = 6; //middle edges
	  				}
	  			}
	  			else moves[i][j] = 8; //middle spaces
	  		}
	  	}
	  }
  }

  public boolean addKnight(int r, int c) {
    //if out of bounds return false
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 0) return false;
    else {
      board[r][c] = 1;
      return true;
    }
  }

  public boolean removeKnight(int r, int c) {
  	//if out of bounds return false
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 0) return false;
    else {
      board[r][c] = 0;
      return true;
    }
  }

  /**
  *@return the properly formatted string
  */
  public String toString() {
  	String s = "";
  	for (int i = 0; i < board.length; i++) {
  		for (int j = 0; j < board[0].length; j++) {
  			if (board[i][j] < 10) {
          if (board[i][j] >= 0) s = s + " " + board[i][j] + " ";
          else s += board[i][j] + " ";
        }
  			else s += board[i][j] + " ";
  		}
  		s+="\n";
  	}
  	return s;
  }

  /**
  *@return properly formatted string of the moves board
  */
  public String printMoves() {
  	String s = "";
  	for (int i = 0; i < moves.length; i++) {
  		for (int j = 0; j < moves[0].length; j++) {
  			if (moves[i][j] < 10) s = s + " " + moves[i][j] + " ";
  			else s += moves[i][j] + " ";
  		}
  		s+="\n";
  	}
  	return s;
  }

  /**
  *@throws IllegalStateException when the board contains non-zero values.
	*@throws IllegalArgumentException when either parameter is negative or out of bounds.
  *@return true when the board is solvable from the specified starting position
	*/
	public boolean solve(int startingRow, int startingCol) {
		//if the board starts with non-zero values throw exception
  	for (int i = 0; i < board.length; i++) {
  		for (int j = 0; j < board[0].length; j++) {
  			if (board[i][j] != 0) throw new IllegalStateException("the board is not empty");
  		}
  	}
  	//either parameter is negative or out of bounds
  	if (startingRow < 0 || startingRow >= board.length || 
  			startingCol < 0 || startingCol >= board[0].length) {
  		throw new IllegalArgumentException("starting parameters are out of bounds");
  	}
  	//initial knight placed at starting position
  	addKnight(startingRow, startingCol);
		return solveH(startingRow, startingCol, 2);
	}

  private boolean solveH(int row, int col, int count) {
    if (count > board.length * board[0].length) { //base case: when all spaces on the board have a knight
    	//System.out.println(toString());
      return true;
    }
    else {
    	for (int i = 0; i < 8; i++) {
    		if (addKnight(row+rowMove[i], col+colMove[i])) { //check the 8 moves see if they're valid
    			//System.out.println(toString());
    			//System.out.println(count);
    			if (solveH(row+rowMove[i],col+colMove[i],count+1)) return true;
    			removeKnight(row+rowMove[i],col+colMove[i]);
    		}
    	}
    }
    return false;
  }

	/**
  *@throws IllegalStateException when the board contains non-zero values.
	*@throws IllegalArgumentException when either parameter is negative or out of bounds.
  *@return the number of solutions from the starting position specified
	*/
	public int countSolutions(int startingRow, int startingCol) {
		//if the board starts with non-zero values throw exception
  	for (int i = 0; i < board.length; i++) { //base case: when all spaces on the board have a knight
  		for (int j = 0; j < board[0].length; j++) {
  			if (board[i][j] != 0) throw new IllegalStateException("the board is not empty");
  		}
  	}
  	//either parameter is negative or out of bounds
  	if (startingRow < 0 || startingRow >= board.length || 
  			startingCol < 0 || startingCol >= board[0].length) {
  		throw new IllegalArgumentException("starting parameters are out of bounds");
  	}
  	//initial knight placed at starting position
  	addKnight(startingRow, startingCol);
  	//find solutions, add up counter
		countH(startingRow, startingCol, 2);
		//clear board (remove initial knight)
		removeKnight(startingRow, startingCol);
		return counter;
	}

  private boolean countH(int row, int col, int count) {
    if (count > board.length * board[0].length) {
    	counter++; //if a solution is found add it up
    }
    else {
    	for (int i = 0; i < 8; i++) {
    		if (addKnight(row+rowMove[i], col+colMove[i])) { //check the 8 moves see if they're valid
    			//System.out.println(toString());
    			//System.out.println(count);
    			if (countH(row+rowMove[i],col+colMove[i],count+1)) return true;
    			removeKnight(row+rowMove[i],col+colMove[i]);
    		}
    	}
    }
    return false;
  }
}
