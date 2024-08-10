package services;

import entities.Direction;
import entities.Plateau;
import entities.Robot;

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

	public void addRobot(int x, int y, Direction direction) {
		Robot robot = new Robot(x, y, direction);
		this.plateau.setRobot(robot);
	}

	public void moveRobot(String commands) {
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
				System.out.println("Robot out of signal");
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
