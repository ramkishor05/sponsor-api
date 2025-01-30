package org.sponsor.access.model;

import org.sponsor.access.constants.ResetBy;

public class GlobalPasswordReset extends GlobalLoginRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer otp;
	
	private ResetBy resetBy; 

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public ResetBy getResetBy() {
		return resetBy;
	}

	public void setResetBy(ResetBy resetBy) {
		this.resetBy = resetBy;
	}
}
