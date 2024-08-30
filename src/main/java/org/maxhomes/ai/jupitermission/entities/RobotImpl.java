package org.maxhomes.ai.jupitermission.entities;

public class RobotImpl implements Robot {
	private int coordinateX;
	private int coordinateY;

	private Direction direction;

	public RobotImpl(int coordinateX, int coordinateY, Direction direction) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.direction = direction;
	}

	public RobotImpl() {
	}

	@Override
	public int getCoordinateX() {
		return coordinateX;
	}

	@Override
	public int getCoordinateY() {
		return coordinateY;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	@Override
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}

	@Override
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

	@Override
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

	@Override
	public void moveForward() {
		this.coordinateX += this.direction.getMoveX();
		this.coordinateY += this.direction.getMoveY();
	}

	@Override
	public String toString() {
		return this.coordinateX + " " + this.coordinateY + " " + this.direction;
	}
}
