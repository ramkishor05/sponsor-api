package org.sponsor.account.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BUSINESS_FINANCIAL_BANK_ACCOUNT")
public class EOBusinessFinancialBankAccount extends EOBankAccount {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	@JoinColumn(name = "FINANCIAL_ACCOUNT_ID")
	private EOBusinessFinancialAccount bussinessFinancialAccount;

	public EOBusinessFinancialAccount getBussinessFinancialAccount() {
		return bussinessFinancialAccount;
	}

	public void setBussinessFinancialAccount(EOBusinessFinancialAccount bussinessFinancialAccount) {
		this.bussinessFinancialAccount = bussinessFinancialAccount;
	}
}
