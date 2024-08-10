package services;

import entities.Direction;
import entities.Plateau;

public interface MissionServiceManager {
	public String test();

	public void createNewPlateau(int x, int y);

	public void setNewPlateau(Plateau plateau);

	public void addRobot(int x, int y, Direction direction);

	public void moveRobot(String commands);

	public String getRobotPostion();

	public Plateau getPlateau();
}
