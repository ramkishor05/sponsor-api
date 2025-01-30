package org.sponsor.account.model;

public class UIBankUpi extends UIModel {

	private String upiHolder;

	private String upiId;

	private String qrCode;
	
	public String getUpiHolder() {
		return upiHolder;
	}

	public void setUpiHolder(String upiHolder) {
		this.upiHolder = upiHolder;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

}
