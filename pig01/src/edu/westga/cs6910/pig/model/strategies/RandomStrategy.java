package edu.westga.cs6910.pig.model.strategies;

/**
 * This Strategy will roll gain 50% of the time
 * @author Drew Coleman
 * @version 06/19/2018
 */
public class RandomStrategy implements PigStrategy {

	/**
	 * This is the implemented method which will return true half the time regardless of input
	 */
	@Override
	public boolean rollAgain(int rollTaken, int pointsRolled, int pointDifferance) {
		return Math.random() > 0.5;
	}

	@Override
	public int checkStrategyType() {
		return 0;
	}

}
