package org.sponsor.account.forgin.model;

import org.sponsor.account.constants.ServiceType;
import org.sponsor.account.constants.UserType;

public class GlobalSignInAuth {

	private ServiceType serviceType;
	private UserType userType;


	public ServiceType getServiceType() {
		if(serviceType==null) {
			serviceType=ServiceType.NORMAL;
		}
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public UserType getUserType() {
		if(userType==null) {
			userType=UserType.APP;
		}
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
