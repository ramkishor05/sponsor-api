package org.sponsor.account.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "BUSSINESS_SPONSOR", uniqueConstraints = { @UniqueConstraint(columnNames = { "SPONSOR_ID" }) })
public class EOBusinessSponsor extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "SPONSOR_ID")
	private Long sponsorId;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "USER_ACCOUNT_ID", nullable = true)
	private Long userAccountId;

	@ManyToOne(optional = true)
	@JoinColumn(name = "SPONSOR_LEADER_ID", referencedColumnName = "SPONSOR_ID", nullable = true, unique = false)
	private EOBusinessSponsor sponsorLeader;
	
	@OneToMany(mappedBy = "sponsorLeader")
    private List<EOBusinessSponsor> subSponsorList;
	
	public Long getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Long sponsorId) {
		this.sponsorId = sponsorId;
	}

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public EOBusinessSponsor getSponsorLeader() {
		return sponsorLeader;
	}

	public void setSponsorLeader(EOBusinessSponsor sponsorLeader) {
		this.sponsorLeader = sponsorLeader;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<EOBusinessSponsor> getSubSponsorList() {
		return subSponsorList;
	}

	public void setSubSponsorList(List<EOBusinessSponsor> subSponsorList) {
		this.subSponsorList = subSponsorList;
	}

}
