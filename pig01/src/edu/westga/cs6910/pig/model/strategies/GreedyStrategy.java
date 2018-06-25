package edu.westga.cs6910.pig.model.strategies;

/**
 * This Strategy will cause the computerPlayer to Roll 4 times or try for 30
 * points in one round
 * 
 * @author Drew Coleman
 * @version 06/18/2018
 *
 */
public class GreedyStrategy implements PigStrategy {

	/**
	 * GreedyStrategy
	 * 
	 * @param maxRollsRemaining
	 *            - how many times the dice have been rolled this turn
	 * @param pointsRolled
	 *            - how many points rolled so far this turn
	 * @param pointDifference
	 *            - difference between the total points acquired so far and the
	 *            total score
	 * @return true if player should roll false if they should hold
	 * 
	 *         The cautious strategy is to return stop rolling if rolledTaken > 3 or
	 *         the game is one (pointsDifferences is less or equal to 0)
	 * 
	 *         The cautious strategy does not care about the pointsDifference
	 */
	public boolean rollAgain(int maxRollsRemaining, int pointsRolled, int pointDifference) {
		if (pointsRolled == 0) {
			return false;
		} else if (pointDifference >= 100) {
			return false;
		} else {
			return (maxRollsRemaining < 2);

		}
	}
}