package org.sponsor.account.model;

public class UIBusinessFinancialWalletTransaction extends UIModel{
	
	private String trsDate;
	
	private Double amount;

	private String type;
	
	private String utrNumber;
	
	private String remarks;
	
	private String receipt;
	
	public String getTrsDate() {
		return trsDate;
	}

	public void setTrsDate(String trsDate) {
		this.trsDate = trsDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUtrNumber() {
		return utrNumber;
	}

	public void setUtrNumber(String utrNumber) {
		this.utrNumber = utrNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
}
