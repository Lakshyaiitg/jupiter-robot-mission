package org.maxhomes.ai.jupitermission.services;

import org.maxhomes.ai.jupitermission.entities.Direction;
import org.maxhomes.ai.jupitermission.entities.Plateau;

public interface MissionServiceManager {
	public String test();

	public void createNewPlateau(int x, int y);

	public void setNewPlateau(Plateau plateau);

	public void addRobot(int x, int y, Direction direction) throws Exception;

	public void moveRobot(String commands) throws Exception;

	public String getRobotPostion();

	public Plateau getPlateau();
}
