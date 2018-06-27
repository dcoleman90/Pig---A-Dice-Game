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
	
	private int maximumRolls;
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
	 * This method will change the computer players computerName to the new accepted value
	 * @param acceptedName is the new computerName
	 */
	public void setComputerPlayerName(String acceptedName) {
		if (acceptedName != null) {
			this.computerName = acceptedName;
		}
	}

	/**
	 * Implements Player's setMaximumRolls() to set the maximum number of rolls to 1
	 * 
	 */
	public void setMaximumRolls() {
		this.maximumRolls = 1;
	}

	/**
	 * Implements Player's setMaximumRolls, but is not normally called by client
	 * objects. Instead, clients usually call the 0-parameter version
	 * 
	 * @param maximumRolls
	 *            The maximum number of times the computer will roll before holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		this.maximumRolls = maximumRolls;
	}

	/**
	 * THis is the getter for maxiumRolls and is used primarily for testing the
	 * default and secondary constructors
	 * 
	 * @return this.maxiumRolls
	 */
	public int getMaxiumRolls() {
		return this.maximumRolls;
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
	 *      If StrategyType is equal to 2 then the computer player returns 20 each time
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
		while (this.strategy.checkStrategyType() == 2) {
			this.setTurnTotal(20);
			takeTurn = false;
		}

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
