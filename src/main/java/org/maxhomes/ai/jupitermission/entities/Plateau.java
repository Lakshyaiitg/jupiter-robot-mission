package org.maxhomes.ai.jupitermission.entities;

public interface Plateau {
	int getCoordinateX();

	int getCoordinateY();

	Robot getRobot();

	void setRobot(Robot robot);

	void setCoordinateX(int coordinateX);

	void setCoordinateY(int coordinateY);
}
