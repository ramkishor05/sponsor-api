package org.sponsor.access.model;

public class DeviceAuthDataDTO {

	private UIUserDetail user;
	private String token;

	public UIUserDetail getUser() {
		return user;
	}

	public void setUser(UIUserDetail user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
