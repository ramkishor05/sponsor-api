package org.sponsor.account.model;

import java.util.Date;

public class UIUserSponsorRoyaltyTransaction extends UIModel{

	private Integer month;

	private Integer year;

	private Date trsDate;

	private Double amount;
	
	private String sponsorId;

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date getTrsDate() {
		return trsDate;
	}

	public void setTrsDate(Date trsDate) {
		this.trsDate = trsDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}
}
