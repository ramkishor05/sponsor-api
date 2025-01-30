package org.sponsor.form.role.model.menus;

import org.sponsor.form.view.model.menus.UIViewMenuItem;

public class UIUserRoleMenuItem {

	private Long id;

	private String idenNo;

	private String userRoleName;

	private UIViewMenuItem menuItem;

	private UIUserRoleMenuGroup roleMenuGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public UIViewMenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(UIViewMenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public UIUserRoleMenuGroup getRoleMenuGroup() {
		return roleMenuGroup;
	}

	public void setRoleMenuGroup(UIUserRoleMenuGroup roleMenuGroup) {
		this.roleMenuGroup = roleMenuGroup;
	}
}
