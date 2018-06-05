package edu.westga.cs6910.pig.model;

/**
 * This is an Abstract Class which will provide the building blocks for the Player classes
 * @author Drew Coleman
 * @version 06/05/2018
 *
 */
public abstract class AbstractPlayer implements Player {
	private String name;
	private DicePair thePair;
	private boolean isMyTurn;	
	private int total;
	private int turnTotal;
	
	AbstractPlayer(String name) {
		
	}

}
