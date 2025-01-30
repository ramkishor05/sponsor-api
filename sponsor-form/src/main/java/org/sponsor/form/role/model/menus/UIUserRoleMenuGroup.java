package org.sponsor.form.role.model.menus;

import org.sponsor.form.view.model.menus.UIViewMenuGroup;

public class UIUserRoleMenuGroup {

	private Long id;

	private String idenNo;

	private String userRoleName;

	private UIViewMenuGroup menuGroup;

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

	public UIViewMenuGroup getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(UIViewMenuGroup menuGroup) {
		this.menuGroup = menuGroup;
	}
}
