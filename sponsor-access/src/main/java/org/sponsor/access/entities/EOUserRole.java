package org.sponsor.access.entities;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class EOUserRole extends EOEntityObject{

	private static final long serialVersionUID = 1L;

	@Column(name = "POSITION")
	private int position;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@Column(name = "ROLE_ID")
	private String roleId;
	
	@Column(name = "ROLE_TYPE")
	private String roleType;

	@OneToMany(mappedBy = "userRole")
	private List<EOUserAccount> userAccounts;
	
	public EOUserRole() {
	}

	public EOUserRole(int position, String roleName, String roleId) {
		super();
		this.position = position;
		this.roleName = roleName;
		this.roleId = roleId;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleID) {
		this.roleId = roleID;
	}
	
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public List<EOUserAccount> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<EOUserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

}
