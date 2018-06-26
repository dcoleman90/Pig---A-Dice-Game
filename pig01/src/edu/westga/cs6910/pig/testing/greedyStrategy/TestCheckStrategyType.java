package edu.westga.cs6910.pig.testing.greedyStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;

class TestCheckStrategyType {


	/**
	 * This test will insure that the Strategy returns the correct type
	 */
	@Test
	void testCheckStrategyTypeExpectedReturn1() {
		GreedyStrategy strategy = new GreedyStrategy();
		assertEquals(0, strategy.checkStrategyType());
	}

}