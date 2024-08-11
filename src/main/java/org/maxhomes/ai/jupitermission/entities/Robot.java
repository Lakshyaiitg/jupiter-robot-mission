package org.maxhomes.ai.jupitermission.entities;

public class Robot {
	public int coordinateX;
	public int coordinateY;
	public Direction direction;

	public Robot() {

	}

	public Robot(int coordinateX, int coordinateY, Direction direction) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.direction = direction;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void turnRight() {
		switch (this.direction) {
		case N:
			this.direction = Direction.E;
			break;
		case S:
			this.direction = Direction.W;
			break;
		case E:
			this.direction = Direction.S;
			break;
		case W:
			this.direction = Direction.N;
			break;
		}
	}

	public void turnLeft() {
		switch (this.direction) {
		case N:
			this.direction = Direction.W;
			break;
		case S:
			this.direction = Direction.E;
			break;
		case E:
			this.direction = Direction.N;
			break;
		case W:
			this.direction = Direction.S;
			break;
		}
	}

	public void move() {
		this.coordinateX += direction.getMoveX();
		this.coordinateY += direction.getMoveY();
	}

	public String toString() {
		return this.coordinateX + " " + this.coordinateY + " " + this.direction;
	}

	public void setDirectionFromString(String direction) {
		switch (direction) {
		case "W":
			this.direction = Direction.W;
			break;
		case "E":
			this.direction = Direction.E;
			break;
		case "N":
			this.direction = Direction.N;
			break;
		case "S":
			this.direction = Direction.S;
			break;
		}
	}
}
