package edu.westga.cs6910.pig.testing.randomStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.cs6910.pig.model.strategies.RandomStrategy;

/**
 * This test will check 5 identical test to insure proper coverage. As this is
 * testing random variables it is possible but extremely unlikely that the test
 * could fail but the RandomStrategy class work perfectly. Testing five
 * different test will help insure that everything is staying within a certain
 * margin of error
 * 
 * @author Drew Coleman
 * @version 06/19/18
 *
 */
class TestRollAgain {

	/**
	 * This test will insure that the RandomStrategy stays within a specific range
	 * as it is a random variable it is possible for it to be working successfully
	 * and fail the test. This is extremely unlikely.
	 * 
	 * The test returns true if (which ever is smaller) true/false is returned at
	 * least 40% of the time - leaving a margin of error of about 10% both ways
	 */
	@Test
	void testRandomStrategyInsuringMarginOfErrorWithin10Percent() {
		RandomStrategy random = new RandomStrategy();
		int rolledAgain = 0;
		int didNotRoll = 0;
		for (int count = 0; count < 1000; count++) {
			if (random.rollAgain(0, 0, 0)) {
				rolledAgain++;
			} else {
				didNotRoll++;
			}
		}
		boolean withInMarginOfError;
		if (rolledAgain - didNotRoll > 400 || didNotRoll - rolledAgain > 400) {
			withInMarginOfError = false;
		} else {
			withInMarginOfError = true;
		}
		assertEquals(true, withInMarginOfError);
	}

	/**
	 * This test will insure that the RandomStrategy stays within a specific range
	 * as it is a random variable it is possible for it to be working successfully
	 * and fail the test. This is extremely unlikely.
	 * 
	 * The test returns true if (which ever is smaller) true/false is returned at
	 * least 40% of the time - leaving a margin of error of about 10% both ways
	 */
	@Test
	void testRandomStrategyInsuringMarginOfErrorWithin10PercentTest2() {
		RandomStrategy random = new RandomStrategy();
		int rolledAgain = 0;
		int didNotRoll = 0;
		for (int count = 0; count < 1000; count++) {
			if (random.rollAgain(0, 0, 0)) {
				rolledAgain++;
			} else {
				didNotRoll++;
			}
		}
		boolean withInMarginOfError;
		if (rolledAgain - didNotRoll > 400 || didNotRoll - rolledAgain > 400) {
			withInMarginOfError = false;
		} else {
			withInMarginOfError = true;
		}
		assertEquals(true, withInMarginOfError);
	}

	/**
	 * This test will insure that the RandomStrategy stays within a specific range
	 * as it is a random variable it is possible for it to be working successfully
	 * and fail the test. This is extremely unlikely.
	 * 
	 * The test returns true if (which ever is smaller) true/false is returned at
	 * least 40% of the time - leaving a margin of error of about 10% both ways
	 */
	@Test
	void testRandomStrategyInsuringMarginOfErrorWithin10PercentTest3() {
		RandomStrategy random = new RandomStrategy();
		int rolledAgain = 0;
		int didNotRoll = 0;
		for (int count = 0; count < 1000; count++) {
			if (random.rollAgain(0, 0, 0)) {
				rolledAgain++;
			} else {
				didNotRoll++;
			}
		}
		boolean withInMarginOfError;
		if (rolledAgain - didNotRoll > 400 || didNotRoll - rolledAgain > 400) {
			withInMarginOfError = false;
		} else {
			withInMarginOfError = true;
		}
		assertEquals(true, withInMarginOfError);
	}

	/**
	 * This test will insure that the RandomStrategy stays within a specific range
	 * as it is a random variable it is possible for it to be working successfully
	 * and fail the test. This is extremely unlikely.
	 * 
	 * The test returns true if (which ever is smaller) true/false is returned at
	 * least 40% of the time - leaving a margin of error of about 10% both ways
	 */
	@Test
	void testRandomStrategyInsuringMarginOfErrorWithin10PercentTest4() {
		RandomStrategy random = new RandomStrategy();
		int rolledAgain = 0;
		int didNotRoll = 0;
		for (int count = 0; count < 1000; count++) {
			if (random.rollAgain(0, 0, 0)) {
				rolledAgain++;
			} else {
				didNotRoll++;
			}
		}
		boolean withInMarginOfError;
		if (rolledAgain - didNotRoll > 400 || didNotRoll - rolledAgain > 400) {
			withInMarginOfError = false;
		} else {
			withInMarginOfError = true;
		}
		assertEquals(true, withInMarginOfError);
	}

	/**
	 * This test will insure that the RandomStrategy stays within a specific range
	 * as it is a random variable it is possible for it to be working successfully
	 * and fail the test. This is extremely unlikely.
	 * 
	 * The test returns true if (which ever is smaller) true/false is returned at
	 * least 40% of the time - leaving a margin of error of about 10% both ways
	 */
	@Test
	void testRandomStrategyInsuringMarginOfErrorWithin10PercentTest5() {
		RandomStrategy random = new RandomStrategy();
		int rolledAgain = 0;
		int didNotRoll = 0;
		for (int count = 0; count < 1000; count++) {
			if (random.rollAgain(0, 0, 0)) {
				rolledAgain++;
			} else {
				didNotRoll++;
			}
		}
		boolean withInMarginOfError;
		if (rolledAgain - didNotRoll > 400 || didNotRoll - rolledAgain > 400) {
			withInMarginOfError = false;
		} else {
			withInMarginOfError = true;
		}
		assertEquals(true, withInMarginOfError);
	}
}
