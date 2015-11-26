package com.carobots.rest;

/***
 * IllegalPosition is used to represents when the robot is trying to leave from
 * setted ground
 * 
 * @author Leandro Hoffmann
 * @since 1.0
 */

public class IllegalPosition extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalPosition(String exc) {
		super(exc);
	}
}
