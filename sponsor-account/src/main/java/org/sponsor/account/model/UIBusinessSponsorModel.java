package org.sponsor.account.model;

public class UIBusinessSponsorModel extends UIModel{

	private Long sponsorId;
	
	private String fullName;
	
	private Long userAccountId;

	private Long sponsorLeaderId;

	public Long getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Long sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public Long getSponsorLeaderId() {
		return sponsorLeaderId;
	}

	public void setSponsorLeaderId(Long sponsorLeaderId) {
		this.sponsorLeaderId = sponsorLeaderId;
	}
	
	
}
