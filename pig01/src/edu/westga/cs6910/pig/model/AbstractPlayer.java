package edu.westga.cs6910.pig.model;

/**
 * This is an Abstract Class which will provide the building blocks for the
 * Player classes
 * 
 * @author Drew Coleman
 * @version 06/05/2018
 *
 */
public abstract class AbstractPlayer implements Player {
	private String name;
	private DicePair thePair;
	private boolean isMyTurn;
	private int total;
	private int turnTotal;

	AbstractPlayer(String name) {
		this.name = name;
		this.thePair = new DicePair();

	}

	@Override	
	/**
	 * @see Player#getIsMyTurn()
	 */
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	@Override	
	/**
	 * @see Player#getTurnTotal()
	 */
	public int getTurnTotal() {
		return this.turnTotal;
	}

	@Override	
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}

	@Override	
	/**
	 * @see Player#getDiceValues()
	 */
	public String getDiceValues() {
		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}

	@Override	
	/**
	 * @see Player#getTotal()
	 */
	public int getTotal() {
		return this.total;
	}
}
