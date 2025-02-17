package org.sponsor.form.role.entities.onboarding;

import org.sponsor.form.entities.EOEntityObject;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuItem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "USER_ONBOARDING_MENU", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "USER_ACCOUNT_ID", "ROLE_MENU_ITEM_ID" }) })
public class EOUserOnBoardingPage extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "USER_ACCOUNT_ID", nullable = false)
	private Long userAccountId;

	@JoinColumn(name = "ROLE_MENU_ITEM_ID", nullable = false)
	@ManyToOne
	private EOUserRoleMenuItem roleMenuItem;

	@Column(name = "ON_BOARDING_STATUS")
	private Boolean onBoardingStatus;

	@Column(name = "ON_BOARDING_LEVEL", nullable = true)
	private Integer onBoardingLevel;

	@PrePersist
	public void init() {
		onBoardingStatus = false;
	}

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public EOUserRoleMenuItem getRoleMenuItem() {
		return roleMenuItem;
	}

	public void setRoleMenuItem(EOUserRoleMenuItem roleMenuItem) {
		this.roleMenuItem = roleMenuItem;
	}

	public Boolean getOnBoardingStatus() {
		if (onBoardingStatus == null) {
			return false;
		}
		return onBoardingStatus;
	}

	public void setOnBoardingStatus(Boolean onBoardingStatus) {
		this.onBoardingStatus = onBoardingStatus;
	}

	public Integer getOnBoardingLevel() {
		return onBoardingLevel;
	}

	public void setOnBoardingLevel(Integer onBoardingLevel) {
		this.onBoardingLevel = onBoardingLevel;
	}
}
