package org.maxhomes.ai.jupitermission.requests;

import org.maxhomes.ai.jupitermission.entities.Robot;
import org.maxhomes.ai.jupitermission.exceptions.InvalidInputException;
import org.maxhomes.ai.jupitermission.responses.CreateRobotResponse;
import org.maxhomes.ai.jupitermission.responses.Response;
import org.maxhomes.ai.jupitermission.services.MissionServiceManager;
import org.maxhomes.ai.jupitermission.services.ServiceManager;

public class CreateRobotRequest implements Request {
	CreateRobotResponse response = new CreateRobotResponse();

	Robot robot;

	public CreateRobotRequest() {
	}

	public CreateRobotRequest(Robot robot) {
		this.robot = robot;
	}

	@Override
	public Response process() throws Exception {
		if (robot == null || robot.getCoordinateX() < 0 || robot.getCoordinateY() < 0) {
			throw new InvalidInputException("Input is invalid");
		}
		MissionServiceManager manager = ServiceManager.getServiceManager().getMissionServiceManager();
		manager.addRobot(robot.getCoordinateX(), robot.getCoordinateY(), robot.getDirection());
		response.setRobot(manager.getPlateau().getRobot());
		return response;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

}
