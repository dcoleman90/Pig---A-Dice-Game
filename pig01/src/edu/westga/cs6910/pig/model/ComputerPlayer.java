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
public class ComputerPlayer extends AbstractPlayer implements PigStrategy {

	private static final String NAME = "Simple Computer";
	private PigStrategy strategy;
	private String name;
	private int maximumRolls;
	private int numOfTurnsTaken;

	/**
	 * Creates a new ComputerPlayer with the specified name.
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
		this.name = NAME;
		this.numOfTurnsTaken = 0;
	}

	// *************************** mutator methods ****************************

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
	 * This getter method returns the number value of this.numOfTurnsTaken which
	 * equals to the amount of times takeTurn() method was called
	 * 
	 * @return this.numOfTurnsTaken
	 */
	public int getNumOfTurnsTaken() {
		return this.numOfTurnsTaken;
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public void takeTurn() {
		int pointNeededToWin = (100 - this.getTotal());
		if (this.rollAgain(this.numOfTurnsTaken, this.getTurnTotal(), pointNeededToWin)) {
			this.numOfTurnsTaken++;
			return;
		} else {
			super.takeTurn();
		}
	}

	// *************************** accessor methods ****************************

	@Override
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}

	@Override
	public boolean rollAgain(int rollTaken, int pointsRolled, int pointDifferance) {
		return this.strategy.rollAgain(rollTaken, pointsRolled, pointDifferance);
	}
}
