package org.maxhomes.ai.jupitermission.test;

import org.maxhomes.ai.jupitermission.entities.Direction;
import org.maxhomes.ai.jupitermission.entities.PlateauImpl;
import org.maxhomes.ai.jupitermission.entities.RobotImpl;
import org.maxhomes.ai.jupitermission.resource.PlateauResource;
import org.maxhomes.ai.jupitermission.resource.RobotResource;

import jakarta.ws.rs.core.Response;

public class RobotResourceTest {

	public static void main(String[] args) {
		RobotResourceTest test = new RobotResourceTest();
		test.testCreateOrUpdateRobot();
		test.testProcessRobotMovement();
	}

	public void testCreateOrUpdateRobot() {
		PlateauResource plateauResource = new PlateauResource();
		PlateauImpl plateau = new PlateauImpl(5, 5);
		Response plateauResponse = plateauResource.createPlateau(plateau);

		if (plateauResponse.getStatus() == Response.Status.OK.getStatusCode()) {
			System.out.println("Plateau created successfully.");

			RobotResource robotResource = new RobotResource();
			RobotImpl robot = new RobotImpl(1, 2, Direction.N);

			Response response = robotResource.createOrUpdateRobot(robot);
			if (response.getStatus() == Response.Status.OK.getStatusCode()) {
				System.out.println("Test Passed: Robot added or updated successfully.");
			} else {
				System.out.println("Test Failed: Robot add or update failed.");
			}
		} else {
			System.out.println("Test Failed: Plateau creation failed.");
		}
	}

	public void testProcessRobotMovement() {
		PlateauResource plateauResource = new PlateauResource();
		PlateauImpl plateau = new PlateauImpl(5, 5);
		Response plateauResponse = plateauResource.createPlateau(plateau);

		if (plateauResponse.getStatus() == Response.Status.OK.getStatusCode()) {
			System.out.println("Plateau created successfully.");

			RobotResource robotResource = new RobotResource();
			RobotImpl robot = new RobotImpl(1, 2, Direction.N);
			robotResource.createOrUpdateRobot(robot);

			String commands = "LMLMLMLMM";
			Response response = robotResource.processRobotMovement(commands);
			if (response.getStatus() == Response.Status.OK.getStatusCode()) {
				System.out.println("Test Passed: Robot moved successfully.");
			} else {
				System.out.println("Test Failed: Robot movement failed.");
			}
		} else {
			System.out.println("Test Failed: Plateau creation failed.");
		}
	}
}
