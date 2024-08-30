package org.maxhomes.ai.jupitermission.entities;

public interface Plateau {
	int getUpperX();

	int getUpperY();

	Robot getRobot();

	void setRobot(Robot robot);

	void setUpperX(int coordinateX);

	void setUpperY(int coordinateY);
}
