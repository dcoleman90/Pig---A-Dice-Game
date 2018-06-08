package edu.westga.cs6910.pig.testing.dicePair;

import static org.junit.Assert.fail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

class TestWhenDicePairRolls {

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * This test will call the rollDice method 10,000 times to insure that all dice
	 * rolls remain within the boundary of 1-6 of acceptable results
	 */
	@Test
	void testRollDiceParametersByCalling10000Times() {
		DicePair rolledDicePair = new DicePair();
		for (int count = 0; count < 10000; count++) {
			rolledDicePair.rollDice();
			if (rolledDicePair.getDie1Value() < 1 || rolledDicePair.getDie1Value() > 6) {
				fail("Rolled a DicePair1 with value: " + rolledDicePair.getDie1Value());
			} else if (rolledDicePair.getDie2Value() < 1 || rolledDicePair.getDie2Value() > 6) {
				fail("Rolled a DicePair2 with value: " + rolledDicePair.getDie2Value());
			}
		}
	}
}
