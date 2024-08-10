package org.maxhomes.ai.jupitermission.entities;

import jakarta.json.bind.annotation.JsonbProperty;

public class Robot {
	@JsonbProperty("x")
	public int x;
	@JsonbProperty("y")
	public int y;
	@JsonbProperty("direction")
	public Direction direction;

	public Robot() {

	}

	public Robot(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
		this.x += direction.getMoveX();
		this.y += direction.getMoveY();
	}

	public String toString() {
		return this.x + " " + this.y + " " + this.direction;
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
