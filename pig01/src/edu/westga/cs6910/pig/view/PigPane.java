package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.strategies.RandomStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
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
	private GridPane bottomBox;

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
		this.addBottomPaneRestartAndInstructions(this.theGame);
		
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

	private void addBottomPaneRestartAndInstructions(Game theGame) {
		this.bottomBox = new GridPane();
		Button showInstructions = new Button("Instructions");
		showInstructions.setOnAction(new GameInstructions());
		HBox instructionsBox = new HBox();
		instructionsBox.getStyleClass().add("pane-border");
		instructionsBox.getChildren().add(showInstructions);

		HBox resetBox = new HBox();
		resetBox.getStyleClass().add("pane-border");
		Button restartScore = new Button("Reset Scores to 0");
		resetBox.getChildren().add(restartScore);
		GridPane.setColumnIndex(resetBox, 5);
		GridPane.setColumnIndex(instructionsBox, 1);
		this.bottomBox.getChildren().addAll(instructionsBox, resetBox);

		restartScore.setOnAction(new RestartScore());
		this.pnContent.setBottom(this.bottomBox);
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
					+ "\n After you make your selection choose select which player you wish to begin the game"
					+ "\n Click the Roll button to roll your dice, when the points gained out weigh the risk to adquire more points press hold"
					+ "\n When you press hold all your points gained this round are stored."
					+ "\n If at any time you roll a one with either dice you forfiet all points"
					+ "\n After your turn is over press the Computers take turn button"
					+ "\n The Computer will then roll and hold based upon the Strategy selected"
					+ "\n The First player to 100 wins");
			gameInstructions.showAndWait();
			ButtonType exit = new ButtonType("exit", ButtonData.CANCEL_CLOSE);
			gameInstructions.getButtonTypes().setAll(exit);
		}
	}

	private class RestartScore implements EventHandler<ActionEvent> {
		@Override
		/**
		 * Enables the ComputerPlayerPanel and starts a new game. Event handler for a
		 * click in the computerPlayerButton.
		 */
		public void handle(ActionEvent arg0) {

			PigPane.this.theGame.resetGame();

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

		// THIS IS NEW CODE FOR THE ADDITIONS

	}
}
