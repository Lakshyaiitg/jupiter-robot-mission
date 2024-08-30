package org.maxhomes.ai.jupitermission.entities;

public interface Robot {
	int getCoordinateX();

	int getCoordinateY();

	Direction getDirection();

	void setDirection(Direction direction);

	void setCoordinateX(int coordinateX);

	void setCoordinateY(int coordinateY);

	void turnRight();

	void turnLeft();

	void moveForward();

	String toString();
}
