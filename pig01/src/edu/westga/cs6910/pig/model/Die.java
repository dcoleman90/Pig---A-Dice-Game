package edu.westga.cs6910.pig.model;

import java.util.Random;

/**
 * Die represents a 6-sided die.
 * 
 * @author	CS6910
 * @version	Summer 2018
 */
public class Die {

	private int numberShowing;
	private Random generator;

	/**
	 * Creates a new Die instance with 1 pip showing.
	 * @param	generator	The random number generator object
	 */
	public Die(Random generator) {
		this.numberShowing = 1;
		this.generator = generator;
	}

	/**
	 * Gives the Die a new value 1 - 6.
	 */
	public void roll() {
		this.numberShowing = this.generator.nextInt(6) + 1;
	}

	/**
	 * Returns how many pips are showing.
	 * 
	 * @return the number of pips showing
	 */
	public int getNumberOfPips() {
		return this.numberShowing;
	}

	/**
	 * Returns "pips: n" where n is the number of pips showing.
	 * 
	 * @return the String representation
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "pips: " + this.getNumberOfPips();
	}
}