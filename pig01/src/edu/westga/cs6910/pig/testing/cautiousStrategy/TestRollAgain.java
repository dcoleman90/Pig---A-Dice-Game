package edu.westga.cs6910.pig.testing.cautiousStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

class TestRollAgain {

	/**
	 * This test insure that the rollAgain returns false regardless of input
	 */
	@Test
	void testCautiousStrategyRollAgainAfterRolling2TimesExpectTrue() {
		CautiousStrategy careful = new CautiousStrategy();
		assertEquals(false, careful.rollAgain(2, 5, 99));
	}
	
	/**
	 * This test insure that the rollAgain returns false regardless of input
	 */
	@Test
	void testCautiousStrategyRollAgainAfterAmountGainedIs10TimesExpectTrue() {
		CautiousStrategy careful = new CautiousStrategy();
		assertEquals(false, careful.rollAgain(1, 10, 99));
	}
	
	/**
	 * This test insure that the rollAgain returns false regardless of input
	 */
	@Test
	void testCautiousStrategyRollAgainShouldNotTriggerExpectFalse() {
		CautiousStrategy careful = new CautiousStrategy();
		assertEquals(false, careful.rollAgain(0, 8, 1));
	}

}
