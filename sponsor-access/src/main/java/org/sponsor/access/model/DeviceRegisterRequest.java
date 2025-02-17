package org.sponsor.access.model;

public class DeviceRegisterRequest extends DeviceLoginRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String registeredPhone;
	private String registeredEmail;
	private String accountName;

	public String getRegisteredPhone() {
		return registeredPhone;
	}

	public void setRegisteredPhone(String registeredPhone) {
		this.registeredPhone = registeredPhone;
	}

	public String getRegisteredEmail() {
		return registeredEmail;
	}

	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
