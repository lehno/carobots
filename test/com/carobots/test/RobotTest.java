package com.carobots.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.carobots.direction.East;
import com.carobots.direction.North;
import com.carobots.direction.South;
import com.carobots.direction.West;
import com.carobots.entity.Ground;
import com.carobots.entity.Robot;
import com.carobots.rest.IllegalPosition;

public class RobotTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testDirection() throws IllegalPosition {
		Robot robotNorth = new Robot(0, 0, 'N', new Ground(5, 5));
		Assert.assertEquals('N', robotNorth.getDirection().toString().charAt(0));
		Robot robotSouth = new Robot(0, 0, 'S', new Ground(5, 5));
		Assert.assertEquals('S', robotSouth.getDirection().toString().charAt(0));
		Robot robotWest = new Robot(0, 0, 'W', new Ground(5, 5));
		Assert.assertEquals('W', robotWest.getDirection().toString().charAt(0));
		Robot robotEast = new Robot(0, 0, 'E', new Ground(5, 5));
		Assert.assertEquals('E', robotEast.getDirection().toString().charAt(0));
		thrown.expect(IllegalArgumentException.class);
		new Robot(0, 0, 'Y', new Ground(5, 5));
	}

	@Test
	public void testMovement() throws Exception {
		Robot robot = new Robot(0, 0, new North().toString().charAt(0),
				new Ground(5, 5));
		robot.move();
		Assert.assertEquals(0, robot.getPosition().getX());
		Assert.assertEquals(1, robot.getPosition().getY());
		Assert.assertEquals(new North().toString(), robot.getDirection()
				.toString());

		robot.move();
		robot.move();
		robot.turnRight();
		robot.move();

		Assert.assertEquals(1, robot.getPosition().getX());
		Assert.assertEquals(3, robot.getPosition().getY());
		Assert.assertEquals(new East().toString(), robot.getDirection()
				.toString());

		robot.turnRight();
		Assert.assertEquals(1, robot.getPosition().getX());
		Assert.assertEquals(3, robot.getPosition().getY());
		Assert.assertEquals(new South().toString(), robot.getDirection()
				.toString());

		robot.turnRight();
		robot.move();
		Assert.assertEquals(0, robot.getPosition().getX());
		Assert.assertEquals(3, robot.getPosition().getY());
		Assert.assertEquals(new West().toString(), robot.getDirection()
				.toString());

		robot.turnLeft();
		robot.move();
		robot.move();
		robot.move();
		thrown.expect(IllegalPosition.class);
		robot.move();
	}

	@Test
	public void testResult() throws IllegalPosition {
		Robot robotNorth = new Robot(0, 0, 'N', new Ground(5, 5));
		Assert.assertEquals("0,0,N", robotNorth.toString());
	}
}
