package edu.westga.cs6910.pig.model;

import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Pig. It
 * rolls exactly 1 time and then holds.
 * 
 * @author CS6910
 * @version Summer 2018
 * @author Drew Coleman
 * @version 06/05/2018
 */
public class ComputerPlayer extends AbstractPlayer {

	private String computerName = "Simple Computer";
	private PigStrategy strategy;
	private int turnsRemaining;

	/**
	 * Creates a new ComputerPlayer with the specified computerName.
	 * 
	 * @param acceptedStrategy
	 *            is the logic the ComputerPlayer will use to play the game
	 */
	public ComputerPlayer(PigStrategy acceptedStrategy) {
		super();
		if (acceptedStrategy == null) {
			throw new IllegalArgumentException("Invalid Strategy");
		}
		this.strategy = acceptedStrategy;
		this.turnsRemaining = 0;
	}

	// *************************** mutator methods ****************************

	/**
	 * This method will change the computer players computerName to the new accepted
	 * value
	 * 
	 * @param acceptedName
	 *            is the new computerName
	 */
	public void setComputerPlayerName(String acceptedName) {
		if (acceptedName != null) {
			this.computerName = acceptedName;
		}
	}
	
	/**
	 * This is the setter method for this.turnsRemaining
	 * @param acceptedTurnsRemaining is the new value for this.turnsRemaining
	 */
	public void setTurnsRemaining(int acceptedTurnsRemaining) {
		this.turnsRemaining = acceptedTurnsRemaining;
	}

	/**
	 * This method will set the Computer Strategy to a new one
	 * 
	 * @param acceptedStrategy
	 *            this is the new PigStrategy for the computerPlayer
	 */
	public void setComputerStrategy(PigStrategy acceptedStrategy) {
		if (acceptedStrategy == null) {
			throw new IllegalArgumentException("Invalid Strategy");
		}
		this.strategy = acceptedStrategy;
	}

	/**
	 * THe getter for this.strategy
	 * 
	 * @return this.strategy
	 */
	public PigStrategy getComputerStrategy() {
		return this.strategy;
	}

	@Override
	/**
	 * @see Player#takeTurn() The checking StrategyType for 1 is checking for a
	 *      manual override of the computer player and forces/allows for manual
	 *      input in effect turning the computer player into a human player
	 * 
	 *      If StrategyType is equal to 2 then the computer player returns 20 each
	 *      time
	 */
	public void takeTurn() {
		super.takeTurn();
		super.setIsMyTurnFalse();
		boolean takeTurn = true;
		while (this.strategy.checkStrategyType() == 0 && takeTurn) {
			if (this.strategy.rollAgain(this.turnsRemaining, this.getTurnTotal(), this.getTotal())) {
				this.turnsRemaining++;
				this.takeTurn();
			}
			this.turnsRemaining = 0;
			takeTurn = false;
		}
		while (this.strategy.checkStrategyType() == 1 && takeTurn && this.getTurnTotal() != 0) {
			takeTurn = false;
			super.setIsMyTurnTrue();
		}
		while (this.strategy.checkStrategyType() == 2 && takeTurn) {
			takeTurn = false;
			this.turnsRemaining++;
			this.cheatersRolls(this.turnsRemaining);
		}
	}

	private void cheatersRolls(int acceptedNumberOfRounds) {
		int numberOfRounds = acceptedNumberOfRounds;
		int cheatersTotal = numberOfRounds * 25;
		this.resetTurnTotal();
		this.setTotal(cheatersTotal);
	}

	// *************************** accessor methods ****************************
	@Override
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.computerName;
	}
}
