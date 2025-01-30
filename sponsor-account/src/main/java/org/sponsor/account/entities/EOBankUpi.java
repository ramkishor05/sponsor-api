package org.sponsor.account.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EOBankUpi extends EOEntityObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "UPI_HOLDER")
	private String upiHolder;

	@Column(name = "UPI_ID")
	private String upiId;

	@Column(name = "QR_CODE")
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
