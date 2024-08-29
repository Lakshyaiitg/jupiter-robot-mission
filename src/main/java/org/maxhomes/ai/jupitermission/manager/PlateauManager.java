package org.maxhomes.ai.jupitermission.manager;

import org.maxhomes.ai.jupitermission.entities.Plateau;

public interface PlateauManager {
	Plateau getPlateau();

	void createPlateau(int x, int y);
}
