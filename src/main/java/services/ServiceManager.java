package services;

public class ServiceManager {
	private static ServiceManager serviceManager = null;

	MissionServiceManager missionServiceManager = new MissionServiceDefaultManager();

	public MissionServiceManager getMissionServiceManager() {
		return missionServiceManager;
	}

	public void setMissionServiceManager(MissionServiceManager missionServiceManager) {
		this.missionServiceManager = missionServiceManager;
	}

	private ServiceManager() {
	}

	public static ServiceManager getServiceManager() {
		if (serviceManager == null)
			serviceManager = new ServiceManager();
		return serviceManager;
	}
}
