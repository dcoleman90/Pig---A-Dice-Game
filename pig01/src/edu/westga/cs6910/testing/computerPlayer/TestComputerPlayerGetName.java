package edu.westga.cs6910.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

class TestComputerPlayerGetName {

	/**
	 * This test will insure that the given Computer Player name in the constructor is
	 * passed to the getName method
	 */
	@Test
	void testGetNameMethodWithNameSimpleComputer() {
		ComputerPlayer earthling = new ComputerPlayer();
		assertEquals("Simple Computer", earthling.getName());
	}
}