package org.sponsor.account.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = EOUserFinancialWallet.USER_FINANCIAL_WALLET)
public class EOUserFinancialWallet extends EOEntityObject {

	static final String USER_FINANCIAL_WALLET = "USER_FINANCIAL_WALLET";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "USER_SPONSOR_ID")
	private EOUserSponsor userSponsor;
    
    @Column(name = "BALANCE")
	private Double balance;
    
    @Column(name = "FEES")
    private Double fees;
    
    @Column(name = "SPONSOR_INCOME")
    private Double sponsorIncome;
    
    @Column(name = "BOOST_INCOME")
    private Double boostIncome;
    
    @Column(name = "LEVEL_INCOME")
    private Double levelIncome;
    
    @Column(name = "ROYALTY_INCOME")
    private Double royaltyIncome;
    
    @OneToMany(mappedBy = "userFinancialWallet")
    private List<EOUserFinancialWalletTransaction> transactions;

	

	public EOUserSponsor getUserSponsor() {
		return userSponsor;
	}

	public void setUserSponsor(EOUserSponsor userSponsor) {
		this.userSponsor = userSponsor;
	}

	public Double getBalance() {
		if(balance==null) {
			balance=0.0d;
		}
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<EOUserFinancialWalletTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<EOUserFinancialWalletTransaction> transactions) {
		this.transactions = transactions;
	}

	public Double getFees() {
		if(fees==null) {
			fees=0.0d;
		}
		return fees;
	}
	
	public void setFees(Double fees) {
		this.fees = fees;
	}
	
	public Double getSponsorIncome() {
		if(sponsorIncome==null) {
			sponsorIncome=0.0d;
		}
		return sponsorIncome;
	}
	
	public void setSponsorIncome(Double sponsorIncome) {
		this.sponsorIncome = sponsorIncome;
	}

	public Double getBoostIncome() {
		if(boostIncome==null) {
			boostIncome=0.0d;
		}
		return boostIncome;
	}

	public void setBoostIncome(Double boostIncome) {
		this.boostIncome = boostIncome;
	}

	public Double getLevelIncome() {
		if(levelIncome==null) {
			levelIncome=0.0d;
		}
		return levelIncome;
	}

	public void setLevelIncome(Double levelIncome) {
		this.levelIncome = levelIncome;
	}

	public Double getRoyaltyIncome() {
		if(royaltyIncome==null) {
			royaltyIncome=0.0d;
		}
		return royaltyIncome;
	}
	
	public void setRoyaltyIncome(Double royaltyIncome) {
		this.royaltyIncome = royaltyIncome;
	}
	
	
}
