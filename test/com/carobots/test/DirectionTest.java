package com.carobots.test;

import org.junit.Assert;
import org.junit.Test;

import com.carobots.direction.AbstractDirection;
import com.carobots.direction.East;
import com.carobots.direction.North;
import com.carobots.direction.South;
import com.carobots.direction.West;

public class DirectionTest {

	@Test
    public void testRotateFromNorth() {
		North north = new North();
		
        AbstractDirection east = north.turnRight();
        Assert.assertEquals(new East().toString(), east.toString());
        
        AbstractDirection west = north.turnLeft();
        Assert.assertEquals(new West().toString(), west.toString());
    }
	
	@Test
    public void testRotateFromEast() {
		East east = new East();
		
        AbstractDirection south = east.turnRight();
        Assert.assertEquals(new South().toString(), south.toString());
        
        AbstractDirection north = east.turnLeft();
        Assert.assertEquals(new North().toString(), north.toString());
    }
	
	@Test
    public void testRotateFromWest() {
		West west = new West();
		
        AbstractDirection north = west.turnRight();
        Assert.assertEquals(new North().toString(), north.toString());
        
        AbstractDirection south = west.turnLeft();
        Assert.assertEquals(new South().toString(), south.toString());
    }
	
	@Test
    public void testRotateFromSouth() {
		South south = new South();
		
        AbstractDirection west = south.turnRight();
        Assert.assertEquals(new West().toString(), west.toString());
        
        AbstractDirection east = south.turnLeft();
        Assert.assertEquals(new East().toString(), east.toString());
    }
}
