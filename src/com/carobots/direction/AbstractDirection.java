package com.carobots.direction;

import com.carobots.entity.Position;
import com.carobots.rest.IllegalPosition;

/**
 * Abstract class to move robot and show the position
 * 
 * @author Leandro Hoffmann
 * 
 */

public interface AbstractDirection {

	/**
	 * Move the robot from its actual position to new one
	 * 
	 * @param posicao
	 * @return
	 * @throws IllegalPosition
	 */
	public Position move(Position posicao) throws IllegalPosition;

	/**
	 * Turn the robot to right from his actual position
	 * 
	 * @return new direction
	 */
	public AbstractDirection turnRight();

	/**
	 * Turn the robot to left from his actual position
	 * 
	 * @return new direction
	 */
	public AbstractDirection turnLeft();

	/**
	 * Return the representation of position in string
	 * 
	 * @return position
	 */
	public String toString();

}
