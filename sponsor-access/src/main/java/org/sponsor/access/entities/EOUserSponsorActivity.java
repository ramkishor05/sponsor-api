
package org.sponsor.access.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_SPONSOR_ACTIVITY")
public class EOUserSponsorActivity extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "USER_SPONSOR_ID", unique = false)
	@ManyToOne(optional = false)
	private EOUserSponsor userSponsor;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "REMARKS", columnDefinition = "LONGTEXT")
	@Lob
	private String remarks;

	public EOUserSponsor getUserSponsor() {
		return userSponsor;
	}

	public void setUserSponsor(EOUserSponsor userSponsor) {
		this.userSponsor = userSponsor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
