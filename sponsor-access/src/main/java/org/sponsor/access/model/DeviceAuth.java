package org.sponsor.access.model;

import org.sponsor.access.constants.ServiceType;

public class DeviceAuth {

	private ServiceType serviceType;

	public ServiceType getServiceType() {
		if(serviceType==null) {
			serviceType=ServiceType.NORMAL;
		}
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

}
