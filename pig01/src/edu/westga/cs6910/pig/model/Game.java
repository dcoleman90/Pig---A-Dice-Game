package edu.westga.cs6910.pig.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Pig game.
 * 
 * @author CS6910
 * @version Summer 2018
 * @author Drew Coleman
 * @version 06/04/2018
 */
public class Game implements Observable {

	/**
	 * The goal score for the game
	 */
	private int goalScore = 100;
	private ObjectProperty<Player> currentPlayerObject;

	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;

	private DicePair thePair;

	/**
	 * Creates a Pig Game with the specified Players and a pair of dice.
	 * 
	 * @param theComputer
	 *            the automated player
	 * @param theHuman
	 *            the human player
	 * 
	 * @require theHuman != null && theComputer != null
	 * 
	 * @ensure humanPlayer().equals(theHuman) && computerPlayer.equals(theComputer)
	 */
	public Game(HumanPlayer theHuman, ComputerPlayer theComputer) {
		this.theHuman = theHuman;
		this.theComputer = theComputer;

		this.currentPlayerObject = new SimpleObjectProperty<Player>();

		this.thePair = new DicePair();
	}

	// *********************** mutator methods *************************

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer
	 *            the Player who takes the first turn
	 * 
	 * @require firstPlayer != null && !firstPlayer.equals(secondPlayer)
	 * 
	 * @ensures whoseTurn().equals(firstPlayer) && firstPlayer.getTotal() == 0
	 */
	public void startNewGame(Player firstPlayer) {
		this.currentPlayerObject.setValue(firstPlayer);

		this.thePair = new DicePair();
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to take a turn.
	 * Has no effect if the game is over.
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures !whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play() {
		Player currentPlayer = this.currentPlayerObject.getValue();
		this.currentPlayerObject.getValue().takeTurn();

		// Force the user interface to update by changing the currentPlayerObject
		// to null and back
		this.currentPlayerObject.setValue(null);
		this.currentPlayerObject.setValue(currentPlayer);

		if (!this.currentPlayerObject.getValue().getIsMyTurn()) {
			this.hold();
			this.currentPlayerObject.getValue().resetTurnTotal();
		}
	}

	/**
	 * Notifies the game that the player is holding
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures !whoseTurn().equals(whoseTurn()@prev)
	 */
	public void hold() {
		this.swapWhoseTurn();
		this.isGameOver();
	}

	// *********************** accessor methods *************************
	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}

	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}

	/**
	 * Return whether the game is over.
	 * 
	 * @return true iff currentPlayer.getTotal() >= this.goalScore
	 */
	public boolean isGameOver() {
		if (this.currentPlayerObject.getValue() == null) {
			return true;
		}

		if (this.currentPlayerObject.getValue().getTotal() >= this.goalScore) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns the current highest score in the game
	 * @return the highest score between the two players
	 */
	public int getHighestScore() {
		if (this.theComputer.getTotal() > this.theHuman.getTotal()) {
			return this.theComputer.getTotal();
		} else {
			return this.theHuman.getTotal();
		}
	}
	
	/**
	 * \ This method resets the game players score to zero
	 */
	public void resetGame() {
		this.theComputer.setTotal(0);
		this.theComputer.setTurnTotal(0);
		this.theHuman.setTotal(0);
		this.theHuman.setTurnTotal(0);
	}

	/**
	 * Returns the pair of dice being used in the game
	 * 
	 * @return the pair of dice
	 */
	public DicePair getDicePair() {
		return this.thePair;
	}

	
	

	/**
	 * Returns a String showing the goal score, or, if the game is over, the name of
	 * the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {
		String result = "Goal Score: " + this.goalScore;
		result += System.getProperty("line.separator") + this.theHuman.getName() + ": " + this.theHuman.getTotal();
		result += System.getProperty("line.separator") + this.theComputer.getName() + ": "
				+ this.theComputer.getTotal();

		if (this.theHuman.getTotal() >= this.goalScore) {
			return result + System.getProperty("line.separator") + "Game over! Winner: " + this.theHuman.getName();
		} else if (this.theComputer.getTotal() >= this.goalScore) {
			return result + System.getProperty("line.separator") + "Game over! Winner: " + this.theComputer.getName();
		} else {
			return result;
		}
	}

	// ************************ private helper method *************************
	private void swapWhoseTurn() {

		if (this.currentPlayerObject.getValue() == this.theComputer) {
			this.currentPlayerObject.setValue(this.theHuman);
			this.currentPlayerObject.getValue().resetTurnTotal();
		} else {
			this.currentPlayerObject.setValue(this.theComputer);
			this.currentPlayerObject.getValue().resetTurnTotal();
		}
	}

	@Override
	public void addListener(InvalidationListener theListener) {
		this.currentPlayerObject.addListener(theListener);
	}

	@Override
	public void removeListener(InvalidationListener theListener) {
		this.currentPlayerObject.removeListener(theListener);
	}

	// ****************************** Testing Methods *****************************

	/**
	 * Added getter for instance variable currentPlayerObject used mostly for
	 * testing purposes
	 * 
	 * @return this.currentPlayerObject - the player currently selected
	 */
	public ObjectProperty<Player> getCurrentPlayerObject() {
		return this.currentPlayerObject;
	}

	/**
	 * Added setter for instance variable currentPlayerObject used mostly for
	 * testing purposes - this method changes the currentPlayerObject to theComputer
	 * 
	 * @param theComputerPlayer
	 *            is the new accepted currentPlayerObject
	 */
	public void setCurrentPlayerObjectToComputer(ComputerPlayer theComputerPlayer) {
		this.currentPlayerObject.setValue(theComputerPlayer);
	}

	/**
	 * Added setter for instance variable currentPlayerObject used mostly for
	 * testing purposes - this method changes the currentPlayerObject to theHuman
	 * 
	 * @param theHumanPlayer
	 *            is the new accepted currentPlayerObject
	 */
	public void setCurrentPlayerObjectToHuman(HumanPlayer theHumanPlayer) {
		this.currentPlayerObject.setValue(theHumanPlayer);
	}

	/**
	 * Added setter for instance variable theHuman used mostly for testing purposes
	 * 
	 * @param theHuman
	 *            is the HumanPlayer
	 */
	public void setTheHuman(HumanPlayer theHuman) {
		this.theHuman = theHuman;
	}

	/**
	 * Added setter for instance variable theComputer used mostly for testing
	 * purposes
	 * 
	 * @param theComputer
	 *            is the ComputerPlayer
	 */
	public void setTheComputer(ComputerPlayer theComputer) {
		this.theComputer = theComputer;
	}

	/**
	 * Added getter for final constant this.goalScore used mostly for testing purposes
	 * 
	 * @return this.goalScore
	 */
	public int getGoalScore() {
		return this.goalScore;
	}
	
	
	/**
	 * This method is the setter for the instance variable goalScore
	 * @param acceptedScore is what this.goalScore will equal
	 */
	public void setGoalScore(int acceptedScore) {
		this.goalScore = acceptedScore;
	}

}
