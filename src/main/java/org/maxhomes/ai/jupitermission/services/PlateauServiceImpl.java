package org.maxhomes.ai.jupitermission.services;

import org.maxhomes.ai.jupitermission.entities.Plateau;
import org.maxhomes.ai.jupitermission.manager.PlateauManager;

public class PlateauServiceImpl implements PlateauService {
	private PlateauManager plateauManager;

	public PlateauServiceImpl(PlateauManager plateauManager) {
		this.plateauManager = plateauManager;
	}

	@Override
	public void createPlateau(int x, int y) throws Exception {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("Coordinates must be non-negative");
		}
		plateauManager.createPlateau(x, y);
	}

	@Override
	public Plateau getPlateau() {
		return plateauManager.getPlateau();
	}
}
