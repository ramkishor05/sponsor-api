package org.sponsor.account.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.sponsor.account.constants.TableConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = TableConstants.USER_FINANCIAL_WALLET_TRANSACTION)
public class EOUserFinancialWalletTransaction extends EOEntityObject {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "TRS_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date trsDate;
	
	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "UTR_NUMBER")
	private String utrNumber;
	
	@Column(name = "REMARKS")
	private String remarks;
	
	@ManyToOne
	@JoinColumn(name = "USER_FINANCIAL_WALLET_ID")
	private EOUserFinancialWallet userFinancialWallet;

	public Date getTrsDate() {
		return trsDate;
	}

	public void setTrsDate(Date trsDate) {
		this.trsDate = trsDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUtrNumber() {
		return utrNumber;
	}

	public void setUtrNumber(String utrNumber) {
		this.utrNumber = utrNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public EOUserFinancialWallet getUserFinancialWallet() {
		return userFinancialWallet;
	}

	public void setUserFinancialWallet(EOUserFinancialWallet userFinancialWallet) {
		this.userFinancialWallet = userFinancialWallet;
	}
}
