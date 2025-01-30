package org.sponsor.account.forgin.model;

import org.sponsor.account.constants.Authority;
import org.sponsor.account.constants.ServiceType;

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
