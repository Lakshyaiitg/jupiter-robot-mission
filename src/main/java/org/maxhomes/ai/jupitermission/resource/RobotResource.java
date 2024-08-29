package org.maxhomes.ai.jupitermission.resource;

import org.maxhomes.ai.jupitermission.entities.RobotImpl;
import org.maxhomes.ai.jupitermission.services.RobotService;
import org.maxhomes.ai.jupitermission.services.ServiceManager;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/robots")
public class RobotResource {
	private final RobotService robotService;

	public RobotResource() {
		this.robotService = ServiceManager.getInstance().getRobotService();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public jakarta.ws.rs.core.Response createOrUpdateRobot(RobotImpl robot) {
		try {
			robotService.addRobot(robot.getCoordinateX(), robot.getCoordinateY(), robot.getDirection());
			return jakarta.ws.rs.core.Response.status(Status.OK)
					.entity(new Response(true, "Robot added successfully", robot)).build();
		} catch (Exception e) {
			return jakarta.ws.rs.core.Response.status(Status.BAD_REQUEST)
					.entity(new Response(false, e.getMessage(), null)).build();
		}
	}

	@PUT
	@Path("/move")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public jakarta.ws.rs.core.Response processRobotMovement(String commands) {
		try {
			robotService.moveRobot(commands);
			String robotPosition = robotService.getRobotPosition();
			return jakarta.ws.rs.core.Response.status(Status.OK)
					.entity(new Response(true, "Robot moved successfully", robotPosition)).build();
		} catch (Exception e) {
			return jakarta.ws.rs.core.Response.status(Status.BAD_REQUEST)
					.entity(new Response(false, e.getMessage(), null)).build();
		}
	}
}
