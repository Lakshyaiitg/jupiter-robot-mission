package org.maxhomes.ai.jupitermission.manager;

import org.maxhomes.ai.jupitermission.command.Command;
import org.maxhomes.ai.jupitermission.command.CommandFactory;
import org.maxhomes.ai.jupitermission.entities.Direction;
import org.maxhomes.ai.jupitermission.entities.Plateau;
import org.maxhomes.ai.jupitermission.entities.Robot;
import org.maxhomes.ai.jupitermission.entities.RobotImpl;
import org.maxhomes.ai.jupitermission.exceptions.InvalidInputException;
import org.maxhomes.ai.jupitermission.exceptions.OutOfSignalException;

public class RobotManagerImpl implements RobotManager {
	private PlateauManager plateauManager;

	public RobotManagerImpl(PlateauManager plateauManager) {
		this.plateauManager = plateauManager;
	}

	@Override
	public void addRobot(int x, int y, Direction direction) throws Exception {
		Plateau plateau = plateauManager.getPlateau();
		if (plateau == null) {
			throw new IllegalStateException("Plateau is not initialized.");
		}
		if (x > plateau.getUpperX() || y > plateau.getUpperY()) {
			throw new InvalidInputException("Robot cannot be placed outside plateau");
		}
		Robot robot = new RobotImpl(x, y, direction);
		plateau.setRobot(robot);
	}

	@Override
	public void moveRobot(String commands) throws Exception {
		Plateau plateau = plateauManager.getPlateau();
		Robot robot = plateau.getRobot();

		int lastValidX = robot.getCoordinateX();
		int lastValidY = robot.getCoordinateY();

		for (char c : commands.toCharArray()) {
			Command command = CommandFactory.createCommand(c);
			command.execute(robot);

			if (robot.getCoordinateX() < 0 || robot.getCoordinateX() > plateau.getUpperX() || robot.getCoordinateY() < 0
					|| robot.getCoordinateY() > plateau.getUpperY()) {
				robot.setCoordinateX(lastValidX);
				robot.setCoordinateY(lastValidY);
				throw new OutOfSignalException(
						"Robot is out of signal. Last valid position was: (" + lastValidX + ", " + lastValidY + ")");
			}

			lastValidX = robot.getCoordinateX();
			lastValidY = robot.getCoordinateY();
		}
	}

	@Override
	public String getRobotPosition() {
		return plateauManager.getPlateau().getRobot().toString();
	}
}
