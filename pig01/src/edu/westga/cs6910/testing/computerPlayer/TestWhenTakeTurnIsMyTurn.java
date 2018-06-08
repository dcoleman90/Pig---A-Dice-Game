package edu.westga.cs6910.testing.computerPlayer;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

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
		ComputerPlayer drew = new ComputerPlayer();
		for (int count = 0; count < 1000; count++) {
			drew.takeTurn();
			if (drew.getDie1Result() == 1 || drew.getDie2Result() == 1) {
				while (drew.getIsMyTurn()) {
					fail("Test remained true after a one was rolled: Die 1: " + drew.getDie1Result()
							+ " Die 2: " + drew.getDie2Result());
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
		ComputerPlayer drew = new ComputerPlayer();
		for (int count = 0; count < 1000; count++) {
			drew.takeTurn();
			if (drew.getDie1Result() != 1 && drew.getDie2Result() != 1) {
				while (!drew.getIsMyTurn()) {
					fail("Test remained false when numbers other than one where rolled: Die 1: " + drew.getDie1Result()
							+ " Die 2: " + drew.getDie2Result());
				}
			}
		}
	}

}
