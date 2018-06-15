package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

class TestWhenGetTotal {

	/**
	 * This test will insure when the class is constructed it returns a total of 0;
	 */
	@Test
	void testConstructedTotalResultsIn0() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer acer = new ComputerPlayer(nervious);
		assertEquals(0, acer.getTotal());
	}

}
