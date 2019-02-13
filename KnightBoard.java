public class KnightBoard {
  private int[][] board,moves;

  /**
  *@throws IllegalArgumentException when either parameter is negative
  */
  public KnightBoard(int startingRows, int startingCols) {
  	board = new int[startingRows][startingCols];
  	moves = new int[startingRows][startingCols];
  }

  public String toString() {

  }

  /**
  *@throws IllegalStateException when the board contains non-zero values.
	*@throws IllegalArgumentException when either parameter is negative or out of bounds.
	*/
	public boolean solve(int startingRow, int startingCol) {

	}

	/**
  *@throws IllegalStateException when the board contains non-zero values.
	*@throws IllegalArgumentException when either parameter is negative or out of bounds.
	*/
	public int countSolutions(int startingRow, int startingCol) {
		
	}
}
