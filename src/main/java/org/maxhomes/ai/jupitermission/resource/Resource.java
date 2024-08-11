package org.maxhomes.ai.jupitermission.resource;

import org.maxhomes.ai.jupitermission.requests.CreatePlateauWithRobotRequest;
import org.maxhomes.ai.jupitermission.requests.CreateRobotRequest;
import org.maxhomes.ai.jupitermission.requests.ExecuteRobotCommandRequest;
import org.maxhomes.ai.jupitermission.requests.Request;
import org.maxhomes.ai.jupitermission.requests.TestRequest;
import org.maxhomes.ai.jupitermission.responses.ErrorResponse;
import org.maxhomes.ai.jupitermission.responses.Response;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/resource")
public class Resource {
	Response response;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		Request request = new TestRequest();
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
	public Response createNewPlateau(CreatePlateauWithRobotRequest request) {
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
	public Response createNewRobot(CreateRobotRequest request) {
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
	public String executeCommands(ExecuteRobotCommandRequest request) {
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
