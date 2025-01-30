package org.sponsor.account.model;

public class UIBusinessFinancialCoupon extends UIModel {

	private String name;

	private String description;

	private Double value;

	private String startDate;

	private String endDate;

	private String type;

	private String status;
	
	private long remainingDays;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(long remainingDays) {
		this.remainingDays = remainingDays;
	}

}
