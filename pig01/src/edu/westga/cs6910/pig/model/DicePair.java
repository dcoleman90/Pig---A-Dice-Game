package edu.westga.cs6910.pig.model;

import java.util.Random;

/**
 * Represents a pair of dice
 * 
 * @author	CS6910
 * @version	Summer 2018
 */
public class DicePair {
	private Die die1;
	private Die die2;
	
	/**
	 * Sets up dice pair to be ready for rolling
	 */
	public DicePair() {
		Random generator = new Random();
		this.die1 = new Die(generator);
		this.die2 = new Die(generator);
	}
	
	/**
	 * Rolls each die
	 */
	public void rollDice() {
		this.die1.roll();
		this.die2.roll();
	}
	
	/**
	 * Returns the number of pips showing on the first die
	 * @return	The number of pips showing on the first die
	 * 
	 */
	public int getDie1Value() {
		return this.die1.getNumberOfPips();
	}
	
	/**
	 * Returns the number of pips showing on the second die
	 * @return	The number of pips showing on the second die
	 */
	public int getDie2Value() {
		return this.die2.getNumberOfPips();
	}
	
	/**
	 * This method is used for testing and will return a String representation of the object
	 * @return Dice 1: + this.die1 + Dice 2: + this.die2
	 */
	public String toString() {
		return "Die1: " + this.getDie1Value() + " Die2: " + this.getDie2Value();
	}
}
