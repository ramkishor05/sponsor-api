package org.sponsor.account.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BUSINESS_SPONSOR_LINK_TRANSACTION")
public class EOBusinessSponsorLinkTransaction extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "LINK_SPONSOR_ID")
	private EOUserSponsor linkSponsor;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_TRANSACTION_ID")
	private EOBusinessFinancialAccountTransaction bussinessAccountTransaction;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_TRANSACTION_ID")
	private EOBusinessFinancialWalletTransaction bussinessWalletProductTransaction;
	
	@ManyToOne
	@JoinColumn(name = "LINK_TRANSACTION_ID")
	private EOBusinessFinancialWalletTransaction bussinessWalletLinkTransaction;

	@ManyToOne
	@JoinColumn(name = "BUSSINESS_SPONSOR_ID")
	private EOBusinessSponsor bussinessSponsor;

	public EOUserSponsor getLinkSponsor() {
		return linkSponsor;
	}

	public void setLinkSponsor(EOUserSponsor linkSponsor) {
		this.linkSponsor = linkSponsor;
	}

	public EOBusinessFinancialAccountTransaction getBussinessAccountTransaction() {
		return bussinessAccountTransaction;
	}

	public void setBussinessAccountTransaction(EOBusinessFinancialAccountTransaction bussinessAccountTransaction) {
		this.bussinessAccountTransaction = bussinessAccountTransaction;
	}
	
	public EOBusinessFinancialWalletTransaction getBussinessWalletProductTransaction() {
		return bussinessWalletProductTransaction;
	}

	public void setBussinessWalletProductTransaction(EOBusinessFinancialWalletTransaction bussinessWalletProductTransaction) {
		this.bussinessWalletProductTransaction = bussinessWalletProductTransaction;
	}

	public EOBusinessFinancialWalletTransaction getBussinessWalletLinkTransaction() {
		return bussinessWalletLinkTransaction;
	}

	public void setBussinessWalletLinkTransaction(EOBusinessFinancialWalletTransaction bussinessWalletLinkTransaction) {
		this.bussinessWalletLinkTransaction = bussinessWalletLinkTransaction;
	}

	public EOBusinessSponsor getBussinessSponsor() {
		return bussinessSponsor;
	}

	public void setBussinessSponsor(EOBusinessSponsor bussinessSponsor) {
		this.bussinessSponsor = bussinessSponsor;
	}

}
