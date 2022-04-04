
public class GameLogic {
	private String theWinner;  // stores the winner of the game
	private boolean win;  // true if there is a winner, false otherwise
	
	GameLogic() {
		theWinner = " ";
		win = true;
	}
	
	public String getWinner() {
		return this.theWinner;
	}
	public boolean isWin() {
		return this.win;
	}
	
	public void setWin(boolean value) {
		this.win = value;
	}
	
	public void clearWinner() {
		this.theWinner = " ";
	}
	
	// checks if the 4 buttons passed in have the same player value
	//  if the values match then the game is won, else the game continues
	boolean matchingPieces (GameButton p1, GameButton p2, GameButton p3, GameButton p4) {
		if(p1.canPlace() == true || p2.canPlace() == true || p3.canPlace() == true || p4.canPlace() == true) {
			return false;
		}
		
		if((p1.getPlayer() == " ") || (p2.getPlayer() == " ") || (p3.getPlayer() == " ") || (p4.getPlayer() == " ")) {
			return false;
		}
		
		if((p1.getPlayer() == "p1") && (p2.getPlayer() == "p1") && (p3.getPlayer() == "p1") && (p4.getPlayer() == "p1")) {
			this.theWinner = "Player 1";
			p1.setWinningPiece(true);
			p2.setWinningPiece(true);
			p3.setWinningPiece(true);
			p4.setWinningPiece(true);
			return true;
		} else if((p1.getPlayer() == "p2") && (p2.getPlayer() == "p2") && (p3.getPlayer() == "p2") && (p4.getPlayer() == "p2")) {
			this.theWinner = "Player 2";
			p1.setWinningPiece(true);
			p2.setWinningPiece(true);
			p3.setWinningPiece(true);
			p4.setWinningPiece(true);
			return true;
		} else {
		  return false;
		}
	}
	
	// checking all possible ways to connect 4 diagonally from left to right
	boolean checkLtoRDiagonalWins (GameButton[][] board) {
		if(matchingPieces(board[2][0],board[3][1], board[4][2], board[5][3]) ||
		   matchingPieces(board[1][0],board[2][1], board[3][2], board[4][3]) ||
		   matchingPieces(board[2][1],board[3][2], board[4][3], board[5][4]) ||
		   matchingPieces(board[0][0],board[1][1], board[2][2], board[3][3]) ||
		   matchingPieces(board[1][1],board[2][2], board[3][3], board[4][4]) ||
		   matchingPieces(board[2][2],board[3][3], board[4][4], board[5][5]) ||
		   matchingPieces(board[0][1],board[1][2], board[2][3], board[3][4]) ||
		   matchingPieces(board[1][2],board[2][3], board[3][4], board[4][5]) ||
		   matchingPieces(board[2][3],board[3][4], board[4][5], board[5][6]) ||
		   matchingPieces(board[0][2],board[1][3], board[2][4], board[3][5]) ||
		   matchingPieces(board[1][3],board[2][4], board[3][5], board[4][6]) ||
		   matchingPieces(board[0][3],board[1][4], board[2][5], board[3][6]))
		{
			return true;
		} else {
			return false;
		}
	}
	
	// checking all possible ways to connect 4 diagonally from right to left
	boolean checkRtoLDiagonalWins (GameButton[][] board) {
		if(matchingPieces(board[5][3],board[4][4], board[3][5], board[2][6]) ||
		   matchingPieces(board[5][2],board[4][3], board[3][4], board[2][5]) ||
		   matchingPieces(board[4][3],board[3][4], board[2][5], board[1][6]) ||
		   matchingPieces(board[5][1],board[4][2], board[3][3], board[2][4]) ||
		   matchingPieces(board[4][2],board[3][3], board[2][4], board[1][5]) || 
		   matchingPieces(board[3][3],board[2][4], board[1][5], board[0][6]) ||
		   matchingPieces(board[5][0],board[4][1], board[3][2], board[2][3]) ||
		   matchingPieces(board[4][1],board[3][2], board[2][3], board[1][4]) ||
		   matchingPieces(board[3][2],board[2][3], board[1][4], board[0][5]) ||
		   matchingPieces(board[4][0],board[3][1], board[2][2], board[1][3]) ||
		   matchingPieces(board[3][1],board[2][2], board[1][3], board[0][4]) ||
		   matchingPieces(board[3][0],board[2][1], board[1][2], board[0][3]))
		{
			return true;
		} else {
			return false;
		}
	}
	
	// checking all possible ways to connect 4 horizontally
	boolean checkHorizontalWins (GameButton[][] board) {
		if(matchingPieces(board[0][0],board[0][1], board[0][2], board[0][3]) ||
		   matchingPieces(board[0][1],board[0][2], board[0][3], board[0][4]) ||
		   matchingPieces(board[0][2],board[0][3], board[0][4], board[0][5]) ||
		   matchingPieces(board[0][3],board[0][4], board[0][5], board[0][6]) ||
		   matchingPieces(board[1][0],board[1][1], board[1][2], board[1][3]) ||
		   matchingPieces(board[1][1],board[1][2], board[1][3], board[1][4]) ||
		   matchingPieces(board[1][2],board[1][3], board[1][4], board[1][5]) ||
		   matchingPieces(board[1][3],board[1][4], board[1][5], board[1][6]) ||
		   matchingPieces(board[2][0],board[2][1], board[2][2], board[2][3]) ||
		   matchingPieces(board[2][1],board[2][2], board[2][3], board[2][4]) ||
		   matchingPieces(board[2][2],board[2][3], board[2][4], board[2][5]) ||
		   matchingPieces(board[2][3],board[2][4], board[2][5], board[2][6]) ||
		   matchingPieces(board[3][0],board[3][1], board[3][2], board[3][3]) ||
		   matchingPieces(board[3][1],board[3][2], board[3][3], board[3][4]) ||
		   matchingPieces(board[3][2],board[3][3], board[3][4], board[3][5]) ||
		   matchingPieces(board[3][3],board[3][4], board[3][5], board[3][6]) ||
		   matchingPieces(board[4][0],board[4][1], board[4][2], board[4][3]) ||
		   matchingPieces(board[4][1],board[4][2], board[4][3], board[4][4]) ||
		   matchingPieces(board[4][2],board[4][3], board[4][4], board[4][5]) ||
		   matchingPieces(board[4][3],board[4][4], board[4][5], board[4][6]) ||
		   matchingPieces(board[5][0],board[5][1], board[5][2], board[5][3]) ||
		   matchingPieces(board[5][1],board[5][2], board[5][3], board[5][4]) ||
		   matchingPieces(board[5][2],board[5][3], board[5][4], board[5][5]) ||
		   matchingPieces(board[5][3],board[5][4], board[5][5], board[5][6]))
		{
			return true;
		} else {
			return false;
		}
	}
	
	// checking all possible ways to connect 4 vertically
	boolean checkVerticalWins (GameButton[][] board) {
		if(matchingPieces(board[5][0],board[4][0], board[3][0], board[2][0]) ||
		   matchingPieces(board[4][0],board[3][0], board[2][0], board[1][0]) ||
		   matchingPieces(board[3][0],board[2][0], board[1][0], board[0][0]) ||
		   matchingPieces(board[5][1],board[4][1], board[3][1], board[2][1]) ||
		   matchingPieces(board[4][1],board[3][1], board[2][1], board[1][1]) ||
		   matchingPieces(board[3][1],board[2][1], board[1][1], board[0][1]) ||
		   matchingPieces(board[5][2],board[4][2], board[3][2], board[2][2]) ||
		   matchingPieces(board[4][2],board[3][2], board[2][2], board[1][2]) ||
		   matchingPieces(board[3][2],board[2][2], board[1][2], board[0][2]) ||
		   matchingPieces(board[5][3],board[4][3], board[3][3], board[2][3]) ||
		   matchingPieces(board[4][3],board[3][3], board[2][3], board[1][3]) ||
		   matchingPieces(board[3][3],board[2][3], board[1][3], board[0][3]) ||
		   matchingPieces(board[5][4],board[4][4], board[3][4], board[2][4]) ||
		   matchingPieces(board[4][4],board[3][4], board[2][4], board[1][4]) ||
		   matchingPieces(board[3][4],board[2][4], board[1][4], board[0][4]) ||
		   matchingPieces(board[5][5],board[4][5], board[3][5], board[2][5]) ||
		   matchingPieces(board[4][5],board[3][5], board[2][5], board[1][5]) ||
		   matchingPieces(board[3][5],board[2][5], board[1][5], board[0][5]) ||
		   matchingPieces(board[5][6],board[4][6], board[3][6], board[2][6]) ||
		   matchingPieces(board[4][6],board[3][6], board[2][6], board[1][6]) ||
		   matchingPieces(board[3][6],board[2][6], board[1][6], board[0][6]))
		{
			return true;
		} else {
			return false;
		}
	}
	
	// calls the functions above to check for a win. If there
	// is a win, then return true, else, return false
	boolean checkWin(GameButton[][] board) {
		if(checkHorizontalWins(board)) {
			win = true;
			return win;
		} else if(checkVerticalWins(board)) {
			win = true;
			return win;
		} else if(checkLtoRDiagonalWins(board)) {
			win = true;
			return win;
		} else if(checkRtoLDiagonalWins(board)) {
			win = true;
			return win;
		} else {
			win = false;
			return win;	
		}
	}
}
