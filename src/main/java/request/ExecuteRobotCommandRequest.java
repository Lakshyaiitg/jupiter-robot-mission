package request;

import response.ExecuteRobotCommandResponse;
import response.Response;
import services.MissionServiceManager;
import services.ServiceManager;

public class ExecuteRobotCommandRequest implements Request {
	ExecuteRobotCommandResponse response = new ExecuteRobotCommandResponse();
	String commands;

	public ExecuteRobotCommandRequest() {
	}

	public ExecuteRobotCommandRequest(String commands) {
		this.commands = commands;
	}

	@Override
	public Response process() {
		MissionServiceManager manager = ServiceManager.getServiceManager().getMissionServiceManager();
		manager.moveRobot(commands);
		response.setRobot(manager.getPlateau().getRobot());
		return response;
	}

}
