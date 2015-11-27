package com.carobots.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.carobots.entity.Ground;
import com.carobots.entity.Position;
import com.carobots.rest.IllegalPosition;

public class PositionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testInvalidPosition() throws Exception {
		thrown.expect(IllegalArgumentException.class);
		new Position(0, 0, null);
		thrown.expect(IllegalPosition.class);
		new Position(1, 2, new Ground(1,1));
		thrown.expect(IllegalPosition.class);
		new Position(2, 1, new Ground(1,1));
		thrown.expect(IllegalPosition.class);
		new Position(3, 3, new Ground(1,1));
		thrown.expect(IllegalPosition.class);
		new Position(-1, 1, new Ground(1,2));
		thrown.expect(IllegalPosition.class);
		new Position(1, -1, new Ground(2,1));
		thrown.expect(IllegalPosition.class);
		new Position(-1, -1, new Ground(1,1));
		thrown.expect(IllegalPosition.class);
		new Position(1, 1, new Ground(-1,-1));
		thrown.expect(IllegalPosition.class);
		new Position(1, 1, new Ground(2,-1));
		thrown.expect(IllegalPosition.class);
		new Position(1, 1, new Ground(-1,2));
	}
}
