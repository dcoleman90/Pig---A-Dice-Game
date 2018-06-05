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
	private DicePair thePair;
	private int total;
	private int turnTotal;
	private boolean isMyTurn;
	
	/**
	 * This is the constructor which will set up all identical player methods
	 */
	public AbstractPlayer() {
		this.thePair = new DicePair();
		this.total = 0;
	}
	
	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public void takeTurn() {	
		this.thePair.rollDice();
		
		int die1Value = this.thePair.getDie1Value();
		int die2Value = this.thePair.getDie2Value();
		if (die1Value == 1 || die2Value == 1) {	
			this.total -= this.turnTotal;
			this.isMyTurn = false;
			this.resetTurnTotal();
		} else {
			this.turnTotal += die1Value + die2Value;
			this.total += die1Value + die2Value;
			this.isMyTurn = true;
		}
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
	 * @see Player#resetTurnTotal()
	 */	
	public void resetTurnTotal() {
		this.turnTotal = 0;
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
	 * @see Player#getTotal()
	 */
	public int getTotal() {
		return this.total;
	}
	
	@Override	
	/**
	 * @see Player#getTurnTotal()
	 */
	public int getTurnTotal() {
		return this.turnTotal;
	}
}
