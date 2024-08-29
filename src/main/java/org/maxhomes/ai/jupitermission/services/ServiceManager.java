package org.maxhomes.ai.jupitermission.services;

import org.maxhomes.ai.jupitermission.manager.PlateauManager;
import org.maxhomes.ai.jupitermission.manager.PlateauManagerImpl;
import org.maxhomes.ai.jupitermission.manager.RobotManager;
import org.maxhomes.ai.jupitermission.manager.RobotManagerImpl;

public class ServiceManager {
	private static ServiceManager instance = null;

	private PlateauService plateauService;
	private RobotService robotService;

	private ServiceManager() {
		PlateauManager plateauManager = new PlateauManagerImpl();
		RobotManager robotManager = new RobotManagerImpl(plateauManager);

		this.plateauService = new PlateauService(plateauManager);
		this.robotService = new RobotService(robotManager);
	}

	public static ServiceManager getInstance() {
		if (instance == null) {
			instance = new ServiceManager();
		}
		return instance;
	}

	public PlateauService getPlateauService() {
		return plateauService;
	}

	public RobotService getRobotService() {
		return robotService;
	}
}
