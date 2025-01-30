package org.sponsor.account.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = EOUserSponsorProductTransaction.USER_SPONSOR_PRODUCT_TRANSACTION)
public class EOUserSponsorProductTransaction extends EOEntityObject {

	static final String USER_SPONSOR_PRODUCT_TRANSACTION = "USER_SPONSOR_PRODUCT_TRANSACTION";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "USER_WALLET_TRANSACTION_ID")
	private EOUserFinancialWalletTransaction userTransaction;

	@ManyToOne
	@JoinColumn(name = "USER_SPONSOR_ID")
	private EOUserSponsor userSponsor;
	
	public EOUserFinancialWalletTransaction getUserTransaction() {
		return userTransaction;
	}

	public void setUserTransaction(EOUserFinancialWalletTransaction userTransaction) {
		this.userTransaction = userTransaction;
	}

	public EOUserSponsor getUserSponsor() {
		return userSponsor;
	}

	public void setUserSponsor(EOUserSponsor userSponsor) {
		this.userSponsor = userSponsor;
	}

}
