package response;

import entities.Plateau;

public class CreatePlateauWithRobotResponse implements Response {
	private Plateau plateau;
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public CreatePlateauWithRobotResponse() {

	};

	public CreatePlateauWithRobotResponse(Plateau plateau) {
		this.plateau = plateau;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

}
