package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

class TestWhenConstructorToString {

	/**
	 * This test will insure that after construction Game toString() displays the
	 * expected default results 
	 * Goal Score: 100 
	 * Wayne: 0 
	 * Simple Computer: 0
	 */
	@Test
	void testConstructorToStringByComparingToExpectedDefaultResult() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer dell = new ComputerPlayer(nervious);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		assertEquals("Goal Score: 100" + System.getProperty("line.separator") + "Wayne: 0"
				+ System.getProperty("line.separator") + "Simple Computer: 0", risk.toString());
	}

	/**
	 * This test will insure that after construction Game toString() displays the
	 * expected results
	 * Goal Score: 100 
	 * Wayne: 99 
	 * Simple Computer: 0
	 */
	@Test
	void testConstructorToStringByComparingToExpectedResult() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer dell = new ComputerPlayer(nervious);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		wayne.setTotal(99);
		assertEquals("Goal Score: 100" + System.getProperty("line.separator") + "Wayne: 99"
				+ System.getProperty("line.separator") + "Simple Computer: 0", risk.toString());
	}
	
	/**
	 * This test will insure that after construction Game toString() displays the
	 * expected results
	 * Goal Score: 100 
	 * Wayne: 99 
	 * Simple Computer: 0
	 * Game over! Winner: Wayne
	 */
	@Test
	void testConstructorToStringByComparingToExpectedResultWhenAPlayerWins() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer dell = new ComputerPlayer(nervious);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		wayne.setTotal(109);
		assertEquals("Goal Score: 100" + System.getProperty("line.separator") + "Wayne: 109"
				+ System.getProperty("line.separator") + "Simple Computer: 0" + System.getProperty("line.separator") 
				+ "Game over! Winner: Wayne", risk.toString());
	}
}
