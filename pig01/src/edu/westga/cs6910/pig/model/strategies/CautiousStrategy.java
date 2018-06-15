package edu.westga.cs6910.pig.model.strategies;

/**
 * This class will implement PigStrategy and use a cautious approach to win the
 * game
 * 
 * @author Drew Coleman
 * @version 06/15/2018
 *
 */
public class CautiousStrategy implements PigStrategy {

	/**CautiousStrategy
	 * @param rollTaken
	 *            - how many times the dice have been rolled this turn
	 * @param pointsRolled
	 *            - how many points rolled so far this turn
	 * @param pointDifferance
	 *            - difference between the total points acquired so far and the
	 *            total score
	 * @return true if player should roll false if they should hold
	 * 
	 *         The cautious strategy is to return stop rolling if pointsRolled >=10
	 *         rolledTaken > = 2
	 * 
	 *         The cautious strategy does not care about the pointsDifference
	 */
	public boolean rollAgain(int rollTaken, int pointsRolled, int pointDifferance) {
		return rollTaken == 2 || pointsRolled >= 10;
	}
}
