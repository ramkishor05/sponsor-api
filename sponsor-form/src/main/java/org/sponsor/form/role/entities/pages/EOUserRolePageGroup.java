
package org.sponsor.form.role.entities.pages;

import static org.sponsor.form.constants.TableConstants.USER_ROLE_PAGE_GROUP;
import static org.sponsor.form.constants.TableConstants.USER_ROLE_PAGE_GROUP_UNIQUE;

import java.util.List;

import org.sponsor.form.entities.EOEntityObject;
import org.sponsor.form.view.entities.pages.EOViewPageGroup;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = USER_ROLE_PAGE_GROUP, uniqueConstraints = {
		@UniqueConstraint(name = USER_ROLE_PAGE_GROUP_UNIQUE, columnNames = { "USER_ROLE_ID", "PAGE_GROUP_ID" }) })
public class EOUserRolePageGroup extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "IDEN_NO")
	private String idenNo;

	@Column(name = "USER_ROLE_NAME", nullable = false, unique = false)
	private String userRoleName;

	@ManyToOne
	@JoinColumn(name = "PAGE_GROUP_ID", nullable = false, unique = false)
	private EOViewPageGroup pageGroup;

	@OneToMany(mappedBy = "rolePageGroup", cascade = CascadeType.ALL)
	private List<EOUserRolePageItem> rolePageItems;

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public EOViewPageGroup getPageGroup() {
		return pageGroup;
	}

	public void setPageGroup(EOViewPageGroup pageGroup) {
		this.pageGroup = pageGroup;
	}

	public List<EOUserRolePageItem> getRolePageItems() {
		return rolePageItems;
	}

	public void setRolePageItems(List<EOUserRolePageItem> rolePageItems) {
		this.rolePageItems = rolePageItems;
	}

	@Override
	public String toString() {
		return "EORolePageGroup [id=" + getId() + ", userRole=" + userRoleName + ", pageGroup=" + pageGroup + "";
	}

}
