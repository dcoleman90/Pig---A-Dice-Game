package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.strategies.ManualStrategy;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Defines the panel that lets the user indicate whether they want to 
 * 	roll or hold on their turn
 * 
 * @author CS6910
 * @version Summer 2018
 * @author Drew Coleman
 * @version 06/26/2018
 */
public class Human2ndPlayerPane extends GridPane implements InvalidationListener {
	private Label lblDiceValues;
	private Button btnRoll;
	private Button btnHold;
	private Label lblTurnTotal;
	
	private ComputerPlayer theSecondPlayer;
	private Game theGame;

	/**
	 * Creates a new HumanPane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public Human2ndPlayerPane(Game theGame) {
		this.theGame = theGame;
		this.theGame.addListener(this);
		
		this.theSecondPlayer = this.theGame.getComputerPlayer();
		this.setStrategy();
		this.buildPane();
	}
	
	private void setStrategy() {
		ManualStrategy manual = new ManualStrategy();
		this.theSecondPlayer.setComputerStrategy(manual);
	}
	
	private void buildPane() {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("box-center");	
		topBox.getStyleClass().add("box-padding");
		topBox.getChildren().add(new Label("~~ " + this.theSecondPlayer.getName() + " ~~"));
		this.add(topBox, 0, 0, 2, 1);
		
		HBox middleBox = new HBox();
		middleBox.getStyleClass().add("box-padding");		
		middleBox.getChildren().add(new Label("Dice Values: "));
		this.lblDiceValues = new Label("-, -");
		middleBox.getChildren().add(this.lblDiceValues);
		this.add(middleBox, 0, 1);

		HBox buttonBox = new HBox();
		buttonBox.getStyleClass().add("box-padding");
		this.btnRoll = new Button("Roll");
		this.btnRoll.setOnAction(new TakeTurnListener());
		buttonBox.getChildren().add(this.btnRoll);
		
		this.btnHold = new Button("Hold");
		this.btnHold.setOnAction(new HoldListener());
		buttonBox.getChildren().add(this.btnHold);
		this.add(buttonBox, 0, 2);
		
		HBox bottomBox = new HBox();
		bottomBox.getStyleClass().add("box-padding");
		bottomBox.getChildren().add(new Label("Turn Total: "));
		this.lblTurnTotal = new Label("0");
		bottomBox.getChildren().add(this.lblTurnTotal);
		this.add(bottomBox, 0, 3);
	}

	@Override
	public void invalidated(Observable observable) {
		if (this.theGame.isGameOver()) {
			this.setDisable(true);
			return;
		}
		
		boolean myTurn = this.theGame.getCurrentPlayer() == theSecondPlayer;

		int turnTotal = this.theSecondPlayer.getTurnTotal();
		String result = this.theSecondPlayer.getDiceValues();
		this.lblDiceValues.setText(result);
		this.lblTurnTotal.setText("" + turnTotal);
		
		this.setDisable(!myTurn);
	}

	private class TakeTurnListener implements EventHandler<ActionEvent> {
		/* 
		 * Tells the Game to have its current player (i.e., the human Player)
		 * take its turn.	
		 * 
		 */
		@Override
		public void handle(ActionEvent event) {
			if (!Human2ndPlayerPane.this.theGame.isGameOver()) {
				Human2ndPlayerPane.this.theGame.play();
			} else {
				Human2ndPlayerPane.this.theSecondPlayer.resetTurnTotal();
			}
		}
	}
	
	private class HoldListener implements EventHandler<ActionEvent> {
		/* 
		 * Tells the Game that its current player (i.e., the human Player)
		 * will be holding	
		 * 
		 */
		@Override
		public void handle(ActionEvent event) {
			if (!Human2ndPlayerPane.this.theGame.isGameOver()) {
				Human2ndPlayerPane.this.theGame.hold();
			}
		}
	}
}
