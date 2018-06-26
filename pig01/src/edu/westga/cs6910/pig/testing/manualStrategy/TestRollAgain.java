package edu.westga.cs6910.pig.testing.manualStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.ManualStrategy;

class TestRollAgain {

	/**
	 * This test insure that the rollAgain returns true regardless of input
	 */
	@Test
	void testManualStrategyRollAgainAfterRolling2TimesExpectTrue() {
		ManualStrategy careful = new ManualStrategy();
		assertEquals(true, careful.rollAgain(2, 5, 99));
	}
	
	/**
	 * This test insure that the rollAgain returns true regardless of input
	 */
	@Test
	void testManualStrategyRollAgainAfterAmountGainedIs10TimesExpectTrue() {
		ManualStrategy careful = new ManualStrategy();
		assertEquals(true, careful.rollAgain(1, 10, 99));
	}
	
	/**
	 * This test insure that the rollAgain returns true regardless of input
	 */
	@Test
	void testManualStrategyRollAgainShouldNotTriggerExpectFalse() {
		ManualStrategy careful = new ManualStrategy();
		assertEquals(true, careful.rollAgain(0, 8, 1));
	}

}
