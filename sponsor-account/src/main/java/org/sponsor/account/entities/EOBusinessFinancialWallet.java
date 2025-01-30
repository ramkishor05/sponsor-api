package org.sponsor.account.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BUSSINESS_FINANCIAL_WALLET")
public class EOBusinessFinancialWallet extends EOEntityObject {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "BUSSINESS_SPONSOR_ID")
	private EOBusinessSponsor bussinessSponsor;
    
    @Column(name = "BALANCE")
	private Double balance;
    
    @Column(name = "FEES")
   	private Double fees;
    
    @OneToMany(mappedBy = "businessFinancialWallet")
    private List<EOBusinessFinancialWalletTransaction> transactions;
    
	public EOBusinessSponsor getBussinessSponsor() {
		return bussinessSponsor;
	}

	public void setBussinessSponsor(EOBusinessSponsor bussinessSponsor) {
		this.bussinessSponsor = bussinessSponsor;
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

	public List<EOBusinessFinancialWalletTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<EOBusinessFinancialWalletTransaction> transactions) {
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
	
}
