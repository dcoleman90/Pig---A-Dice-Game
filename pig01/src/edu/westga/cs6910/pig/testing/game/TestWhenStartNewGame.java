package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

class TestWhenStartNewGame {

	/**
	 * This test will insure that the accepted Player object becomes the new currentPlayer
	 */
	@Test
	void testNewGameStartedPassedInPlayerIsHumanWayne() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer dell = new ComputerPlayer(nervious);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.startNewGame(wayne);
		assertEquals(wayne, risk.getCurrentPlayer());
	}
	
	/**
	 * This test will insure that the accepted Player object becomes the new currentPlayer
	 */
	@Test
	void testNewGameStartedPassedInPlayerIsComputer() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer dell = new ComputerPlayer(nervious);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.startNewGame(dell);
		assertEquals(dell, risk.getCurrentPlayer());
	}
	
	/**
	 * This test will insure that the accepted Player object becomes the new currentPlayer
	 */
	@Test
	void testNewGameStartedDicePairIsStarted() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer dell = new ComputerPlayer(nervious);
		HumanPlayer wayne = new HumanPlayer("Wayne");
		Game risk = new Game(wayne, dell);
		risk.startNewGame(wayne);
		assertEquals("Die1: 1 Die2: 1", risk.getDicePair().toString());
	}

}
