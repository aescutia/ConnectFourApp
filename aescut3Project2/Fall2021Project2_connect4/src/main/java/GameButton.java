import javafx.scene.control.Button;

public class GameButton extends Button {
    private String player;  // stores the player value
    private boolean place;  // true if player can place, false otherwise
    private int column;  // stores column location
    private int row;  // stores row location
    private boolean winningPiece;  // true if its a winning piece, false otherwise

    GameButton() {
        this.player = " ";
        this.place = false;
        this.column = 0;
        this.row = 0;
        this.winningPiece = false;
    }
    int getColumn() {
        return column;
    }
    int getRow() {
        return row;
    }
    void setColumn(int val) {
        column = val;
    }
    void setRow(int val) {
        row = val;
    }
    void setPlayer(String currPlayer) {
        this.player = currPlayer;
    }
    
    void setWinningPiece(boolean val) {
    	this.winningPiece = val;
    }
    
    boolean isWinningPiece() {
    	return this.winningPiece;
    }

    boolean canPlace() {
        return this.place;
    }

    String getPlayer() {
        return this.player;
    }

    void setPlace(boolean val) {
        this.place = val ;
    }
}