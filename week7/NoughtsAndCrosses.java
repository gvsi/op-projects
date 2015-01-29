public class NoughtsAndCrosses {
	private int[][] board;
	public NoughtsAndCrosses(int[][] board) {
		this.board = board;
	}
	
	public boolean isDraw() {
		return whoWon() == 0;
	}
	
	public int whoWon() {
		for (int i = 1; i <= 2; i++) {
			if ((board[0][0] == i && board[0][1] == i && board[0][2] == i) ||
					(board[1][0] == i && board[1][1] == i && board[1][2] == i) ||
					(board[2][0] == i && board[2][1] == i && board[2][2] == i) ||
					(board[0][0] == i && board[1][0] == i && board[2][0] == i) ||
					(board[0][1] == i && board[1][1] == i && board[2][1] == i) ||
					(board[0][2] == i && board[1][2] == i && board[2][2] == i) ||
					(board[0][0] == i && board[1][1] == i && board[2][2] == i) ||
					(board[0][2] == i && board[1][1] == i && board[2][0] == i)
					) {
				return i;
			}
		}
		return 0;
	}
}