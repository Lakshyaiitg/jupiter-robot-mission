package org.maxhomes.ai.jupitermission.services;

import org.maxhomes.ai.jupitermission.entities.Direction;
import org.maxhomes.ai.jupitermission.exceptions.InvalidInputException;
import org.maxhomes.ai.jupitermission.manager.RobotManager;

import jakarta.inject.Singleton;

@Singleton
public class RobotServiceImpl implements RobotService {
	private RobotManager robotManager;

	public RobotServiceImpl(RobotManager robotManager) {
		this.robotManager = robotManager;
	}

	@Override
	public void addRobot(int x, int y, Direction direction) throws Exception {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("Coordinates must be non-negative");
		}
		robotManager.addRobot(x, y, direction);
	}

	@Override
	public void moveRobot(String commands) throws Exception {
		if (commands == null || commands.isEmpty()) {
			throw new InvalidInputException("Commands cannot be null or empty");
		}
		if (commands.startsWith("\"") && commands.endsWith("\"")) {
			commands = commands.substring(1, commands.length() - 1);
		}
		robotManager.moveRobot(commands);
	}

	@Override
	public String getRobotPosition() {
		return robotManager.getRobotPosition();
	}
}
