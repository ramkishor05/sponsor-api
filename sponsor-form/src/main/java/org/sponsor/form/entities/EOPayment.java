package org.sponsor.form.entities;

import java.io.Serializable;

import org.sponsor.form.constants.BillingType;
import org.sponsor.form.constants.PaymentMode;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EOPayment extends EOEntityObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BillingType type;
	private PaymentMode service;
	private Double amount;
	private Double discount;

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
