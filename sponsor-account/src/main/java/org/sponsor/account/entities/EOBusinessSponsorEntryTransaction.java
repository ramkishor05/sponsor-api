package org.sponsor.account.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BUSINESS_SPONSOR_ENTRY_TRANSACTION")
public class EOBusinessSponsorEntryTransaction extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "LINK_SPONSOR_ID")
	private EOUserSponsor linkSponsor;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_AMOUNT_ID")
	private EOBusinessFinancialAccountTransaction businessAccountAmount;
	
	@ManyToOne
	@JoinColumn(name = "SPONSOR_AMOUNT_ID")
	private EOBusinessFinancialWalletTransaction businessSponsorAmount;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_AMOUNT_ID")
	private EOBusinessFinancialWalletTransaction bussinessProductAmount;

	@ManyToOne
	@JoinColumn(name = "TRANSACTION_FEES_ID")
	private EOBusinessFinancialWalletTransaction bussinessTransactionFees;

	@ManyToOne
	@JoinColumn(name = "BUSSINESS_SPONSOR_ID")
	private EOBusinessSponsor bussinessSponsor;

	public EOUserSponsor getLinkSponsor() {
		return linkSponsor;
	}

	public void setLinkSponsor(EOUserSponsor linkSponsor) {
		this.linkSponsor = linkSponsor;
	}

	public EOBusinessSponsor getBussinessSponsor() {
		return bussinessSponsor;
	}

	public EOBusinessFinancialAccountTransaction getBusinessAccountAmount() {
		return businessAccountAmount;
	}

	public void setBusinessAccountAmount(EOBusinessFinancialAccountTransaction businessAccountAmount) {
		this.businessAccountAmount = businessAccountAmount;
	}

	public void setBussinessSponsor(EOBusinessSponsor bussinessSponsor) {
		this.bussinessSponsor = bussinessSponsor;
	}

	public EOBusinessFinancialWalletTransaction getBusinessSponsorAmount() {
		return businessSponsorAmount;
	}

	public void setBusinessSponsorAmount(EOBusinessFinancialWalletTransaction businessSponsorAmount) {
		this.businessSponsorAmount = businessSponsorAmount;
	}

	public EOBusinessFinancialWalletTransaction getBussinessProductAmount() {
		return bussinessProductAmount;
	}

	public void setBussinessProductAmount(EOBusinessFinancialWalletTransaction bussinessProductAmount) {
		this.bussinessProductAmount = bussinessProductAmount;
	}

	public EOBusinessFinancialWalletTransaction getBussinessTransactionFees() {
		return bussinessTransactionFees;
	}

	public void setBussinessTransactionFees(EOBusinessFinancialWalletTransaction bussinessTransactionFees) {
		this.bussinessTransactionFees = bussinessTransactionFees;
	}

}
