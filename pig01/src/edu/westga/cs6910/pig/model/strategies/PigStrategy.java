package edu.westga.cs6910.pig.model.strategies;

/**
 * This Class will create the interface for all the ComputerPlayer's game-play
 * decisions
 * 
 * @author Drew Coleman
 * @version 06/15/2018
 *
 */
public interface PigStrategy {

	/**
	 * This method will decide the game play and will differ according to the
	 * different strategies
	 * 
	 * @param rollTaken
	 *            - how many times the dice have been rolled this turn
	 * @param pointsRolled
	 *            - how many points rolled so far this turn
	 * @param pointDifferance
	 *            - difference between the total points acquired so far and the
	 *            total score
	 * @return true if player should roll false if they should hold
	 */
	boolean rollAgain(int rollTaken, int pointsRolled, int pointDifferance);

}
