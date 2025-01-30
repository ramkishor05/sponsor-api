package org.sponsor.account.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = EOUserSponsor.USER_SPONSOR, uniqueConstraints = { @UniqueConstraint(columnNames = { "SPONSOR_ID" }) })
public class EOUserSponsor extends EOEntityObject {

	static final String USER_SPONSOR = "USER_SPONSOR";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "SPONSOR_ID")
	private Long sponsorId;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "UTR_NUMBER", columnDefinition = "LONGTEXT" )
	private String utrNumber;

	@Column(name = "PAYMENT_RECEIPT", columnDefinition = "LONGTEXT" )
	@Lob
	private String paymentReceipt;

	@Column(name = "LEVEL")
	private Long level;

	@Column(name = "USER_ACCOUNT_ID", nullable = true)
	private Long userAccountId;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "SPONSOR_BUSSINESS_ID", referencedColumnName = "SPONSOR_ID", nullable = true, unique = false)
	private EOBusinessSponsor sponsorBussiness;

	@ManyToOne(optional = true)
	@JoinColumn(name = "SPONSOR_LEADER_ID", referencedColumnName = "SPONSOR_ID", nullable = true, unique = false)
	private EOUserSponsor sponsorLeader;
	
	@OneToMany(mappedBy = "sponsorLeader")
    private List<EOUserSponsor> subSponsorList;
	
	public Long getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Long sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getUtrNumber() {
		return utrNumber;
	}

	public void setUtrNumber(String utrNumber) {
		this.utrNumber = utrNumber;
	}

	public String getPaymentReceipt() {
		return paymentReceipt;
	}

	public void setPaymentReceipt(String paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	
	public EOBusinessSponsor getSponsorBussiness() {
		return sponsorBussiness;
	}

	public void setSponsorBussiness(EOBusinessSponsor sponsorBussiness) {
		this.sponsorBussiness = sponsorBussiness;
	}

	public EOUserSponsor getSponsorLeader() {
		return sponsorLeader;
	}

	public void setSponsorLeader(EOUserSponsor sponsorLeader) {
		this.sponsorLeader = sponsorLeader;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<EOUserSponsor> getSubSponsorList() {
		return subSponsorList;
	}

	public void setSubSponsorList(List<EOUserSponsor> subSponsorList) {
		this.subSponsorList = subSponsorList;
	}

	public Long getLevel() {
		if(level==null) {
			level=0l;
		}
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
