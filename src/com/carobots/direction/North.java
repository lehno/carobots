package com.carobots.direction;

/***
 * North direction of robot
 */

import com.carobots.entity.Position;
import com.carobots.rest.IllegalPosition;

public class North implements AbstractDirection {

	@Override
	public Position move(Position posicao) throws IllegalPosition {
		return new Position(posicao.getX(), posicao.getY() + 1, posicao.getGround());
	}

	@Override
	public AbstractDirection turnRight() {
		return new East();
	}

	@Override
	public AbstractDirection turnLeft() {
		return new West();
	}

	@Override
	public String toString() {
		return "N";
	}

}