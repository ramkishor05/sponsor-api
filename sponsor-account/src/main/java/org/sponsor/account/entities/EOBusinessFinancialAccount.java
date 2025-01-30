package org.sponsor.account.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BUSINESS_FINANCIAL_ACCOUNT")
public class EOBusinessFinancialAccount extends EOEntityObject {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "BUSSINESS_SPONSOR_ID")
	private EOBusinessSponsor bussinessSponsor;
    
    @Column(name = "BALANCE")
	private Double balance;
    
    @Column(name = "FEES")
	private Double fees;
    
    @OneToOne(mappedBy = "bussinessFinancialAccount", cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_UPI_ID")
    private EOBusinessFinancialBankUpi bankUpi;
    
    @OneToOne(mappedBy = "bussinessFinancialAccount", cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_ACCOUNT_ID")
    private EOBusinessFinancialBankAccount bankAccount;

    @OneToMany(mappedBy = "bussinessFinancialAccount")
    private List<EOBusinessFinancialAccountTransaction> transactions;

	public EOBusinessFinancialBankUpi getBankUpi() {
		return bankUpi;
	}

	public void setBankUpi(EOBusinessFinancialBankUpi bankUpi) {
		this.bankUpi = bankUpi;
	}

	public EOBusinessFinancialBankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(EOBusinessFinancialBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

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
	
	public Double getFees() {
		if(fees==null) {
			fees=0.0d;
		}
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public List<EOBusinessFinancialAccountTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<EOBusinessFinancialAccountTransaction> transactions) {
		this.transactions = transactions;
	}
	
}
