public class KnightBoard {
  private int[][] board,moves;

  /**
  *@throws IllegalArgumentException when either parameter is negative
  */
  public KnightBoard(int startingRows, int startingCols) {
  	board = new int[startingRows][startingCols];
  	int num = 1;
  	for (int i = 0; i < board.length; i++) {
  		for (int j = 0; j < board[0].length; j++) {
  			board[i][j] = num;
  			num++;
  		}
  	}
  	moves = new int[startingRows][startingCols];
  	if (startingRows > 3 && startingCols > 3) {
	  	for (int i = 0; i < moves.length; i++) {
	  		for (int j = 0; j < moves[0].length; j++) {
	  			if (i < 2 || i > moves.length-3 || j < 2 || j > moves[0].length-3) {
	  				if ((i == 0 || i == moves.length-1) && (j == 0 || j == moves[0].length-1)) {
	  					moves[i][j] = 2;
	  				} else if ((i == 1 && j == 0) ||
	  									 (i == 1 && j == moves[0].length-1) ||
	  									 (i == 0 && j == 1) ||
	  									 (i == 0 && j == moves[0].length-2) ||
	  									 (i == moves.length-2 && j == 0) ||
	  									 (i == moves.length-2 && j == moves[0].length-1) ||
	  									 (i == moves.length-1 && j == 1) ||
	  									 (i == moves.length-1 && j == moves[0].length-2)) {
	  					moves[i][j] = 3;
	  				} else if (i == 0 || 
	  									i == moves.length-1 || 
	  									j == 0 || 
	  									j == moves[0].length-1 ||
	  									(i == 1 && j == 1) ||
	  									(i == 1 && j == moves[0].length-2) ||
	  									(i == moves.length-2 && j == 1) ||
	  									(i == moves.length-2 && j == moves[0].length-2)) {
	  					moves[i][j] = 4;
	  				} else if (i == 1 || i == moves.length-2 || j == 1 || j == moves[0].length-2){
	  					moves[i][j] = 6;
	  				}
	  			}
	  			else moves[i][j] = 8;
	  		}
	  	}
	  }
  }

  public String toString() {
  	String s = "";
  	for (int i = 0; i < board.length; i++) {
  		for (int j = 0; j < board[0].length; j++) {
  			if (board[i][j] < 10) s = s + " " + board[i][j] + " ";
  			else s += board[i][j] + " ";
  		}
  		s+="\n";
  	}
  	return s;
  }

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
	*/
	public boolean solve(int startingRow, int startingCol) {
		return false;
	}

	/**
  *@throws IllegalStateException when the board contains non-zero values.
	*@throws IllegalArgumentException when either parameter is negative or out of bounds.
	*/
	public int countSolutions(int startingRow, int startingCol) {
		return 0;
	}
}
