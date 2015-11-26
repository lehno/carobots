package com.carobots.direction;

/**
 * East direction of robot
 */

import com.carobots.entity.Position;
import com.carobots.rest.IllegalPosition;

public class East implements AbstractDirection {

	@Override
	public Position move(Position position) throws IllegalPosition {
		return new Position(position.getX() + 1, position.getY(), position.getGround());
	}

	@Override
	public AbstractDirection turnRight() {
		return new South();
	}

	@Override
	public AbstractDirection turnLeft() {
		return new North();
	}

	@Override
	public String toString() {
		return "E";
	}

}