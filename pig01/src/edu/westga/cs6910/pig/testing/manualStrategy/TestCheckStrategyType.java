package edu.westga.cs6910.pig.testing.manualStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.ManualStrategy;

class TestCheckStrategyType {


	/**
	 * This test will insure that the Strategy returns the correct type
	 */
	@Test
	void testCheckStrategyTypeExpectedReturn1() {
		ManualStrategy strategy = new ManualStrategy();
		assertEquals(1, strategy.checkStrategyType());
	}

}
