package org.maxhomes.ai.jupitermission.requests;

import org.maxhomes.ai.jupitermission.exceptions.InvalidCommandException;
import org.maxhomes.ai.jupitermission.responses.ExecuteRobotCommandResponse;
import org.maxhomes.ai.jupitermission.responses.Response;
import org.maxhomes.ai.jupitermission.services.MissionServiceManager;
import org.maxhomes.ai.jupitermission.services.ServiceManager;

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
		if (commands.startsWith("\"") && commands.endsWith("\"")) {
			commands = commands.substring(1, commands.length() - 1);
		}
		manager.moveRobot(commands);
		response.setRobot(manager.getPlateau().getRobot());

		return response;
	}

	public String getCommands() {
		return commands;
	}

	public void setCommands(String commands) {
		this.commands = commands;
	}

}
