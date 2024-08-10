package request;

import exceptions.InvalidCommandException;
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
	public Response process() throws Exception {
		MissionServiceManager manager = ServiceManager.getServiceManager().getMissionServiceManager();
		if (commands == null || commands.isEmpty()) {
			throw new InvalidCommandException("Commands cannot be null or empty.");
		}
		manager.moveRobot(commands);
		response.setRobot(manager.getPlateau().getRobot());

		return response;
	}

}
