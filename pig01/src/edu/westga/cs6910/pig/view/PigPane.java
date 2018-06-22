package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.strategies.RandomStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Defines a GUI for the Pig game. This class was started by CS6910
 * 
 * @author Drew Coleman
 * @version 06/04/2018
 * 
 */
public class PigPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;

	/**
	 * Creates a pane object to provide the view for the specified Game model
	 * object.
	 * 
	 * @param theGame
	 *            the domain model object representing the Pig game
	 * 
	 * @requires theGame != null
	 * @ensures the pane is displayed properly
	 */
	public PigPane(Game theGame) {
		this.theGame = theGame;

		this.pnContent = new BorderPane();		
		this.addFirstPlayerChooserPane(this.theGame);
		this.createMenuBar();
		this.addHumanPlayerPane(this.theGame);
		this.addStatusPane(this.theGame);
		this.addComputerPlayerPane(this.theGame);
		this.setCenter(this.pnContent);
	//	this.addNewGameButton(this.theGame);
	}

	private void createMenuBar() {
    	MenuBar pigMenuBar = new MenuBar();
		Menu pigFile = new Menu(" File");
		pigFile.setMnemonicParsing(true);
		MenuItem exitPigGame = new MenuItem(" Exit");
		exitPigGame.setMnemonicParsing(true);
		exitPigGame.setOnAction(actionEvent -> System.exit(0));
		pigFile.getItems().add(exitPigGame);
		
		Menu pigStrategy = new Menu(" Strategy");
		pigStrategy.setMnemonicParsing(true);
		
		MenuItem cautiousStrategy = new MenuItem("Cautious");
		cautiousStrategy.setMnemonicParsing(true);
		cautiousStrategy.setOnAction(new SetCautiousListener());
	
		MenuItem randomStrategy = new MenuItem("Random");
		randomStrategy.setMnemonicParsing(true);
		randomStrategy.setOnAction(new SetRandomListener());
		
		MenuItem greedyStrategy = new MenuItem("Greedy");
		greedyStrategy.setMnemonicParsing(true);
		greedyStrategy.setOnAction(new SetGreedyListener());
		
		pigStrategy.getItems().addAll(cautiousStrategy, randomStrategy, greedyStrategy);
		pigMenuBar.getMenus().addAll(pigFile, pigStrategy);
		this.setTop(pigMenuBar);
	}
	
	private class SetRandomListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent playStyle) {
			RandomStrategy randomPlay = new RandomStrategy();
			PigPane.this.theGame.getComputerPlayer().setComputerStrategy(randomPlay);
			
		}
	}
	
	private class SetCautiousListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent playStyle) {
			CautiousStrategy carefulPlay = new CautiousStrategy();
			PigPane.this.theGame.getComputerPlayer().setComputerStrategy(carefulPlay);
			
		}
		
	}
	
	private class SetGreedyListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent playStyle) {
			GreedyStrategy greedyPlay = new GreedyStrategy();
			PigPane.this.theGame.getComputerPlayer().setComputerStrategy(greedyPlay);
		}	
	}
	
	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(topBox);
	}

	private void addHumanPlayerPane(Game theGame) {
		HBox leftBox = new HBox();
		leftBox.getStyleClass().add("pane-border");
		this.pnHumanPlayer = new HumanPane(theGame);
		leftBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(leftBox);
	}

	private void addStatusPane(Game theGame) {
		HBox centerBox = new HBox();
		centerBox.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(theGame);
		centerBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(centerBox);
	}

	private void addComputerPlayerPane(Game theGame) {
		HBox rightBox = new HBox();
		rightBox.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(theGame);
		rightBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.setRight(rightBox);
	}
	
	//THIS IS NEW CODE FOR THE ADDITIONS 
	private void addNewGameButton(Game theGame) {
		HBox bottomBox = new HBox();
		bottomBox.getStyleClass().add("pane-border");
		Button newGame = new Button("New Game");
		newGame.setOnAction(new StartNewGame());
		bottomBox.getChildren().add(newGame);
		this.pnContent.setBottom(bottomBox);
	}

	private class StartNewGame implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			System.out.println("You got here now start a new game");
			
		}
		
	}
	
	/*
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;

		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;

			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();

			this.buildPane();
		}

		private void buildPane() {
			this.setHgap(20);
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");
			this.radHumanPlayer.setOnAction(new HumanFirstListener());
			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());
			ToggleGroup firstPlayerSelection = new ToggleGroup();
			HBox newGameSelector = new HBox();
			newGameSelector.setSpacing(10);
			this.radHumanPlayer.setToggleGroup(firstPlayerSelection);
			this.radComputerPlayer.setToggleGroup(firstPlayerSelection);
			newGameSelector.getChildren().add(this.radHumanPlayer);
			newGameSelector.getChildren().add(this.radComputerPlayer);
			this.getChildren().add(newGameSelector);

		}
		
		/*
		 * Defines the listener for computer player first button.
		 */
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/**
			 * Enables the ComputerPlayerPanel and starts a new game. Event handler for a
			 * click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				PigPane.this.pnComputerPlayer.setDisable(false);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		/*
		 * Defines the listener for human player first button.
		 */
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/*
			 * Sets up user interface and starts a new game. Event handler for a click in
			 * the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				PigPane.this.pnHumanPlayer.setDisable(false);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
			}
		}
	}
}
