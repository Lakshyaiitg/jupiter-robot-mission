package org.maxhomes.ai.jupitermission.services;

import org.maxhomes.ai.jupitermission.entities.Direction;

public interface RobotService {
	void addRobot(int x, int y, Direction direction) throws Exception;

	void moveRobot(String commands) throws Exception;

	String getRobotPosition();
}
