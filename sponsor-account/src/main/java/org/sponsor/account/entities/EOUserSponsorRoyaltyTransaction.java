package org.sponsor.account.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = EOUserSponsorRoyaltyTransaction.USER_SPONSOR_ROYALTY_TRANSACTION)
public class EOUserSponsorRoyaltyTransaction extends EOEntityObject {

	static final String USER_SPONSOR_ROYALTY_TRANSACTION = "USER_SPONSOR_ROYALTY_TRANSACTION";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MONTH")
	private Integer month;

	@Column(name = "YEAR")
	private Integer year;

	@Column(name = "TRS_DATE")
	private Date trsDate;

	@ManyToOne
	@JoinColumn(name = "USER_WALLET_TRANSACTION_ID")
	private EOUserFinancialWalletTransaction userWalletTransaction;

	@ManyToOne
	@JoinColumn(name = "USER_SPONSOR_ID")
	private EOUserSponsor userSponsor;

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

	public EOUserFinancialWalletTransaction getUserWalletTransaction() {
		return userWalletTransaction;
	}

	public void setUserWalletTransaction(EOUserFinancialWalletTransaction userWalletTransaction) {
		this.userWalletTransaction = userWalletTransaction;
	}

	public EOUserSponsor getUserSponsor() {
		return userSponsor;
	}

	public void setUserSponsor(EOUserSponsor userSponsor) {
		this.userSponsor = userSponsor;
	}

}
