package org.sponsor.form.view.model.menus;

import java.util.ArrayList;
import java.util.List;

public class UIViewMenuGroup {

	private long id;
	private String title;
	private String idenNo;
	private String url;
	private String icon;
	private String type;
	
	private List<UIViewMenuItem> menuItems;
	private Double orderSequence;
	private Boolean disabled;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
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

	public Double getOrderSequence() {
		if(orderSequence==null) {
			orderSequence=0d;
		}
		return orderSequence;
	}

	public void setOrderSequence(Double orderSequence) {
		this.orderSequence = orderSequence;
	}
	
	public List<UIViewMenuItem> getMenuItems() {
		if(menuItems==null) {
			menuItems=new ArrayList<UIViewMenuItem>();
		}
		return menuItems;
	}

	public void setMenuItems(List<UIViewMenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	public Boolean getDisabled() {
		if(disabled==null) {
			return false;
		}
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	
}
