package org.maxhomes.ai.jupitermission.services;

import org.maxhomes.ai.jupitermission.entities.Direction;
import org.maxhomes.ai.jupitermission.entities.Plateau;
import org.maxhomes.ai.jupitermission.entities.Robot;
import org.maxhomes.ai.jupitermission.exceptions.InvalidInputException;
import org.maxhomes.ai.jupitermission.exceptions.OutOfSignalException;

public class MissionServiceDefaultManager implements MissionServiceManager {
	protected MissionServiceDefaultManager() {
	}

	private Plateau plateau;

	public String test() {
		return "test successfull!";
	}

	public void createNewPlateau(int x, int y) {
		this.plateau = new Plateau(x, y);
	}

	public void setNewPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public void addRobot(int x, int y, Direction direction) throws Exception {
		if (x > this.plateau.getCoordinateX() || y > this.plateau.getCoordinateY()) {
			throw new InvalidInputException("Robot cannot be placed outside plateau");
		}
		Robot robot = new Robot(x, y, direction);
		this.plateau.setRobot(robot);
	}

	public void moveRobot(String commands) throws Exception {
		for (char c : commands.toCharArray()) {
			switch (c) {
			case 'L':
				plateau.getRobot().turnLeft();
				break;
			case 'R':
				plateau.getRobot().turnRight();
				break;
			case 'M':
				plateau.getRobot().move();
				break;
			default:
				System.out.println("Invalid Command");
			}

			if (plateau.getRobot().getX() > plateau.getCoordinateX()
					|| plateau.getRobot().getY() > plateau.getCoordinateY()) {
				throw new OutOfSignalException("Robot is out of signal");
			}
		}
	}

	public String getRobotPostion() {
		return plateau.getRobot().toString();
	}

	public Plateau getPlateau() {
		return plateau;
	}
}
