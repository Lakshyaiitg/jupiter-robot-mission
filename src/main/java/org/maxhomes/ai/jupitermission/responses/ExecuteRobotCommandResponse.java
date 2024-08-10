package org.maxhomes.ai.jupitermission.responses;

import org.maxhomes.ai.jupitermission.entities.Robot;

public class ExecuteRobotCommandResponse implements Response {

	public Robot robot;
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ExecuteRobotCommandResponse() {
	}

	public ExecuteRobotCommandResponse(Robot robot) {
		this.robot = robot;
	}

	public Robot getRobot() {
		return this.robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	@Override
	public String toString() {
		return robot.toString();
	}

}
