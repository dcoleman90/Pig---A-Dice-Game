package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

class TestWhenTakeTurnIsMyTurn {

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * This test will insure that the takeTurn method successfully sets the isMyTurn instance variable to false
	 * It test this by calling the method getIsMyTurn
	 */
	@Test
	void testParametersOfTakeTurnByInsuringIsMyTurnEqualsFalseWhenA1IsRolled() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer acer = new ComputerPlayer(nervious);
		for (int count = 0; count < 1000; count++) {
			acer.takeTurn();
			if (acer.getDie1Result() == 1 || acer.getDie2Result() == 1) {
				while (acer.getIsMyTurn()) {
					fail("Test remained true after a one was rolled: Die 1: " + acer.getDie1Result()
							+ " Die 2: " + acer.getDie2Result());
				}
			}
		}
	}
	
	/**
	 * This test will insure that the takeTurn method successfully sets the isMyTurn instance variable to true
	 * It test this by calling the method getIsMyTurn
	 */
	@Test
	void testParametersOfTakeTurnByInsuringIsMyTurnEqualsTrueIsCalledWhenNo1sAreRolled() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer acer = new ComputerPlayer(nervious);
		for (int count = 0; count < 1000; count++) {
			acer.takeTurn();
			if (acer.getDie1Result() != 1 && acer.getDie2Result() != 1) {
				while (!acer.getIsMyTurn()) {
					fail("Test remained false when numbers other than one where rolled: Die 1: " + acer.getDie1Result()
							+ " Die 2: " + acer.getDie2Result());
				}
			}
		}
	}

}
