package org.maxhomes.ai.jupitermission;

import entities.Plateau;
import entities.Robot;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import request.CreatePlateauWithRobotRequest;
import request.CreateRobotRequest;
import request.ExecuteRobotCommandRequest;
import request.Request;
import request.TestRequest;
import response.ErrorResponse;
import response.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/resource")
public class Resource {
	Request request;
	Response response;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		request = new TestRequest();
		try {
			response = request.process();
		} catch (Exception e) {
			response = new ErrorResponse();
			response.setError(e.getMessage());
			System.err.println("Error testing " + e.getMessage());
		}
		return response.toString();
	}

	@POST
	@Path("/createplateau")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewPlateau(CreatePlateauWithRobotRequest requestPayload) {
		Plateau plateau = requestPayload.getPlateau();
		Robot robot = requestPayload.getRobot();
		request = new CreatePlateauWithRobotRequest(plateau, robot);
		try {
			response = request.process();
		} catch (Exception e) {
			response = new ErrorResponse();
			response.setError(e.getMessage());
			System.err.println("Error creating plateau: " + e.getMessage());
		}
		return response;
	}

	@POST
	@Path("/createrobot")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewRobot(Robot robot) {
		request = new CreateRobotRequest(robot);
		try {
			response = request.process();
		} catch (Exception e) {
			response = new ErrorResponse();
			response.setError(e.getMessage());
			System.err.println("Error adding robot " + e.getMessage());
		}
		return response;
	}

	@POST
	@Path("/executecommands")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String executeCommands(String commands) {
		if (commands.startsWith("\"") && commands.endsWith("\"")) {
			commands = commands.substring(1, commands.length() - 1);
		}
		request = new ExecuteRobotCommandRequest(commands);
		try {
			response = request.process();
		} catch (Exception e) {
			response = new ErrorResponse();
			response.setError(e.getMessage());
			System.err.println("Error Moving robot " + e.getMessage());
			return response.getError();
		}
		return response.toString();
	}
}
