package edu.westga.cs6910.testing.computerPlayer;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

class TestWhenTakeTurnResetTurn {

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * This test will insure that the takeTurn method successfully resets the turn
	 * total to 0 It test this by calling the method
	 */
	@Test
	void testParametersOfTakeTurnByInsuringResetTurnTotalIsCalledWhenA1IsRolled() {
		ComputerPlayer drew = new ComputerPlayer();
		for (int count = 0; count < 1000; count++) {
			drew.takeTurn();
			if (drew.getDie1Result() == 1 || drew.getDie2Result() == 1) {
				while (drew.getTurnTotal() != 0) {
					fail("Test the computer players turn after a one was rolled was not equal to zero| Turn was equal to: " + drew.getTurnTotal());
				}
			}
		}
	}

}
