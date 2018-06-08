package edu.westga.cs6910.testing.humanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

class TestHumanPlayerGetName {

	/**
	 * This test will insure that the given Human Player name in the constructor is
	 * passed to the getName method
	 */
	@Test
	void testGetNameMethodWithNameDave() {
		HumanPlayer earthling = new HumanPlayer("Dave");
		assertEquals("Dave", earthling.getName());
	}


	/**
	 * This test will insure that the given Human Player name in the constructor is
	 * passed to the getName method
	 */
	@Test
	void testGetNameMethodWithNameKevin() {
		HumanPlayer earthling = new HumanPlayer("Kevin");
		assertEquals("Kevin", earthling.getName());
	}


	/**
	 * This test will insure that the given Human Player name in the constructor is
	 * passed to the getName method
	 */
	@Test
	void testGetNameMethodWithNameStacy() {
		HumanPlayer earthling = new HumanPlayer("Stacy");
		assertEquals("Stacy", earthling.getName());
	}

}


