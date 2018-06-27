package edu.westga.cs6910.pig.view;

import java.util.Optional;

import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.Cheater;
import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.strategies.RandomStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputDialog;
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
	private Human2ndPlayerPane pnHumanPlayer2;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	private GridPane bottomBox;
	private Menu pigStrategy;
	private Menu twoPlayer;

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
		this.addBottomPaneOptions(this.theGame);  
	}
	
	private void startNewGame(Game newGame) {
		this.theGame = newGame;
		this.addFirstPlayerChooserPane(this.theGame);
		this.createMenuBar();
		this.addHumanPlayerPane(this.theGame);
		this.addStatusPane(this.theGame);
		this.addComputerPlayerPane(this.theGame);
		if (PigPane.this.theGame.getComputerPlayer().getComputerStrategy().checkStrategyType() == 1) {
			this.addSecondHumanPlayerPane(this.theGame);
		}
		this.setCenter(this.pnContent);
		this.addBottomPaneOptions(this.theGame);  
	}
	
	private void createMenuBar() {
		MenuBar pigMenuBar = new MenuBar();
		pigMenuBar.getMenus().addAll(this.createMenuBarFile(), this.createMenuBarStrategy(), this.twoPlayerOption());
		this.setTop(pigMenuBar);
	}
	
	private Menu createMenuBarStrategy() {
		this.pigStrategy = new Menu(" Strategy");
		this.pigStrategy.setMnemonicParsing(true);
		
		MenuItem cautiousStrategy = new MenuItem("Cautious");
		cautiousStrategy.setMnemonicParsing(true);
		cautiousStrategy.setOnAction(new SetCautiousListener());
		
		MenuItem randomStrategy = new MenuItem("Random");
		randomStrategy.setMnemonicParsing(true);
		randomStrategy.setOnAction(new SetRandomListener());
		
		MenuItem greedyStrategy = new MenuItem("Greedy");
		greedyStrategy.setMnemonicParsing(true);
		greedyStrategy.setOnAction(new SetGreedyListener());

		MenuItem cheating = new MenuItem("Cheater");
		cheating.setMnemonicParsing(true);
		cheating.setOnAction(new SetCheatingListener());
		
		this.pigStrategy.getItems().addAll(cautiousStrategy, randomStrategy, greedyStrategy, cheating);
		return this.pigStrategy;
	}
	
	private Menu createMenuBarFile() {

		Menu pigFile = new Menu(" File");
		pigFile.setMnemonicParsing(true);
		MenuItem exitPigGame = new MenuItem(" Exit");
		exitPigGame.setMnemonicParsing(true);
		exitPigGame.setOnAction(actionEvent -> System.exit(0));
		pigFile.getItems().add(exitPigGame);
		return pigFile;
	}
	
	private Menu twoPlayerOption() {
		this.twoPlayer = new Menu(" Two Player");
		this.twoPlayer.setMnemonicParsing(true);
		MenuItem twoHumanPlayers = new MenuItem("Two Human Players");
		twoHumanPlayers.setMnemonicParsing(true);
		twoHumanPlayers.setOnAction(new AddSecondHumanPlayer());
		this.twoPlayer.getItems().addAll(twoHumanPlayers);
		return this.twoPlayer;
	}

	private class SetCheatingListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent playStyle) {
			Cheater cheating = new Cheater();	
			PigPane.this.theGame.getComputerPlayer().setComputerStrategy(cheating);
			PigPane.this.theGame.getComputerPlayer().setComputerPlayerName("!!! CHEATER !!!");
			PigPane.this.addComputerPlayerPane(PigPane.this.theGame);
			PigPane.this.addFirstPlayerChooserPane(PigPane.this.theGame);
			PigPane.this.addStatusPane(PigPane.this.theGame);
		}
	}
	
	private class SetRandomListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent playStyle) {
			RandomStrategy randomPlay = new RandomStrategy();
			PigPane.this.theGame.getComputerPlayer().setComputerStrategy(randomPlay);
			PigPane.this.theGame.getComputerPlayer().setComputerPlayerName("Random Player");
			PigPane.this.addComputerPlayerPane(PigPane.this.theGame);
			PigPane.this.addFirstPlayerChooserPane(PigPane.this.theGame);
			PigPane.this.addStatusPane(PigPane.this.theGame);

		}
	}

	private class SetCautiousListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent playStyle) {
			CautiousStrategy carefulPlay = new CautiousStrategy();
			PigPane.this.theGame.getComputerPlayer().setComputerStrategy(carefulPlay);
			PigPane.this.theGame.getComputerPlayer().setComputerPlayerName("Simple Computer");
			PigPane.this.addComputerPlayerPane(PigPane.this.theGame);
			PigPane.this.addFirstPlayerChooserPane(PigPane.this.theGame);
			PigPane.this.addStatusPane(PigPane.this.theGame);

		}

	}

	private class SetGreedyListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent playStyle) {
			GreedyStrategy greedyPlay = new GreedyStrategy();
			PigPane.this.theGame.getComputerPlayer().setComputerStrategy(greedyPlay);
			PigPane.this.theGame.getComputerPlayer().setComputerPlayerName("Greedy Player");
			PigPane.this.addComputerPlayerPane(PigPane.this.theGame);
			PigPane.this.addFirstPlayerChooserPane(PigPane.this.theGame);
			PigPane.this.addStatusPane(PigPane.this.theGame);
		}
	}
	
	private class AddSecondHumanPlayer implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			TextInputDialog changeName = new TextInputDialog("");
			changeName.setTitle("Change Name");
			changeName.setHeaderText("Change Player 2 name");
			changeName.setContentText("What would you like to change your name to?");
			Optional<String> newName = changeName.showAndWait();
			if (newName.isPresent()) {
				PigPane.this.theGame.getComputerPlayer().setComputerPlayerName(newName.get());
				PigPane.this.addComputerPlayerPane(PigPane.this.theGame);
			}
			PigPane.this.addSecondHumanPlayerPane(PigPane.this.theGame);
			PigPane.this.addFirstPlayerChooserPane(PigPane.this.theGame);
			PigPane.this.addStatusPane(PigPane.this.theGame);
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
	
	private void addSecondHumanPlayerPane(Game theGame) {
		HBox rightBox = new HBox();
		rightBox.getStyleClass().add("pane-border");
		this.pnHumanPlayer2 = new Human2ndPlayerPane(theGame);
		rightBox.getChildren().add(this.pnHumanPlayer2);
		this.pnContent.setRight(rightBox);
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

	private void addBottomPaneOptions(Game theGame) {
		this.bottomBox = new GridPane();
		this.bottomBox.setHgap(10);
		this.bottomBox.setVgap(10);
		this.bottomBox.setPadding(new Insets(10, 10, 10, 10));
		
		HBox instructionsBox = new HBox();
		Button showInstructions = new Button("Instructions");
		showInstructions.setOnAction(new GameInstructions());
		instructionsBox.getChildren().add(showInstructions);
	
		HBox nameChangeBox = new HBox();
		Button changeName = new Button("Change Name");
		changeName.setOnAction(new ChangeHumanName());
		nameChangeBox.getChildren().add(changeName);		
		
		HBox newGameBox = new HBox();
		Button newGame = new Button("Start New Game");
		newGameBox.getChildren().add(newGame);
		newGame.setOnAction(new NewGameAlert());
	
		GridPane.setColumnIndex(instructionsBox, 1);
		GridPane.setColumnIndex(nameChangeBox, 2);
		GridPane.setColumnIndex(newGameBox, 3);
	
		this.bottomBox.getChildren().addAll(instructionsBox, newGameBox, changeName);
	
		this.pnContent.setBottom(this.bottomBox);
	}
	
	private class NewGameAlert implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			Alert gameInstructions = new Alert(AlertType.CONFIRMATION);
			gameInstructions.setTitle("Start A New Game?");
			gameInstructions.setHeaderText("Are you sure you wish to start a new game?");
			gameInstructions.setContentText("If you start a new game this one will be canceled and the scores will be reset");
			
			ButtonType newGame = new ButtonType("Start new Game");
			ButtonType exit = new ButtonType("cancel", ButtonData.CANCEL_CLOSE);
			gameInstructions.getButtonTypes().setAll(newGame, exit);
			
			Optional<ButtonType> result = gameInstructions.showAndWait();
			if (result.get() == newGame) {
				StartNewGame startNewGame = new StartNewGame();
				startNewGame.handle(arg0);
			}
		}
	}

	private class GameInstructions implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			Alert gameInstructions = new Alert(AlertType.INFORMATION);
			gameInstructions.setTitle("Instructions");
			gameInstructions.setHeaderText("A Quick Overview of the options");
			gameInstructions.setContentText("Instructions" + "\n 1st Choose the Computer play style you wish to face"
					+ "\n Cautious will only roll once, " + "\n Random has a 50/50 chance of attempting to roll again, "
					+ "\n Greedy will roll a maxium of three times"
					+ "\n\n After you make your selection choose select which player you wish to begin the game"
					+ "\n Click the Roll button to roll your dice, when the points gained out weigh the risk to adquire more points press hold"
					+ "\n When you press hold all your points gained this round are stored."
					+ "\n\n If at any time a one is rolled all points are forfeit and the turn is lost"
					+ "\n After your turn is over press the Computers take turn button"
					+ "\n The Computer will then roll and hold based upon the Strategy selected"
					+ "\n\n The First player to 100 wins");
			gameInstructions.showAndWait();
			ButtonType exit = new ButtonType("exit", ButtonData.CANCEL_CLOSE);
			gameInstructions.getButtonTypes().setAll(exit);
		}
	}
	
	private class ChangeHumanName implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			TextInputDialog changeName = new TextInputDialog("");
			changeName.setTitle("Change Name");
			changeName.setHeaderText("Here you can reset your name");
			changeName.setContentText("What would you like to change your name to?");
			Optional<String> newName = changeName.showAndWait();
			if (newName.isPresent()) {
				PigPane.this.theGame.getHumanPlayer().setName(newName.get());
				PigPane.this.addHumanPlayerPane(PigPane.this.theGame);
				PigPane.this.addFirstPlayerChooserPane(PigPane.this.theGame);
				PigPane.this.addStatusPane(PigPane.this.theGame);
			}
		}
	}

	private class StartNewGame implements EventHandler<ActionEvent> {
		@Override
		/**
		 * Enables the ComputerPlayerPanel and starts a new game. Event handler for a
		 * click in the computerPlayerButton.
		 */
		public void handle(ActionEvent arg0) {
			Game newGame = new Game(PigPane.this.theGame.getHumanPlayer(), PigPane.this.theGame.getComputerPlayer());
			PigPane.this.theGame.startNewGame(PigPane.this.theGame.getCurrentPlayer());
			PigPane.this.theGame.resetGame();
			PigPane.this.pnChooseFirstPlayer.setDisable(true);
			PigPane.this.pnComputerPlayer.setDisable(false);
			PigPane.this.pnHumanPlayer.setDisable(false);
			if (PigPane.this.theGame.getComputerPlayer().getComputerStrategy().checkStrategyType() == 1) {
				PigPane.this.pnHumanPlayer2.setDisable(false);
			}
			PigPane.this.startNewGame(newGame);
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
				PigPane.this.pigStrategy.setDisable(true);
				PigPane.this.twoPlayer.setDisable(true);
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
				PigPane.this.pigStrategy.setDisable(true);
				PigPane.this.twoPlayer.setDisable(true);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
			}
		}
	}
}
