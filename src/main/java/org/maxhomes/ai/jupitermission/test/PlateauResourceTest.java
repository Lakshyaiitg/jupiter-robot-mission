package org.maxhomes.ai.jupitermission.test;

import org.maxhomes.ai.jupitermission.entities.PlateauImpl;
import org.maxhomes.ai.jupitermission.resource.PlateauResource;

import jakarta.ws.rs.core.Response;

public class PlateauResourceTest {

	public static void main(String[] args) {
		PlateauResourceTest test = new PlateauResourceTest();
		test.testCreatePlateau();
	}

	public void testCreatePlateau() {

		PlateauResource plateauResource = new PlateauResource();

		PlateauImpl plateau = new PlateauImpl(5, 5);

		Response response = plateauResource.createPlateau(plateau);
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			System.out.println("Test Passed: Plateau created successfully.");
		} else {
			System.out.println("Test Failed: Plateau creation failed.");
		}
	}
}
