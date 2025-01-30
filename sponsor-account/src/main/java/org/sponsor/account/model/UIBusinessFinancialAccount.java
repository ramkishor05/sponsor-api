package org.sponsor.account.model;

import java.util.List;

public class UIBusinessFinancialAccount extends UIModel{
	
	private Double balance;
	
	private Double fees;
	
	private Long bussinessSponsorId;

	private List<UIBusinessBankAccount> bankAccounts;
	
	private List<UIBusinessBankUpi> bankUpis;
	
	private List<UIBusinessFinancialAccountTransaction> transactions;

	
	public Long getBussinessSponsorId() {
		return bussinessSponsorId;
	}

	public void setBussinessSponsorId(Long bussinessSponsorId) {
		this.bussinessSponsorId = bussinessSponsorId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public List<UIBusinessBankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<UIBusinessBankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<UIBusinessBankUpi> getBankUpis() {
		return bankUpis;
	}

	public void setBankUpis(List<UIBusinessBankUpi> bankUpis) {
		this.bankUpis = bankUpis;
	}

	public List<UIBusinessFinancialAccountTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<UIBusinessFinancialAccountTransaction> transactions) {
		this.transactions = transactions;
	}
	
}
