package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

class TestWhenGetPips {

	/**
	 * This test will check the getNumberOfPips method and insure it returns one
	 * when a new die is called
	 */
	@Test
	void testWithNewDieShouldHave1Pip() {
		Die newDie = new Die(new Random());
		assertEquals(1, newDie.getNumberOfPips());
	}
}
