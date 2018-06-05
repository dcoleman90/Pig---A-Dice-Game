package edu.westga.cs6910.pig.model;

/**
 * HumanPlayer represents a human player in the game Pig.
 * 
 * @author	CS6910
 * @version	Summer 2018
 * @author Drew Coleman
 * @version 06/05/2018
 */
public class HumanPlayer extends AbstractPlayer {
	private String name;
	
	/**
	 * Creates a new HumanPlayer with the specified name.
	 * 
	 * @param name	this Player's name
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public HumanPlayer(String name) {
		super();
		if (name == null) {
			throw new IllegalArgumentException("The Player's name cannot be null");
		}
		this.name = name;
	}

	@Override
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}
}
