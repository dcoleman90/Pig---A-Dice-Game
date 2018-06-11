package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

class TestWhenConstructorToString {
	
	/**
	 * This test will insure that after construction Game toString() displays the expected results
	 */
	@Test
	void testConstructorToStringByComparingToExpectedResult() {
		ComputerPlayer dell = new ComputerPlayer();
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		assertEquals("Goal Score: 100"
				+ System.getProperty("line.separator") + "Wayne: 0"
				+ System.getProperty("line.separator") + "Simple Computer: 0", risk.toString());
	}
	
}
