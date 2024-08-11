package org.maxhomes.ai.jupitermission.requests;

import org.maxhomes.ai.jupitermission.entities.Plateau;
import org.maxhomes.ai.jupitermission.exceptions.InvalidInputException;
import org.maxhomes.ai.jupitermission.responses.CreatePlateauWithRobotResponse;
import org.maxhomes.ai.jupitermission.responses.Response;
import org.maxhomes.ai.jupitermission.services.MissionServiceManager;
import org.maxhomes.ai.jupitermission.services.ServiceManager;

public class CreatePlateauWithRobotRequest implements Request {
	CreatePlateauWithRobotResponse response = new CreatePlateauWithRobotResponse();

	private Plateau plateau;

	public CreatePlateauWithRobotRequest() {
	}

	public CreatePlateauWithRobotRequest(Plateau plateau) {
		this.plateau = plateau;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	@Override
	public Response process() throws Exception {
		MissionServiceManager manager = ServiceManager.getServiceManager().getMissionServiceManager();
		if (this.plateau == null || this.plateau.getRobot() == null
				|| this.plateau.getRobot().getCoordinateX() > this.plateau.getCoordinateX()
				|| this.plateau.getRobot().getCoordinateY() > this.plateau.getCoordinateY()) {
			throw new InvalidInputException("Error Creating Plateau!!!!!");
		}
		manager.setNewPlateau(plateau);
		response.setPlateau(plateau);
		System.out.println("Plateau Created!");
		return response;
	}
}
