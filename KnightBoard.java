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
