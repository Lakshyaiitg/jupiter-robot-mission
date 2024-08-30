package org.maxhomes.ai.jupitermission.services;

import org.maxhomes.ai.jupitermission.entities.Plateau;

public interface PlateauService {
	void createPlateau(int x, int y) throws Exception;

	Plateau getPlateau();
}
