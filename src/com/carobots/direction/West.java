package com.carobots.direction;

/**
 * West direction of robot
 */

import com.carobots.entity.Position;
import com.carobots.rest.IllegalPosition;

public class West implements AbstractDirection {

	@Override
	public Position move(Position posicao) throws IllegalPosition {
		return new Position(posicao.getX() - 1, posicao.getY(), posicao.getGround());
	}

	@Override
	public AbstractDirection turnRight() {
		return new North();
	}

	@Override
	public AbstractDirection turnLeft() {
		return new South();
	}

	@Override
	public String toString() {
		return "W";
	}

}