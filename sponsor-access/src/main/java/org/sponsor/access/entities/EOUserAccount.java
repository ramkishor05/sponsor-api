
package org.sponsor.access.entities;

import java.sql.Timestamp;
import java.util.List;

import org.brijframework.integration.spring.rest.crud.beans.IUserAccount;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "USER_ACCOUNT", uniqueConstraints = { @UniqueConstraint(columnNames = { "USERNAME", "ROLE_ID" }),
		@UniqueConstraint(columnNames = { "USERNAME", "ROLE_ID" }),
		@UniqueConstraint(columnNames = { "ACCOUNT_MOBILE", "ROLE_ID" }),
		@UniqueConstraint(columnNames = { "ACCOUNT_EMAIL", "ROLE_ID" }) })
public class EOUserAccount extends EOEntityObject implements IUserAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ACCOUNT_NAME")
	private String accountName;

	@Column(name = "ACCOUNT_MOBILE")
	private String registeredMobile;

	@Column(name = "ACCOUNT_EMAIL")
	private String registeredEmail;

	@ManyToOne
	@JoinColumn(name = "ROLE_ID", unique = false)
	private EOUserRole userRole;

	@Column(name = "RESET_PASSWORD_TOKEN", nullable = true)
	private String resetPasswordToken;

	@Column(name = "RESET_PASSWORD_SENT_AT", nullable = true)
	private Timestamp resetPasswordSentAt;

	@OneToMany(mappedBy = "userAccount")
	private List<EOUserAccountService> authServices;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getRegisteredMobile() {
		return registeredMobile;
	}

	public void setRegisteredMobile(String registeredMobile) {
		this.registeredMobile = registeredMobile;
	}

	public String getRegisteredEmail() {
		return registeredEmail;
	}

	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}

	public EOUserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(EOUserRole userRole) {
		this.userRole = userRole;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Timestamp getResetPasswordSentAt() {
		return resetPasswordSentAt;
	}

	public void setResetPasswordSentAt(Timestamp resetPasswordSentAt) {
		this.resetPasswordSentAt = resetPasswordSentAt;
	}

	public List<EOUserAccountService> getAuthServices() {
		return authServices;
	}

	public void setAuthServices(List<EOUserAccountService> authServices) {
		this.authServices = authServices;
	}

	@Override
	public String toString() {
		return "EOUserLogin [id=" + getId() + ", username=" + username + ", password=" + password + ", accountName="
				+ accountName + ", userRole=" + userRole + "]";
	}

}
