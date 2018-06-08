package edu.westga.cs6910.testing.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

class TestWhenGetTotal {

	/**
	 * This test will insure when the class is constructed it returns a total of 0;
	 */
	@Test
	void testConstructedTotalResultsIn0() {
		HumanPlayer larry = new HumanPlayer("Larry");
		assertEquals(0, larry.getTotal());
	}

}
