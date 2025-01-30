package org.sponsor.account.model;

import java.util.List;

public class UIUserFinancialAccount extends UIModel {

	private Double balance;
	private Double levelIncome;
	private Double sponsorIncome;
	private Double boostIncome;
	private Double boostInvest;
	private Double royaltyIncome;
	private Boolean applicableBoost;

	private List<UIUserFinancialAccountTransaction> transactions;

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getLevelIncome() {
		return levelIncome;
	}

	public void setLevelIncome(Double levelIncome) {
		this.levelIncome = levelIncome;
	}

	public Double getSponsorIncome() {
		return sponsorIncome;
	}

	public void setSponsorIncome(Double sponsorIncome) {
		this.sponsorIncome = sponsorIncome;
	}

	public Double getBoostIncome() {
		return boostIncome;
	}

	public void setBoostIncome(Double boostIncome) {
		this.boostIncome = boostIncome;
	}

	public Double getBoostInvest() {
		return boostInvest;
	}

	public void setBoostInvest(Double boostInvest) {
		this.boostInvest = boostInvest;
	}

	public Double getRoyaltyIncome() {
		return royaltyIncome;
	}

	public void setRoyaltyIncome(Double royaltyIncome) {
		this.royaltyIncome = royaltyIncome;
	}

	public Boolean getApplicableBoost() {
		return applicableBoost;
	}

	public void setApplicableBoost(Boolean applicableBoost) {
		this.applicableBoost = applicableBoost;
	}

	public List<UIUserFinancialAccountTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<UIUserFinancialAccountTransaction> transactions) {
		this.transactions = transactions;
	}
	
}
