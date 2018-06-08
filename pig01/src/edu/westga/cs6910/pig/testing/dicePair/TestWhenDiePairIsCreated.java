package edu.westga.cs6910.pig.testing.dicePair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

class TestWhenDiePairIsCreated {

	/**
	 * This test will in sure that two Die with one pip each are showing when the
	 * object is created
	 * This test checks the first Die of the pair
	 */
	@Test
	void testShouldProduce2DieWith1PipEachTestFirstDie() {
		DicePair snakeEyes = new DicePair();
		assertEquals(1, snakeEyes.getDie1Value());
	}
	
	/**
	 * This test will in sure that two Die with one pip each are showing when the
	 * object is created
	 * This test checks the second Die of the pair
	 */
	@Test
	void testShouldProduce2DieWith1PipEachTestSecondDie() {
		DicePair snakeEyes = new DicePair();
		assertEquals(1, snakeEyes.getDie2Value());
	}

}
