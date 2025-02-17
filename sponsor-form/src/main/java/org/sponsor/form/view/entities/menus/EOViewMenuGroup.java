package org.sponsor.form.view.entities.menus;
import static org.sponsor.form.view.constants.ViewTableConstants.VIEW_MENU_GROUP;

import java.util.List;

import org.sponsor.form.entities.EOEntityObject;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = VIEW_MENU_GROUP, uniqueConstraints = {@UniqueConstraint(columnNames = { "IDEN_NO" }) })
public class EOViewMenuGroup extends EOEntityObject{

	private static final long serialVersionUID = 1L;

	@Column(name = "IDEN_NO")
	private String idenNo;
	
	@Column(name = "TITLE")
	private String title;

	@Column(name = "URL")
	private String url;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "ICON")
	private String icon;
	
	@OneToMany(mappedBy = "menuGroup", cascade = CascadeType.ALL)
	private List<EOViewMenuItem>  menuItemList;

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<EOViewMenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<EOViewMenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	@Override
	public String toString() {
		return "EOMenuGroup [id=" + getId() + ", idenNo=" + idenNo + ", title=" + title + ", url=" + url + ", type=" + type
				+ ", icon=" + icon + ", orderSequence=" + getOrderSequence() + "]";
	}
	
	
}
