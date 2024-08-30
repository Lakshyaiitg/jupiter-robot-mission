package org.maxhomes.ai.jupitermission.entities;

public class PlateauImpl implements Plateau {

	private int upperX;
	private int upperY;
	private Robot robot;

	public PlateauImpl(int coordinateX, int coordinateY) {
		this.upperX = coordinateX;
		this.upperY = coordinateY;
	}

	public PlateauImpl() {
	}

	@Override
	public int getUpperX() {
		return upperX;
	}

	@Override
	public int getUpperY() {
		return upperY;
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
	public void setUpperX(int coordinateX) {
		this.upperX = coordinateX;
	}

	@Override
	public void setUpperY(int coordinateY) {
		this.upperY = coordinateY;
	}
}
