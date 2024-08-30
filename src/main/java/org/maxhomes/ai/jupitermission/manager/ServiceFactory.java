package org.maxhomes.ai.jupitermission.manager;

import org.maxhomes.ai.jupitermission.services.PlateauService;
import org.maxhomes.ai.jupitermission.services.PlateauServiceImpl;
import org.maxhomes.ai.jupitermission.services.RobotService;
import org.maxhomes.ai.jupitermission.services.RobotServiceImpl;

public class ServiceFactory {
	public static PlateauService createPlateauService(PlateauManager plateauManager) {
		return new PlateauServiceImpl(plateauManager);
	}

	public static RobotService createRobotService(RobotManager robotManager) {
		return new RobotServiceImpl(robotManager);
	}
}
