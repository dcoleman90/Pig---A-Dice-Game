package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

class TestWhenDieIsCreated {

	/**
	 * This test will test the constructor and insure that when a new dice is made it starts with one pip
	 */
	@Test
	void testShouldProduceDieWith1Pip() {
		Die newDie = new Die(new Random());
		assertEquals("pips: 1", newDie.toString());
	}

}
