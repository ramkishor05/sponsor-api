package org.sponsor.account.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = EOUserSponsorBoostTransaction.USER_SPONSOR_BOOST_TRANSACTION)
public class EOUserSponsorBoostTransaction extends EOEntityObject {

	static final String USER_SPONSOR_BOOST_TRANSACTION = "USER_SPONSOR_BOOST_TRANSACTION";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "INVEST_TRANSACTION_ID")
	private EOUserFinancialWalletTransaction investTransaction;

	@ManyToOne
	@JoinColumn(name = "RETURN_TRANSACTION_ID")
	private EOUserFinancialWalletTransaction returnTransaction;

	@ManyToOne
	@JoinColumn(name = "USER_SPONSOR_ID")
	private EOUserSponsor userSponsor;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EOUserFinancialWalletTransaction getInvestTransaction() {
		return investTransaction;
	}

	public void setInvestTransaction(EOUserFinancialWalletTransaction investTransaction) {
		this.investTransaction = investTransaction;
	}

	public EOUserFinancialWalletTransaction getReturnTransaction() {
		return returnTransaction;
	}

	public void setReturnTransaction(EOUserFinancialWalletTransaction returnTransaction) {
		this.returnTransaction = returnTransaction;
	}

	public EOUserSponsor getUserSponsor() {
		return userSponsor;
	}

	public void setUserSponsor(EOUserSponsor userSponsor) {
		this.userSponsor = userSponsor;
	}

}
