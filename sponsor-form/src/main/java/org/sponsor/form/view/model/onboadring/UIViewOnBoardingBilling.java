package org.sponsor.form.view.model.onboadring;

import org.brijframework.integration.spring.rest.model.UIModel;
import org.sponsor.form.constants.BillingType;
import org.sponsor.form.constants.PaymentMode;

public class UIViewOnBoardingBilling extends UIModel {

	private String idenNo;
	
	private BillingType type;
	
	private PaymentMode service;
	
	private Double amount;
	
	private Double discount;

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public BillingType getType() {
		return type;
	}

	public void setType(BillingType type) {
		this.type = type;
	}

	public PaymentMode getService() {
		return service;
	}

	public void setService(PaymentMode service) {
		this.service = service;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
}
