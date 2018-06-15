package edu.westga.cs6910.pig.testing.computerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

class TestWhenMaxiumRolls {

	/**
	 * This test will check the default method to insure that it sets the maximum rolls at 1 
	 */
	@Test
	void testGetMaxiumRollsDefaultShouldReturn1() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer alien = new ComputerPlayer(nervious);
		alien.setMaximumRolls();
		assertEquals(1, alien.getMaxiumRolls());
	}
	
	/**
	 * This test will check the method after accepting a value of 5
	 */
	@Test
	void testGetMaiumRollsWithAValueOf5() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer alien = new ComputerPlayer(nervious);
		alien.setMaximumRolls(5);
		assertEquals(5, alien.getMaxiumRolls());
	}
	
	/**
	 * This test will check the method after accepting a value of 17
	 */
	@Test
	void testGetMaiumRollsWithAValueOf17() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer alien = new ComputerPlayer(nervious);
		alien.setMaximumRolls(17);
		assertEquals(17, alien.getMaxiumRolls());
	}
	
	
	/**
	 * This test will check the method after accepting a value of 500
	 */
	@Test
	void testGetMaiumRollsWithAValueOf500() {
		CautiousStrategy nervious = new CautiousStrategy();
		ComputerPlayer alien = new ComputerPlayer(nervious);
		alien.setMaximumRolls(500);
		assertEquals(500, alien.getMaxiumRolls());
	}
	
}
