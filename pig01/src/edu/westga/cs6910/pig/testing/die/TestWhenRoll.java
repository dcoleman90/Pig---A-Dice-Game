package edu.westga.cs6910.pig.testing.die;

import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

class TestWhenRoll {

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * This test will call the Roll dice method 10,000 times to insure that all dice
	 * rolls remain within the boundary of 1-6 of acceptable results
	 */
	@Test
	void testRollParametersByCalling10000Times() {
		Die rolledDie = new Die(new Random());
		for (int count = 0; count < 10000; count++) {
			rolledDie.roll();
			if (rolledDie.getNumberOfPips() < 1 || rolledDie.getNumberOfPips() > 6) {
				fail("Rolled a Die with value: " + rolledDie.getNumberOfPips());
			}
		}
	}

}
