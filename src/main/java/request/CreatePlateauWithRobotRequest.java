package request;

import entities.Plateau;
import entities.Robot;
import response.CreatePlateauWithRobotResponse;
import response.Response;
import services.MissionServiceManager;
import services.ServiceManager;

public class CreatePlateauWithRobotRequest implements Request {
	CreatePlateauWithRobotResponse response = new CreatePlateauWithRobotResponse();

	private Plateau plateau;
	private Robot robot;

	public CreatePlateauWithRobotRequest() {
	}

	public CreatePlateauWithRobotRequest(Plateau plateau, Robot robot) {
		this.plateau = plateau;
		this.robot = robot;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	@Override
	public Response process() throws Exception {
		MissionServiceManager manager = ServiceManager.getServiceManager().getMissionServiceManager();
		manager.createNewPlateau(plateau.getCoordinateX(), plateau.getCoordinateY());
		manager.addRobot(robot.getX(), robot.getY(), robot.getDirection());
		response.setPlateau(manager.getPlateau());
		return response;
	}
}
