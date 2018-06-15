package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

class TestWhenGetDiceValues {

	/**
	 * This test will insure that when constructed the Die pips on both dice are set at 1
	 * 
	 */
	@Test
	void testGetDiceValuesIsCalledAfterConstructionBothDiceAreSetAt1() {
		ComputerPlayer dell = new ComputerPlayer();
		assertEquals("1, 1", dell.getDiceValues());
	}

}
