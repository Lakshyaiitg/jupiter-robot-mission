package org.maxhomes.ai.jupitermission.entities;

public class PlateauImpl implements Plateau {

	private int coordinateX;
	private int coordinateY;
	private Robot robot;

	public PlateauImpl(int coordinateX, int coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public PlateauImpl() {
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
	public Robot getRobot() {
		return robot;
	}

	@Override
	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	@Override
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
}
