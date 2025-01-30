
package org.sponsor.access.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "USER_SPONSOR", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "USER_ACCOUNT_ID" })})
public class EOUserSponsor extends EOEntityObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "USER_ACCOUNT_ID", unique = true)
	@OneToOne
	private EOUserAccount userAccount;
	
	@Column(name = "SPONSOR_LEADER_ID")
	private Long sponsorLeaderId;
	
	@Column(name = "PAYMENT_RECEIPT", columnDefinition = "LONGTEXT" )
	@Lob
	private String paymentReceipt;
	
	@Column(name = "UTR_NUMBER", columnDefinition = "LONGTEXT" , unique = true)
	private String utrNumber;
	
	@OneToOne
	@JoinColumn(name = "USER_SPONSOR_ACTIVITY_ID", unique = false)
	private EOUserSponsorActivity activity;
	
	@OneToMany(mappedBy = "userSponsor")
	private List<EOUserSponsorActivity> activityList;

	public EOUserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(EOUserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Long getSponsorLeaderId() {
		return sponsorLeaderId;
	}

	public void setSponsorLeaderId(Long sponsorLeaderId) {
		this.sponsorLeaderId = sponsorLeaderId;
	}

	public String getPaymentReceipt() {
		return paymentReceipt;
	}

	public void setPaymentReceipt(String paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	public String getUtrNumber() {
		return utrNumber;
	}

	public void setUtrNumber(String utrNumber) {
		this.utrNumber = utrNumber;
	}

	public EOUserSponsorActivity getActivity() {
		return activity;
	}

	public void setActivity(EOUserSponsorActivity activity) {
		this.activity = activity;
	}

	public List<EOUserSponsorActivity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<EOUserSponsorActivity> activityList) {
		this.activityList = activityList;
	} 
}
