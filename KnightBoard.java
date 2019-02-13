public class KnightBoard {
  private int[][] board,moves;

  /**
  *@throws IllegalArgumentException when either parameter is negative
  */
  public KnightBoard(int startingRows, int startingCols) {
  	board = new int[startingRows][startingCols];
  	moves = new int[startingRows][startingCols];
  }
}
