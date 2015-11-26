package com.carobots.entity;

/**
 * Entity ground, to set the x,y of total and limitates the robot
 * 
 * @author Leandro Hoffmann
 * 
 */

public class Ground {

	private int x;
	private int y;

	public Ground(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}