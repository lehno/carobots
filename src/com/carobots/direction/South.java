package com.carobots.direction;

/**
 * South direction of robot
 */

import com.carobots.entity.Position;
import com.carobots.rest.IllegalPosition;

public class South implements AbstractDirection {

	@Override
	public Position move(Position posicao) throws IllegalPosition {
		return new Position(posicao.getX(), posicao.getY() - 1, posicao.getGround());
	}

	@Override
	public AbstractDirection turnRight() {
		return new West();
	}

	@Override
	public AbstractDirection turnLeft() {
		return new East();
	}

	@Override
	public String toString() {
		return "S";
	}

}