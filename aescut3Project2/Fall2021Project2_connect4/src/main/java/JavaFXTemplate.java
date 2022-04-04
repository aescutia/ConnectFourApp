import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * CS 342 Project 2: Connect 4
 * By: Saul Avila and Alexis Escutia
 * NetIDs: savila25, aescut3
 * UINs: 665919711, 679743479
*/

public class JavaFXTemplate extends Application {
	private Button start;
	private Button turnDisplay;  // displays the current player
	private MenuBar menu;
	private EventHandler gameHandler;
	private HashMap<String,Scene> sceneMap;  // stores the scenes used in program
	private GridPane grid;
	private BorderPane gamePane;
	private TextField Moves;  // displays the moves made on the game scene
	PauseTransition delay;
	private int player = 1;
	private GameButton bGrid[][] = new GameButton [6][7];
	private ArrayList<turns> turnList = new ArrayList<>();  // List containing every turn
	private String p1Color;  // styling for player 1 pieces based on current theme
	private String p2Color;  // styling for player 2 pieces based on current theme
	private String defaultPiece;  // styling for unclaimed pieces on board based on current theme
	private int Turn;
	private GameLogic logic = new GameLogic();
	private Stage currentStage;

	public static void main(String[] args) {
		launch(args);
	}
	
	// Stores info based on every turn. Holds coordinate and
	// player for each turn. Used for undo but also for List View
	private class turns{
		int x;
		int y;
		int who;
		
		turns(int row, int column, int val){
			x = row;
			y = column;
			who = val;
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to Connect Four!");
		currentStage = primaryStage;
		start = new Button("Play");
	    start.setOnAction(e -> primaryStage.setScene(sceneMap.get("game")));
		createGameHandler();
		createMenu();
		delay = new PauseTransition(Duration.seconds(3));
		sceneMap = new HashMap<String, Scene>();
		sceneMap.put("welcome", makeWelcomeScene());
		sceneMap.put("game", makeGameScene());
		sceneMap.put("howTo", makeHowToScene());
		sceneMap.put("draw", makeTieScene());
		primaryStage.setScene(sceneMap.get("welcome"));
		primaryStage.show();
	}
	
	// Sets to original theme 
	void setOriginalTheme() {
		gamePane.setStyle("-fx-background-color: white;");
		p1Color = "-fx-background-color: red;" + "-fx-border-color: black;" + "-fx-font-size: 25;";
		p2Color = "-fx-background-color: yellow;" + "-fx-border-color: black;" + "-fx-font-size: 25;";
		defaultPiece = "-fx-background-color: grey;" + "-fx-border-color: black;" + "-fx-font-size: 25;";
		for (GameButton[] temp : bGrid) {
			for (GameButton temp2 : temp) {
				if (temp2.getPlayer() != " ") {
					if(temp2.getPlayer() == "p1") {
						temp2.setStyle(p1Color);
					} else {
						temp2.setStyle(p2Color);
					}
				} else {
					temp2.setStyle("-fx-background-color: grey;" + "-fx-border-color: black;" + "-fx-font-size: 25;");
				}
			}
			if(player == 1) {
				turnDisplay.setStyle(p1Color);
			} else {
				turnDisplay.setStyle(p2Color);
			}
		}
	}
	
	// Sets screen to theme 1
	void setThemeOne() {
		gamePane.setStyle("-fx-background-image: url('ATbackground.jpg');");
		p1Color = "-fx-background-image: url('finnS.jpg');" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center center;"
				+ "-fx-border-color: black;" + "-fx-font-size: 25;" + "-fx-text-fill: white;";
		p2Color = "-fx-background-image: url('jakes.jpg');" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center center;"
				+ "-fx-border-color: black;" + "-fx-font-size: 25;" + "-fx-text-fill: white;";
		defaultPiece = "-fx-background-color: teal;" + "-fx-border-color: black;" + "-fx-font-size: 25;";
		for (GameButton[] temp : bGrid) {
			for (GameButton temp2 : temp) {
				if (temp2.getPlayer() != " ") {
					System.out.println(temp2.getPlayer());
					if(temp2.getPlayer() == "p1") {
						temp2.setStyle(p1Color);
					} else {
						temp2.setStyle(p2Color);
					}
				} else {
					temp2.setStyle(defaultPiece);
				}
			}
		}
		if(player == 1) {
			turnDisplay.setStyle(p1Color);
		} else {
			turnDisplay.setStyle(p2Color);
		}
	}
	
	// Sets screen to theme 2
	void setThemeTwo() {
		gamePane.setStyle("-fx-background-image: url('FinalValley.jpg');");
		p1Color = "-fx-background-image: url('UzumakiLogo.jpeg');" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center center;"
				+ "-fx-border-color: black;" + "-fx-font-size: 25;" + "-fx-text-fill: white;"; 
		p2Color = "-fx-background-image: url('UchihaLogo.jpeg');" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center center;"
				+ "-fx-border-color: black;" + "-fx-font-size: 25;" + "-fx-text-fill: black;";
		defaultPiece = "-fx-background-color: lightgrey;" + "-fx-border-color: black;" + "-fx-font-size: 25;";
		for (GameButton[] temp : bGrid) {
			for (GameButton temp2 : temp) {
				if (temp2.getPlayer() != " ") {
					System.out.println(temp2.getPlayer());
					if(temp2.getPlayer() == "p1") {
						temp2.setStyle(p1Color);
					} else {
						temp2.setStyle(p2Color);
					}
				} else {
					temp2.setStyle("-fx-background-color: lightgrey;" + "-fx-border-color: black;" + "-fx-font-size: 25;");
				}
			}
		}
		if(player == 1) {
			turnDisplay.setStyle(p1Color);
		} else {
			turnDisplay.setStyle(p2Color);
		}
	}
	
	public Scene makeWelcomeScene() {
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(200));
		pane.setCenter(start);
		pane.setStyle("-fx-background-image: url('Connect4Logo.jpeg');" + "-fx-background-size: 900 800;" + "-fx-background-position: center center;" + "-fx-font-size: 50;" + "-fx-font-family: 'serif'");
		return new Scene(pane, 900, 800);
	}
	
	public Scene makeHowToScene() {
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-image: url('thinking.jpg');" + "-fx-background-size: 900 800;" + "-fx-font-size: 30;" + "-fx-font-family: 'serif'");
		Button back = new Button("Back");
		back.setOnAction(e->{currentStage.setScene(sceneMap.get("game")); currentStage.show();});
		Text instructions;
		pane.setPadding(new Insets(50));
		instructions = new Text();
		instructions.setText("Welcome to Connect 4! \n" + "Here are the rules: \n" + "This game is meant for two players."
				+ " Players will take turns picking\n"
				+ "a square on the grid according to where they want their piece.\n"
				+ "In order to win, one player must get 4 of \n"
				+ "their pieces alligned either vertically, horizontally, \n"
				+ "or diagonally.\n"
				+ "If no players are able to allign 4 of their pieces\n"
				+ "before the grid fills up, the game will end in a tie\n"
				+ "The undo button reverses the most recent piece placed\n"
				+ "and updates the turn accordingly. \n"
				+ "Undo may be used as long as there is a piece\n"
				+ "on the board to undo.\n"
				+ "Themes may be switched at any point while playing. \n"
				+ "A new game can be started at any point in the game.\n"
				+ "Players can close and exit the game at any point in the game\n"
				+ "Have Fun! ");
		instructions.setFill(Color.BLACK);
		
		VBox paneCenter = new VBox(100, instructions, back);
		//paneCenter.setAlignment(Pos.BASELINE_CENTER);
		pane.setCenter(paneCenter);
		//pane.setStyle("-fx-background-color: azure;" + "-fx-font-size: 25;" + "-fx-font-family: 'serif'");
		return new Scene(pane, 900, 800);
	}
	
	public Scene makeWiningScene() {
		BorderPane pane = new BorderPane();
		Text winningText = new Text("Game Over! " + logic.getWinner() + " is the Winner!");
		Button exit = new Button("Exit");
		exit.setOnAction(e->currentStage.close());
		Button playAgain = new Button("Play Again");
		playAgain.setOnAction(e->{resetGame(); currentStage.setScene(sceneMap.get("game")); currentStage.show();});
		winningText.setFill(Color.WHITE);
		winningText.setStyle("-fx-font-size: 55;");
		HBox h1 = new HBox(50, playAgain, exit);
		VBox v1 = new VBox(20, winningText, h1);
		v1.setAlignment(Pos.CENTER);
		h1.setAlignment(Pos.CENTER);
		pane.setCenter(v1);
		pane.setPadding(new Insets(55));
		pane.setStyle("-fx-background-image: url('GoldConfetti.jpeg');" + "-fx-font-size: 25;" + "-fx-font-family: 'serif'");
		return new Scene(pane, 900, 800);
	}
	
	public Scene makeTieScene() {
		BorderPane pane = new BorderPane();
		Text drawText = new Text("It's a Draw!");
		Button exit = new Button("Exit");
		exit.setOnAction(e->currentStage.close());
		Button playAgain = new Button("Play Again");
		playAgain.setOnAction(e->{resetGame(); currentStage.setScene(sceneMap.get("game")); currentStage.show();});
		drawText.setFill(Color.WHITE);
		drawText.setStyle("-fx-font-size: 50;");
		HBox h1 = new HBox(50, playAgain, exit);
		VBox v1 = new VBox(20, drawText, h1);
		v1.setAlignment(Pos.CENTER);
		pane.setCenter(v1);
		pane.setPadding(new Insets(300));
		pane.setStyle("-fx-background-image: url('MichaelScott.jpeg');" + "-fx-background-repeat: no-repeat;"
					+ "-fx-background-position: center center;" + "-fx-font-size: 25;" + "-fx-font-family: 'serif'");
		return new Scene(pane, 900, 800);
	}
	
	public Scene makeGameScene() {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		turnDisplay = new Button("Turn");
		turnDisplay.setPrefHeight(100);
		turnDisplay.setPrefWidth(100);
		addGrid(grid); //populate the GridPane with buttons
		grid.setHgap(8);
		grid.setVgap(8);
		Turn = 0;
		Moves = new TextField();
		Moves.setDisable(true);
		HBox box2 = new HBox(20,grid,turnDisplay);
		box2.setAlignment(Pos.CENTER);
		VBox box1 = new VBox(30,menu, box2, Moves);
		gamePane = new BorderPane(box1);
		gamePane.setStyle("-fx-background-color: white;");
		box1.setStyle("-fx-font-family: 'serif'");
		return new Scene(gamePane, 900,800);
	}
	
	// undoes the most recent move
	void undoMove() {
		// Makes sure there is a turn to undo
		if(turnList.size() == 0) {
			Moves.setText("No Move available to undo");
		} else {
			turns temp = turnList.get(turnList.size()-1);  // gets last turn made
			if(temp.x == 5) {  // if undone piece is in bottom row
				bGrid[temp.x][temp.y].setPlace(true); 
				bGrid[temp.x-1][temp.y].setPlace(false);  // if a piece that lied on the bottom row is undone, disables button above the undone piece
			} else if (bGrid[temp.x+1][temp.y].canPlace() == false) {  // if piece below can be placed, enable undone piece to be placed
				bGrid[temp.x][temp.y].setPlace(true);
				if (temp.x != 0) {
					bGrid[temp.x-1][temp.y].setPlace(false);
				}
			}	
			bGrid[temp.x][temp.y].setPlayer(" ");  // sets button to no player
			bGrid[temp.x][temp.y].setStyle(defaultPiece);  // sets color to default color based on theme 
			turnList.remove(turnList.size()-1);  // removes the last turn from the list
			Turn --;  // decreases turn by 1
				
			// Updates turn display
			if(player == 2) {
				player = 1;
				turnDisplay.setStyle(p1Color);
			} else if (player == 1) {
				player = 2;
				turnDisplay.setStyle(p2Color);
			}
			Moves.setText("Undid the last move. It's now Player " + player + "'s turn");
		}
	}
	
	void createMenu() {
		menu = new MenuBar();
		
		// creating menu bar
		Menu mOne = new Menu("Game Play");
		Menu mTwo = new Menu("Themes");
		Menu mThree = new Menu("Options");
		
		// creating menu items
		MenuItem iOne = new MenuItem("Reverse Move");
		MenuItem iTwo = new MenuItem("Original Theme");
		MenuItem iThree = new MenuItem("Theme 1");
		MenuItem iFour = new MenuItem("Theme 2");
		MenuItem iFive = new MenuItem("How To Play");
		MenuItem iSix = new MenuItem("New Game");
		MenuItem iSeven = new MenuItem("Exit");
		
		// adding action events for each menu item
		iOne.setOnAction(e->undoMove()); 
		iTwo.setOnAction(e->setOriginalTheme());
		iThree.setOnAction(e -> setThemeOne());
		iFour.setOnAction(e->setThemeTwo());
		iFive.setOnAction(e->{currentStage.setScene(sceneMap.get("howTo")); currentStage.show();});
		iSix.setOnAction(e->resetGame());
		iSeven.setOnAction(e->currentStage.close()); 
		
		// adding items to menu
		mOne.getItems().add(iOne); 
		mTwo.getItems().add(iTwo);
		mTwo.getItems().add(iThree);
		mTwo.getItems().add(iFour); 
		mThree.getItems().add(iFive);
		mThree.getItems().add(iSix);
		mThree.getItems().add(iSeven);
		menu.getMenus().addAll(mOne, mTwo, mThree);  // adding menus to bar
	}
	
	// creates a New game. Clears board of all pieces as well as sets the turn to 0 and clears the turn list.
	void resetGame() {
		for (GameButton[] temp : bGrid) {
			for (GameButton temp2 : temp) {
				temp2.setPlayer(" ");
				temp2.setStyle(defaultPiece);
				temp2.setDisable(false);
				if(temp2.isWinningPiece()) {
					temp2.setWinningPiece(false);
				}
				if(temp2.getRow() == 5) {
					temp2.setPlace(true);
				}
				else {
					temp2.setPlace(false);
				}
			}
		}
		turnList.clear();
		player = 1;
		turnDisplay.setStyle(p1Color);
		Turn = 0;
		if(logic.isWin()) {
			logic.setWin(false);
			logic.clearWinner();
		}
	}
	
	// handler for the game buttons in the grid
	void createGameHandler() {
		gameHandler = new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				GameButton b1 = (GameButton)event.getSource();
				if(!b1.canPlace()) {  // invalid move
					Moves.setText("Player " + player + " moved to " + b1.getRow() + "," + b1.getColumn() + ". This is not a valid move. Pick again");
				} else {
					turns tempT = new turns(b1.getRow(), b1.getColumn(),player);
					turnList.add(tempT);  // adds turn to list 
					if(player == 1) {  // player 1 move successful
				    	b1.setPlayer("p1");
				    	b1.setStyle(p1Color);
				    	turnDisplay.setStyle(p2Color);
				    	player = 2;
				    	Turn ++;
				    	Moves.setText("Player 1 successfully moved to " + b1.getRow() + "," + b1.getColumn() + ". Player 2 go");
				    } else {  // player 2 successful
				    	b1.setPlayer("p2");
				    	b1.setStyle(p2Color);
				    	turnDisplay.setStyle(p1Color);
				    	player = 1;
				    	Turn ++;
				    	Moves.setText("Player 2 successfully moved to " + b1.getRow() + "," + b1.getColumn() + ". Player 1 go");
				    }
					if(b1.getRow() != 0) {
						bGrid[b1.getRow()-1][b1.getColumn()].setPlace(true);
					}
					b1.setPlace(false);
					checkForWin();
				}
			}
		};
	}
	
	// checks for a winner once there is 7 or more turns made
	public void checkForWin() {
		if(Turn >= 7) {
    		if (logic.checkWin(bGrid)) {
    			for (GameButton[] temp : bGrid) {
    				for (GameButton temp2 : temp) {
    					if(temp2.isWinningPiece()) {
    						continue;
    					}
    					temp2.setDisable(true);
    				}
    			}
    			sceneMap.put("win", makeWiningScene());
    			delay.setOnFinished(e->{currentStage.setScene(sceneMap.get("win")); currentStage.show();});
    			delay.play();
    		}
    		if(Turn == 42) {  // the board is completely filled
    			delay.setOnFinished(e->{currentStage.setScene(sceneMap.get("draw")); currentStage.show();});
    			delay.play();
    		}
    	}
		
	}
	
	// adding the game buttons to the grid pane
    public void addGrid(GridPane grid) {
		for(int x = 0; x< 6; x++) {
			for(int y = 0; y< 7; y++) {
				GameButton b1 = new GameButton();
				defaultPiece = "-fx-background-color: grey;" + "-fx-border-color: black;" + "-fx-font-size: 25;";
				b1.setStyle(defaultPiece);
				p2Color="-fx-background-color: yellow;" + "-fx-border-color: black;" + "-fx-font-size: 25;"; 
				p1Color="-fx-background-color: red;" + "-fx-border-color: black;" + "-fx-font-size: 25;";
				b1.setPrefHeight(80);
				b1.setPrefWidth(80);
				b1.setOnAction(gameHandler);
				b1.setColumn(y); // Sets column for button
				b1.setRow(x);  // Sets row for button
				if(x == 5) {
					b1.setPlace(true);
				}
				bGrid[x][y] = b1;
				grid.add(b1, y, x);
			}
		}
		turnDisplay.setStyle(p1Color);
	}
}