package request;

import entities.Robot;
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
	public Response process() {
		MissionServiceManager manager = ServiceManager.getServiceManager().getMissionServiceManager();
		manager.addRobot(robot.getX(), robot.getY(), robot.getDirection());
		response.setRobot(manager.getPlateau().getRobot());
		return response;
	}

}
