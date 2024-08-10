package org.maxhomes.ai.jupitermission.entities;

public enum Direction {
	N(0, 1), S(0, -1), E(1, 0), W(-1, 0);

	private int moveX;
	private int moveY;

	public int getMoveX() {
		return moveX;
	}

	public int getMoveY() {
		return moveY;
	}

	Direction(int moveX, int moveY) {
		this.moveX = moveX;
		this.moveY = moveY;
	}
}
