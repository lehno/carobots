package com.carobots.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.carobots.entity.Ground;
import com.carobots.entity.Robot;

/***
 * Class that command the robot in mars
 * 
 * @author Leandro Hoffmann
 * @since 1.0
 */

@Path("mars")
public class Mars {

	/**
	 * Show when no commands send to system
	 * 
	 * @return string
	 */
	@GET
	@Path("/")
	public Response withoutCommands() {
		return Response.status(400).build();
	}

	/**
	 * Move the robot using a command. This command accepts M to move, L to turn
	 * left, R to turn right. The command is a concatenated string with informed
	 * letters. Example: MMRMMRMMRMMR
	 * 
	 * @param command
	 * @return Robot's Position
	 */
	@POST
	@Path("/{command}")
	public Response moveRobot(@PathParam("command") String command) {
		final String INIT_POS = "N";
		final int INIT_X = 0;
		final int INIT_Y = 0;
		final int GROUND_X = 5;
		final int GROUND_Y = 5;
		String result = "";
		if (command != null) {
			try {
				Robot robot = new Robot(INIT_X, INIT_Y, INIT_POS.charAt(0), new Ground(GROUND_X, GROUND_Y));
				for (int x = 0; x < command.length(); x++) {
					switch (command.charAt(x)) {
					case 'M':
						robot.move();
						break;
					case 'L':
						robot.turnLeft();
						break;
					case 'R':
						robot.turnRight();
						break;
					default:
						throw new IllegalArgumentException("Invalid command");
					}
					result = robot.toString();
				}
			} catch (IllegalPosition e) {
				return Response.status(400).build();
			} catch (IllegalArgumentException e) {
				return Response.status(400).build();
			}
		}
		return Response.status(200).entity(result).build();
	}
}
