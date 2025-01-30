package org.sponsor.account.model;

import java.util.List;

public class UIUserFinancialWallet extends UIModel{

	private Double balance;
	private Double levelIncome;
	private Double sponsorIncome;
	private Double boostIncome;
	private Double boostInvest;
	private Double royaltyIncome;
	private Boolean applicableBoost;

	private List<UIUserFinancialWalletTransaction> transactions;

	public Double getBalance() {
		if (balance == null) {
			balance = 0d;
		}
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getLevelIncome() {
		if (levelIncome == null) {
			levelIncome = 0d;
		}
		return levelIncome;
	}

	public void setLevelIncome(Double levelIncome) {
		this.levelIncome = levelIncome;
	}

	public Double getSponsorIncome() {
		if (sponsorIncome == null) {
			sponsorIncome = 0d;
		}
		return sponsorIncome;
	}

	public void setSponsorIncome(Double sponsorIncome) {
		this.sponsorIncome = sponsorIncome;
	}

	public Boolean getApplicableBoost() {
		return applicableBoost;
	}

	public void setApplicableBoost(Boolean applicableBoost) {
		this.applicableBoost = applicableBoost;
	}

	public Double getBoostIncome() {
		if (boostIncome == null) {
			boostIncome = 0d;
		}
		return boostIncome;
	}

	public void setBoostIncome(Double boostIncome) {
		this.boostIncome = boostIncome;
	}

	public void setBoostInvest(Double boostInvest) {
		this.boostInvest = boostInvest;
	}

	public Double getBoostInvest() {
		if (boostInvest == null) {
			boostInvest = 0d;
		}
		return boostInvest;
	}

	public void setRoyaltyInvest(Double royaltyIncome) {
		this.royaltyIncome = royaltyIncome;
	}

	public Double getRoyaltyIncome() {
		if (royaltyIncome == null) {
			royaltyIncome = 0d;
		}
		return royaltyIncome;
	}
	

	public void setRoyaltyIncome(Double royaltyIncome) {
		this.royaltyIncome = royaltyIncome;
	}


	public List<UIUserFinancialWalletTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<UIUserFinancialWalletTransaction> transactions) {
		this.transactions = transactions;
	}

}
