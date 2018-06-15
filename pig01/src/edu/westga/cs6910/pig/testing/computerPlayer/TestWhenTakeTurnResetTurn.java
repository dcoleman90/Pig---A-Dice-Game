package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

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
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer toshiba = new ComputerPlayer(nervious);
		for (int count = 0; count < 1000; count++) {
			toshiba.takeTurn();
			if (toshiba.getDie1Result() == 1 || toshiba.getDie2Result() == 1) {
				while (toshiba.getTurnTotal() != 0) {
					fail("Test the computer players turn after a one was rolled was not equal to zero| Turn was equal to: " + toshiba.getTurnTotal());
				}
			}
		}
	}

}
