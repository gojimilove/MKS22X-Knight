public class KnightBoard {
  private int[][] board,moves;
  private int[] rowMove,colMove;

  /**
  *@throws IllegalArgumentException when either parameter is negative
  */
  public KnightBoard(int startingRows, int startingCols) {
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
    fillMoves();
    rowMove = new int[]{-2,-2,-1,1,2,2,-1,1};
    colMove = new int[]{-1,1,2,2,-1,1,-2,-2};
  }

  public void fillMoves() {
    if (moves.length > 3 && moves[0].length > 3) {
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

  public boolean addKnight(int r, int c) {
    if (r < 0 || r >= board.length || c < 0 || c >= board.length || board[r][c] != 0) return false;
    else {
      board[r][c] = 1;
      return true;
    }
  }

  public boolean removeKnight(int r, int c) {
    if (r < 0 || r >= board.length || c < 0 || c >= board.length || board[r][c] == 0) return false;
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
		addKnight(startingRow, startingCol);
		return solveH(startingRow, startingCol, 2);
	}

  private boolean solveH(int row, int col, int count) {
    if (count > board.length * board[0].length) {
      return true;
    }
    else {
    	for (int i = 0; i < 8; i++) {
    		if (addKnight(row+rowMove[i], col+colMove[i])) {
    			System.out.println(toString());
    			System.out.println(count);
    			
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
		return 0;
	}
}
