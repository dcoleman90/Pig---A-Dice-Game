package edu.westga.cs6910.pig.testing.cautiousStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

class TestCheckStrategyType {


	/**
	 * This test will insure that the Strategy returns the correct type
	 */
	@Test
	void testCheckStrategyTypeExpectedReturn1() {
		CautiousStrategy strategy = new CautiousStrategy();
		assertEquals(0, strategy.checkStrategyType());
	}

}