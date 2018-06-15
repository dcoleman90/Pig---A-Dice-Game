package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

class TestComputerPlayerGetName {

	/**
	 * This test will insure that the given Computer Player name in the constructor is
	 * passed to the getName method
	 */
	@Test
	void testGetNameMethodWithNameSimpleComputer() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer earthling = new ComputerPlayer(nervious);
		assertEquals("Simple Computer", earthling.getName());
	}
}