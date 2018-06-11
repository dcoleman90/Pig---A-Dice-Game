package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

class TestWhenHold {

	/**
	 * This test checks to insure that when hold() is called the currentPlayer changes to the other player
	 * In this test it changes from ComputerPlayer to HumanPlayer
	 */
	@Test
	void testHoldCurrentPlayerSwitchesPlayerExpectedHumanPlayer() {
		ComputerPlayer dell = new ComputerPlayer();
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.setTheComputer(dell);
		risk.hold();
		assertEquals(wayne, risk.getCurrentPlayer());
	}
	
	/**
	 * This test will insure that when hold() is called the resetTurnTotal is triggered and the new currentPlayer has a 
	 * turn total of 0
	 */
	@Test
	void testHoldCurrentPlayerResetTurnTotalTo0() {
		ComputerPlayer dell = new ComputerPlayer();
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.setCurrentPlayerObjectToComputer(dell);
		risk.hold();
		assertEquals(0, wayne.getTurnTotal());
	}
	
	/**
	 * This test checks to insure that when hold() is called the currentPlayer changes to the other player
	 * In this test it changes from ComputerPlayer to HumanPlayer
	 */
	@Test
	void testHoldCurrentPlayerSwitchesPlayerExpectedComputerPlayer() {
		ComputerPlayer dell = new ComputerPlayer();
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.setCurrentPlayerObjectToHuman(wayne);
		risk.hold();
		assertEquals(dell, risk.getCurrentPlayer());
	}
	
	/**
	 * This test will insure that when hold() is called the resetTurnTotal is triggered and the new currentPlayer has a 
	 * turn total of 0
	 */
	@Test
	void testHoldCurrentComputerPlayerResetTurnTotalTo0() {
		ComputerPlayer dell = new ComputerPlayer();
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.setTheHuman(wayne);
		risk.hold();
		assertEquals(0, dell.getTurnTotal());
	}
}
