package response;

import entities.Robot;

public class ExecuteRobotCommandResponse implements Response {

	public Robot robot;

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
