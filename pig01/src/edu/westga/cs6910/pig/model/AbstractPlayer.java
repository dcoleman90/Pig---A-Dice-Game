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
			this.total = this.total - this.turnTotal;
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
		this.setIsMyTurnFalse();
	}

	@Override
	/**
	 * @see Player#getIsMyTurn()
	 */
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	/**
	 * this method sets isMyTurn value to false and returns it
	 * @return isMyTurn set to false
	 */
	public boolean setIsMyTurnFalse() {
		this.isMyTurn = false;
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

	/**
	 * This method will return the value of the first die it is used mostly for
	 * testing purposes
	 * 
	 * @return die 1 value
	 */
	public int getDie1Result() {
		return this.thePair.getDie1Value();
	}

	/**
	 * This method will return the value of the second die it is used mostly for
	 * testing purposes
	 * 
	 * @return die 2 value
	 */
	public int getDie2Result() {
		return this.thePair.getDie2Value();
	}

	/**
	 * This method is used for testing and Sets the total at the accepted value
	 * 
	 * @param newTotal
	 *            is the value this.total will be set too only to be used when
	 *            testing
	 */
	public void setTotal(int newTotal) {
		this.total = newTotal;
	}

	/**
	 * This method is used for testing and Sets the Turn Total at the accepted value
	 * 
	 * @param newTurnTotal
	 *            is the value this.turnTotal will be set too only to be used when
	 *            testing
	 */
	public void setTurnTotal(int newTurnTotal) {
		this.turnTotal = newTurnTotal;
	}

}
