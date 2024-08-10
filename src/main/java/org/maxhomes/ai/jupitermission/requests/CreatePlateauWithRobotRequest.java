package org.maxhomes.ai.jupitermission.requests;

import org.maxhomes.ai.jupitermission.entities.Plateau;
import org.maxhomes.ai.jupitermission.entities.Robot;
import org.maxhomes.ai.jupitermission.responses.CreatePlateauWithRobotResponse;
import org.maxhomes.ai.jupitermission.responses.Response;
import org.maxhomes.ai.jupitermission.services.MissionServiceManager;
import org.maxhomes.ai.jupitermission.services.ServiceManager;

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
