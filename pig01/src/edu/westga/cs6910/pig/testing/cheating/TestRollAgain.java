package edu.westga.cs6910.pig.testing.cheating;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.Cheater;

class TestRollAgain {

	/**
	 * This test insure that the rollAgain returns false regardless of input
	 */
	@Test
	void testCheaterRollAgainAfterRolling2TimesExpectTrue() {
		Cheater cheater = new Cheater();
		assertEquals(false, cheater.rollAgain(2, 5, 99));
	}
	
	/**
	 * This test insure that the rollAgain returns false regardless of input
	 */
	@Test
	void testCheaterRollAgainAfterAmountGainedIs10TimesExpectTrue() {
		Cheater cheater = new Cheater();
		assertEquals(false, cheater.rollAgain(1, 10, 99));
	}
	
	/**
	 * This test insure that the rollAgain returns false regardless of input
	 */
	@Test
	void testCheaterRollAgainShouldNotTriggerExpectFalse() {
		Cheater cheater = new Cheater();
		assertEquals(false, cheater.rollAgain(0, 8, 1));
	}

}
