package org.sponsor.account.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = EOUserSponsorEntryTransaction.USER_SPONSOR_ENTRY_TRANSACTION)
public class EOUserSponsorEntryTransaction extends EOEntityObject {

	static final String USER_SPONSOR_ENTRY_TRANSACTION = "USER_SPONSOR_ENTRY_TRANSACTION";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "USER_SPONSOR_ID")
	private EOUserSponsor userSponsor;
	
	@ManyToOne
	@JoinColumn(name = "ENTRY_AMOUNT_ID", nullable = false)
	private EOUserFinancialWalletTransaction userEntryAmount;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_AMOUNT_ID", nullable = false)
	private EOUserFinancialWalletTransaction userProductAmount;

	@ManyToOne
	@JoinColumn(name = "SPONSOR_AMOUNT_ID", nullable = false)
	private EOUserFinancialWalletTransaction userSponsorAmount;

	@ManyToOne
	@JoinColumn(name = "TRANSACTION_FEES_ID", nullable = false)
	private EOUserFinancialWalletTransaction userTransactionFees;

	@ManyToOne
	@JoinColumn(name = "BUSINESS_ENTRY_ID", nullable = false)
	private EOBusinessSponsorEntryTransaction businessEntryAmount;

	public EOUserSponsor getUserSponsor() {
		return userSponsor;
	}

	public void setUserSponsor(EOUserSponsor userSponsor) {
		this.userSponsor = userSponsor;
	}

	public EOUserFinancialWalletTransaction getUserEntryAmount() {
		return userEntryAmount;
	}

	public void setUserEntryAmount(EOUserFinancialWalletTransaction userEntryAmount) {
		this.userEntryAmount = userEntryAmount;
	}

	public EOUserFinancialWalletTransaction getUserProductAmount() {
		return userProductAmount;
	}

	public void setUserProductAmount(EOUserFinancialWalletTransaction userProductAmount) {
		this.userProductAmount = userProductAmount;
	}

	public EOUserFinancialWalletTransaction getUserSponsorAmount() {
		return userSponsorAmount;
	}

	public void setUserSponsorAmount(EOUserFinancialWalletTransaction userSponsorAmount) {
		this.userSponsorAmount = userSponsorAmount;
	}

	public EOUserFinancialWalletTransaction getUserTransactionFees() {
		return userTransactionFees;
	}

	public void setUserTransactionFees(EOUserFinancialWalletTransaction userTransactionFees) {
		this.userTransactionFees = userTransactionFees;
	}

	public EOBusinessSponsorEntryTransaction getBusinessEntryAmount() {
		return businessEntryAmount;
	}

	public void setBusinessEntryAmount(EOBusinessSponsorEntryTransaction businessEntryAmount) {
		this.businessEntryAmount = businessEntryAmount;
	}
	
}
