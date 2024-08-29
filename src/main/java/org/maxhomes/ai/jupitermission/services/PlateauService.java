package org.maxhomes.ai.jupitermission.services;

import org.maxhomes.ai.jupitermission.entities.Plateau;
import org.maxhomes.ai.jupitermission.manager.PlateauManager;

public class PlateauService {
	private PlateauManager plateauManager;

	public PlateauService(PlateauManager plateauManager) {
		this.plateauManager = plateauManager;
	}

	public void createPlateau(int x, int y) {
		plateauManager.createPlateau(x, y);
	}

	public Plateau getPlateau() {
		return plateauManager.getPlateau();
	}
}
