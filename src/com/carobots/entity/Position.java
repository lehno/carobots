package com.carobots.entity;

import com.carobots.rest.IllegalPosition;

/***
 * Class that determines the position of robot and where it is on ground
 * 
 * @author Leandro Hoffmann
 * 
 */

public class Position {

	private int x;
	private int y;
	private Ground ground;

	/***
	 * Set the position of the robot on ground and its direction
	 * 
	 * @param x
	 * @param y
	 * @param ground
	 * @throws IllegalPosition
	 */
	public Position(int x, int y, Ground ground) throws IllegalPosition {
		if (ground == null) {
			throw new IllegalArgumentException();
		}
		if (x < 0 || x > ground.getX()) {
			throw new IllegalPosition("Invalid Position, outside of ground");
		} else if (y < 0 || y > ground.getY()) {
			throw new IllegalPosition("Invalid Position, outside of ground");
		} else {
			this.ground = ground;
			this.x = x;
			this.y = y;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/***
	 * Get the ground to new position
	 * 
	 * @return ground
	 */
	public Ground getGround() {
		return ground;
	}

	public String toString() {
		return this.getX() + "," + this.getY();
	}
}