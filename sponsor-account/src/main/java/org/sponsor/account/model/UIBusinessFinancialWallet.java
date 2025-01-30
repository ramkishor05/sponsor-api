package org.sponsor.account.model;

import java.util.List;

public class UIBusinessFinancialWallet extends UIModel {

	private Double balance;

	private List<UIBusinessFinancialWalletTransaction> transactions;

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<UIBusinessFinancialWalletTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<UIBusinessFinancialWalletTransaction> transactions) {
		this.transactions = transactions;
	}
	
}
