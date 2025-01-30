package org.sponsor.form.role.model.onboarding;

import org.brijframework.integration.spring.rest.model.UIModel;

public class UIUserOnBoardingAnswer extends UIModel {
	
	private String value;
	private String desciption;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
}
