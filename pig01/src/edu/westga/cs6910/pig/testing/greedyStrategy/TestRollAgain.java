package edu.westga.cs6910.pig.testing.greedyStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;

class TestRollAgain {

	/**
	 * This test insure that the rollAgain returns true when presented with 3 for number of times rolled
	 */
	@Test
	void testGreedyStrategyRollAgainAfterRolling2TimesExpectTrue() {
		GreedyStrategy greed = new GreedyStrategy();
		assertEquals(true, greed.rollAgain(3, 5, 99));
	}
	
	/**
	 * This test insure that the rollAgain returns false when rolls are >= 3 value gained >=30 and they didn't winfor number of times rolled
	 */
	@Test
	void testGreedyStrategyRollAgainAfterAmountGainedIs10TimesExpectTrue() {
		GreedyStrategy greed = new GreedyStrategy();
		assertEquals(false, greed.rollAgain(1, 10, 99));
	}

	/**
	 * This test insure that the rollAgain returns true when a value of 30 is presented
	 */
	@Test
	void testGreedyStrategyRollAgainShouldHaveAlreadyWonExpectTrue() {
		GreedyStrategy greed = new GreedyStrategy();
		assertEquals(true, greed.rollAgain(1, 5, -1));
	}
}
