package org.sponsor.account.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = EOUserSponsorLinkTransaction.USER_SPONSOR_LINK_TRANSACTION)
public class EOUserSponsorLinkTransaction extends EOEntityObject {

	static final String USER_SPONSOR_LINK_TRANSACTION = "USER_SPONSOR_LINK_TRANSACTION";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "LINK_SPONSOR_ID", nullable = true)
	private EOUserSponsor linkSponsor;
	
	@JoinColumn(name = "STEP")
	private String step;

	@ManyToOne
	@JoinColumn(name = "USER_SPONSOR_ID")
	private EOUserSponsor userSponsor;

	@OneToOne
	@JoinColumn(name = "USER_SPONSOR_INCOME", nullable = false)
	private EOUserFinancialWalletTransaction userSponsorIncome;

	@OneToOne
	@JoinColumn(name = "BUSINESS_SPONSOR_INCOME", nullable = false)
	private EOBusinessFinancialWalletTransaction businessSponsorIncome;
	
	public EOUserSponsor getLinkSponsor() {
		return linkSponsor;
	}

	public void setLinkSponsor(EOUserSponsor linkSponsor) {
		this.linkSponsor = linkSponsor;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public EOUserSponsor getUserSponsor() {
		return userSponsor;
	}

	public void setUserSponsor(EOUserSponsor userSponsor) {
		this.userSponsor = userSponsor;
	}

	public EOUserFinancialWalletTransaction getUserSponsorIncome() {
		return userSponsorIncome;
	}

	public void setUserSponsorIncome(EOUserFinancialWalletTransaction userSponsorIncome) {
		this.userSponsorIncome = userSponsorIncome;
	}

	public EOBusinessFinancialWalletTransaction getBusinessSponsorIncome() {
		return businessSponsorIncome;
	}

	public void setBusinessSponsorIncome(EOBusinessFinancialWalletTransaction businessSponsorIncome) {
		this.businessSponsorIncome = businessSponsorIncome;
	}

	public Double getAmount() {
		Double amount=getUserSponsorIncome().getAmount();
		return amount;
	}
	
}
