package com.carobots.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.carobots.direction.AbstractDirection;
import com.carobots.direction.East;
import com.carobots.direction.North;
import com.carobots.direction.South;
import com.carobots.direction.West;
import com.carobots.rest.IllegalPosition;

/***
 * Entity Robot and methods to move and turn the direction
 * 
 * @author Leandro Hoffmann
 * @since 1.0
 */

@XmlRootElement
public class Robot {

	private AbstractDirection direction;
	private Position position;

	/**
	 * Constructor of robots, validating the initial direction
	 * 
	 * @param x
	 * @param y
	 * @param direcao
	 * @param ground
	 * @throws IllegalPosition
	 */
	public Robot(int x, int y, char direcao, Ground ground)
			throws IllegalPosition {
		checkDirection(direcao);
		this.position = new Position(x, y, ground);
	}

	/**
	 * Turn the robot to right, independent of the actual direction
	 */
	public void turnRight() {
		this.direction = direction.turnRight();
	}

	/**
	 * Turn the robot to left, independent of the actual direction
	 */
	public void turnLeft() {
		this.direction = direction.turnLeft();
	}

	/**
	 * Move robot to one block ahead of actual position
	 */
	public void move() throws IllegalPosition, NullPointerException {
		this.position = direction.move(this.position);
	}

	/***
	 * Check the first direction of the robot. Expected N, S, E, W
	 * 
	 * @param direction
	 */
	private void checkDirection(char direction) {
		switch (direction) {
		case 'N':
			this.direction = new North();
			break;
		case 'S':
			this.direction = new South();
			break;
		case 'E':
			this.direction = new East();
			break;
		case 'W':
			this.direction = new West();
			break;
		default:
			throw new IllegalArgumentException("Invalid Direction");
		}
	}

	public String toString() {
		return this.position + "," + this.direction;
	}

	public Position getPosition() {
		return this.position;
	}
	
	public AbstractDirection getDirection() {
		return this.direction;
	}

}
