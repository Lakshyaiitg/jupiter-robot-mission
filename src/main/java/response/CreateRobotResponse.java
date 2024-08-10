package response;

import entities.Robot;

public class CreateRobotResponse implements Response {

	public Robot robot;
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public CreateRobotResponse() {
	}

	public CreateRobotResponse(Robot robot) {
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
		return robot.toString() + " Created!";
	}

}
