package edu.westga.cs6910.pig.model.strategies;

/**
 * This class will implement PigStrategy and CHEAT automatically giving 20
 * points to the computer game
 * 
 * @author Drew Coleman
 * @version 06/26/2018
 *
 */
public class Cheater implements PigStrategy {

	/**
	 * CautiousStrategy
	 * 
	 * @param rollTaken
	 *            - how many times the dice have been rolled this turn
	 * @param pointsRolled
	 *            - how many points rolled so far this turn
	 * @param pointDifferance
	 *            - difference between the total points acquired so far and the
	 *            total score
	 * @return true if player should roll false if they should hold
	 * 
	 *         Cheater strategy always returns false as it will never be rolled
	 *         again by returning 2 in the checkStrategy type it lets the takeTurn
	 *         method know to add 20 points
	 */
	public boolean rollAgain(int rollTaken, int pointsRolled, int pointDifferance) {
		return false;
	}

	@Override
	public int checkStrategyType() {
		return 2;
	}
}
