package org.sponsor.form.role.entities.onboarding;

import java.util.Date;

import org.sponsor.form.entities.EOPayment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_ONBOARDING_BILLING")
public class EOUserOnBoardingBilling extends EOPayment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "START_AT")
	private Date startAt;
	
	@Column(name = "EXPRIED_AT")
	private Date expriedAt;

	@Column(name = "USER_ACCOUNT_ID", nullable = false)
	private Long userAccountId;

	public Date getStartAt() {
		return startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}

	public Date getExpriedAt() {
		return expriedAt;
	}

	public void setExpriedAt(Date expriedAt) {
		this.expriedAt = expriedAt;
	}

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

}
