package org.sponsor.account.model;

import java.util.ArrayList;
import java.util.List;

public class UIUserSponsorModel extends UIModel {
	private Long userAccountId;
	private String registeredEmail;
	private String fullName;
	private Long sponsorId;
	private Long sponsorLeaderId;
	private String sponsorLeaderName;
	private String utrNumber;
	private Long levelNumber;
	private String transactionReceipt;
	private Boolean applicableBoost;
	private Double totalIncome;
	private Double levelIncome;
	private Double sponsorIncome;
	private Double boostIncome;
	private Double boostInvest;
	private Double royaltyIncome;
	private UIUserFinancialWallet wallet;
	private UIUserSponsorModel parent;
	private List<UIUserSponsorModel> children;
	private String status;
	private Boolean boostPending;

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getRegisteredEmail() {
		return registeredEmail;
	}

	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Long sponsorId) {
		this.sponsorId = sponsorId;
	}

	public Long getSponsorLeaderId() {
		return sponsorLeaderId;
	}

	public void setSponsorLeaderId(Long sponsorLeaderId) {
		this.sponsorLeaderId = sponsorLeaderId;
	}

	public String getSponsorLeaderName() {
		return sponsorLeaderName;
	}

	public void setSponsorLeaderName(String sponsorLeaderName) {
		this.sponsorLeaderName = sponsorLeaderName;
	}

	public String getUtrNumber() {
		return utrNumber;
	}

	public void setUtrNumber(String utrNumber) {
		this.utrNumber = utrNumber;
	}

	public String getTransactionReceipt() {
		return transactionReceipt;
	}

	public void setTransactionReceipt(String transactionReceipt) {
		this.transactionReceipt = transactionReceipt;
	}

	public Long getLevelNumber() {
		return levelNumber;
	}

	public void setLevel(Long levelNumber) {
		this.levelNumber = levelNumber;
	}

	public Double getLevelIncome() {
		if(levelIncome==null) {
			levelIncome=0d;	
		}
		return levelIncome;
	}

	public void setLevelIncome(Double levelIncome) {
		this.levelIncome = levelIncome;
	}

	public Double getSponsorIncome() {
		if(sponsorIncome==null) {
			sponsorIncome=0d;	
		}
		return sponsorIncome;
	}

	public void setSponsorIncome(Double sponsorIncome) {
		this.sponsorIncome = sponsorIncome;
	}

	public Double getTotalIncome() {
		if(totalIncome==null) {
			totalIncome=0d;	
		}
		return totalIncome;
	}

	public void setTotalIncome(Double balance) {
		this.totalIncome = balance;
	}

	public Boolean getApplicableBoost() {
		return applicableBoost;
	}

	public void setApplicableBoost(Boolean applicableBoost) {
		this.applicableBoost = applicableBoost;
	}

	public Double getBoostIncome() {
		if(boostIncome==null) {
			boostIncome=0d;	
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
		if(boostInvest==null) {
			boostInvest=0d;	
		}
		return boostInvest;
	}

	public void setRoyaltyIncome(Double royaltyIncome) {
		this.royaltyIncome=royaltyIncome;
	}
	
	public Double getRoyaltyIncome() {
		if(royaltyIncome==null) {
			royaltyIncome=0d;	
		}
		return royaltyIncome;
	}

	public UIUserSponsorModel getParent() {
		return parent;
	}

	public void setParent(UIUserSponsorModel parent) {
		this.parent = parent;
	}

	public List<UIUserSponsorModel> getChildren() {
		if(children==null) {
			children=new ArrayList<UIUserSponsorModel>();
		}
		return children;
	}

	public void setChildren(List<UIUserSponsorModel> children) {
		this.children = children;
	}

	public void setLevelNumber(Long levelNumber) {
		this.levelNumber = levelNumber;
	}


	public UIUserFinancialWallet getWallet() {
		return wallet;
	}

	public void setWallet(UIUserFinancialWallet wallet) {
		this.wallet = wallet;
	}

	public void setStatus(String status) {
		this.status=status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setBoostPending(Boolean boostPending) {
		this.boostPending=boostPending;
	}
	
	public Boolean getBoostPending() {
		return boostPending;
	}
}
