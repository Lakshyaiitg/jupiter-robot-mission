package org.maxhomes.ai.jupitermission.manager;

import org.maxhomes.ai.jupitermission.services.PlateauService;
import org.maxhomes.ai.jupitermission.services.RobotService;

public class ServiceManager {
	private static ServiceManager instance = null;

	private PlateauService plateauService;
	private RobotService robotService;

	private ServiceManager() {
		PlateauManager plateauManager = new PlateauManagerImpl();
		RobotManager robotManager = new RobotManagerImpl(plateauManager);

		this.plateauService = ServiceFactory.createPlateauService(plateauManager);
		this.robotService = ServiceFactory.createRobotService(robotManager);
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
