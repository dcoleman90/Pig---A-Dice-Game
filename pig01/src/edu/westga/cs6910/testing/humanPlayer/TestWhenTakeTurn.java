package edu.westga.cs6910.testing.humanPlayer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

class TestWhenTakeTurn {

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * This test will insure that the takeTurn method successfully resets the turn total to 0
	 * It test this by calling the method 
	 */
	@Test
	void testParametersOfTakeTurnByInsuringResetTurnTotalIsCalledWhenA1IsRolled() {
		HumanPlayer drew = new HumanPlayer("Drew");
		for(int count = 0; count < 10000; count++) {
			drew.takeTurn();
			if (drew.get
		}
	}

}
