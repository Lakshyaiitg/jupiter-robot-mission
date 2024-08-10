package entities;

public class Plateau implements ExplorationSite {
	private int coordinateX;
	private int coordinateY;

	private Robot robot;

	public Plateau() {
	}

	public Plateau(int coordinateX, int coordinateY) {
		super();
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
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

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}
}
