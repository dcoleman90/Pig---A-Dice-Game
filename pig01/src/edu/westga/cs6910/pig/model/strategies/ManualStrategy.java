package edu.westga.cs6910.pig.model.strategies;

/**
 * This class will implement PigStrategy and use a manualStrategy forcing the user to click hold and roll
 * game
 * 
 * @author Drew Coleman
 * @version 06/15/2018
 *
 */
public class ManualStrategy implements PigStrategy {

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
	 *         cautious strategy always returns false as if called it should NEVER
	 *         be rolled again
	 */
	public boolean rollAgain(int rollTaken, int pointsRolled, int pointDifferance) {
		return true;
	}

	@Override
	public int checkStrategyType() {
		return 1;
	}
}
