package org.sponsor.account.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_FINANCIAL_BANK_ACCOUNT")
public class EOUserFinancialBankAccount extends EOBankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "FINANCIAL_ACCOUNT_ID")
	private EOUserFinancialAccount userFinancialAccount;

	public EOUserFinancialAccount getUserFinancialAccount() {
		return userFinancialAccount;
	}

	public void setUserFinancialAccount(EOUserFinancialAccount userFinancialAccount) {
		this.userFinancialAccount = userFinancialAccount;
	}

}
