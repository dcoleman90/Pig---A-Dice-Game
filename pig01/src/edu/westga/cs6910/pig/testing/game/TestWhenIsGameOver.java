package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

class TestWhenIsGameOver {

	/**
	 * This test will insure that if the currentPlayerObject is null when startGame is not called and returns true
	 */
	@Test
	void testIsGameOverByCheckingTrueWhenCalledBeforeStartGameAsTheValueIsNull() {
		ComputerPlayer dell = new ComputerPlayer();
		dell.setTotal(15);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		assertEquals(true, risk.isGameOver());
	}

	/**
	 * This test will insure that if the currentPlayerObject >= GOAL_SCORE then it returns true
	 */
	@Test
	void testIsGameOverByCheckingCurrentPlayerObjectValueIsOver100ReturnTrue() {
		ComputerPlayer dell = new ComputerPlayer();
		dell.setTotal(105);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.startNewGame(dell);
		assertEquals(true, risk.isGameOver());
	}
	
	/**
	 * This test will insure that if the currentPlayerObject >= GOAL_SCORE then it returns true
	 */
	@Test
	void testIsGameOverByCheckingCurrentPlayerObjectValueIsEqualTo100ReturnTrue() {
		ComputerPlayer dell = new ComputerPlayer();
		dell.setTotal(100);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.startNewGame(dell);
		assertEquals(true, risk.isGameOver());
	}
	
	/**
	 * This test will insure that if the currentPlayerObject <= GOAL_SCORE then it returns false
	 */
	@Test
	void testIsGameOverByCheckingCurrentPlayerObjectValueIsBelow100ReturnFalse() {
		ComputerPlayer dell = new ComputerPlayer();
		dell.setTotal(15);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.startNewGame(dell);
		assertEquals(false, risk.isGameOver());
	}
	
	/**
	 * This test will insure that if the currentPlayerObject Value has not been set then it returns false
	 */
	@Test
	void testIsGameOverByCheckingCurrentPlayerObjectValueHasNotBeenSet() {
		ComputerPlayer dell = new ComputerPlayer();
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.startNewGame(dell);
		assertEquals(false, risk.isGameOver());
	}
}
