package request;

import entities.Robot;
import exceptions.InvalidInputException;
import response.CreateRobotResponse;
import response.Response;
import services.MissionServiceManager;
import services.ServiceManager;

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
		if (robot == null || robot.getX() < 0 || robot.getY() < 0) {
			throw new InvalidInputException("Input is invalid");
		}
		MissionServiceManager manager = ServiceManager.getServiceManager().getMissionServiceManager();
		manager.addRobot(robot.getX(), robot.getY(), robot.getDirection());
		response.setRobot(manager.getPlateau().getRobot());
		return response;
	}

}
