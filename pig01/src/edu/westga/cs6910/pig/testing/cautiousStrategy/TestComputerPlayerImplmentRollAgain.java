package edu.westga.cs6910.pig.testing.cautiousStrategy;

import static org.junit.Assert.fail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

class TestComputerPlayerImplmentRollAgain {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer hal = new ComputerPlayer(nervious);
		for (int count = 0; count < 5; count++) {
			hal.takeTurn();
			if (hal.getNumOfTurnsTaken() == 2) {
				while (hal.getTurnTotal() > 10) {
					fail("Test the Cautious computer player did not play exactly 2 turns " + hal.getNumOfTurnsTaken() + " Value of Dice was " + hal.getTurnTotal());
				}
			}
		}
	}

}
