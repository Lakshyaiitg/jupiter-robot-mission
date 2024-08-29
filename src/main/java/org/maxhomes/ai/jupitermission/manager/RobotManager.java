package org.maxhomes.ai.jupitermission.manager;

import org.maxhomes.ai.jupitermission.entities.Direction;

public interface RobotManager {
	void addRobot(int x, int y, Direction direction) throws Exception;

	void moveRobot(String commands) throws Exception;

	String getRobotPosition();
}
