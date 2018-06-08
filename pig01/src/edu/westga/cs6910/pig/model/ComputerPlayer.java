package edu.westga.cs6910.pig.model;

/**
 * ComputerPlayer represents a very simple automated player in the game Pig.
 * It rolls exactly 1 time and then holds.
 * 
 * @author	CS6910
 * @version	Summer 2018
 * @author Drew Coleman
 * @version 06/05/2018
 */
public class ComputerPlayer extends AbstractPlayer {
	
	private static final String NAME = "Simple Computer";
	
	private String name;
	private int maximumRolls;
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 */
	public ComputerPlayer() {
		super();
		this.name = NAME;
	}

	//*************************** mutator methods ****************************
	
	/**
	 * Implements Player's setMaximumRolls, but is not normally
	 * called by client objects.  Instead, clients usually
	 * call the 0-parameter version
	 * 
	 * @param	maximumRolls	The maximum number of times the computer
	 * 							will roll before holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		this.maximumRolls = maximumRolls;
	}

	/**
	 * Implements Player's setMaximumRolls() to set the 
	 * maximum number of rolls to 1
	 * 
	 */
	public void setMaximumRolls() {
		this.maximumRolls = 1;
	}
	
	/**
	 * THis is the getter for maxiumRolls and is used primarily for testing the default and secondary constructors
	 * @return this.maxiumRolls
	 */
	public int getMaxiumRolls() {
		return this.maximumRolls;
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */	
	public void takeTurn() {				
		
		for (int counter = 0; counter < this.maximumRolls; counter++) {
			super.takeTurn();
		}
	}

	//*************************** accessor methods ****************************
	
	@Override	
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}
}
