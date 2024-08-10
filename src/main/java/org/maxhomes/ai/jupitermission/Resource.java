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
import response.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/resource")
public class Resource {
	Request request;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		request = new TestRequest();
		return request.process().toString();
	}

	@POST
	@Path("/createplateau")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewPlateau(CreatePlateauWithRobotRequest requestPayload) {
		Plateau plateau = requestPayload.getPlateau();
		Robot robot = requestPayload.getRobot();
		Request request = new CreatePlateauWithRobotRequest(plateau, robot);
		return request.process();
	}

	@POST
	@Path("/createrobot")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewRobot(Robot robot) {
		request = new CreateRobotRequest(robot);
		Response response = request.process();
		return response;
	}

	@POST
	@Path("/executecommands")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String executeCommands(String commands) {
		request = new ExecuteRobotCommandRequest(commands);
		Response response = request.process();
		return response.toString();
	}
}
