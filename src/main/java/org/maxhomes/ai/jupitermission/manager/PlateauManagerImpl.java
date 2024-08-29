package org.maxhomes.ai.jupitermission.manager;

import org.maxhomes.ai.jupitermission.entities.Plateau;
import org.maxhomes.ai.jupitermission.entities.PlateauImpl;

public class PlateauManagerImpl implements PlateauManager {
    private Plateau plateau;

    @Override
    public Plateau getPlateau() {
        return plateau;
    }

    @Override
    public void createPlateau(int x, int y) {
        this.plateau = new PlateauImpl(x, y);
    }
}
