package org.sponsor.access.model;

public class UIUserSponsor extends UIModel {

	private Long sponsorId;
	private Long sponsorLeaderId;
	private Long utrNumber;
	private String paymentReceipt;
	private String status;
	
	private UIUserSponsorActivity activity;
	
	private Long userAccountId;;
	
	private UIUserAccount userAccount;

	public Long getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Long sponsorId) {
		this.sponsorId = sponsorId;
	}

	public Long getSponsorLeaderId() {
		return sponsorLeaderId;
	}

	public void setSponsorLeaderId(Long sponsorLeaderId) {
		this.sponsorLeaderId = sponsorLeaderId;
	}

	public Long getUtrNumber() {
		return utrNumber;
	}

	public void setUtrNumber(Long utrNumber) {
		this.utrNumber = utrNumber;
	}

	public String getPaymentReceipt() {
		return paymentReceipt;
	}

	public void setPaymentReceipt(String paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public UIUserSponsorActivity getActivity() {
		return activity;
	}

	public void setActivity(UIUserSponsorActivity activity) {
		this.activity = activity;
	}

	public UIUserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UIUserAccount userAccount) {
		this.userAccount = userAccount;
	}

}
