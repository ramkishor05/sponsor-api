package org.sponsor.access.model;

public class UIUserSponsorActivity extends UIModel {

	private Long userSponsorId;

	private String status;

	private String remarks;

	public Long getUserSponsorId() {
		return userSponsorId;
	}

	public void setUserSponsorId(Long userSponsorId) {
		this.userSponsorId = userSponsorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
