package org.sponsor.access.model;

import org.sponsor.access.constants.Authority;
import org.sponsor.access.constants.ServiceType;

public class GlobalSignUpAuth {

	private ServiceType serviceType;
	private Authority authority;

	public ServiceType getServiceType() {
		if(serviceType==null) {
			serviceType=ServiceType.NORMAL;
		}
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Authority getAuthority() {
		if(authority==null) {
			authority=Authority.USER;
		}
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
