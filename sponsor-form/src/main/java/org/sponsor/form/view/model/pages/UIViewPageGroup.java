package org.sponsor.form.view.model.pages;

import java.util.ArrayList;
import java.util.List;

public class UIViewPageGroup {

	private long id;
	private String title;
	private String idenNo;
	private String url;
	private String icon;
	private String type;
	
	private List<UIViewPageItem> pageItems;
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
	
	public List<UIViewPageItem> getPageItems() {
		if(pageItems==null) {
			pageItems=new ArrayList<UIViewPageItem>();
		}
		return pageItems;
	}

	public void setPageItems(List<UIViewPageItem> pageItems) {
		this.pageItems = pageItems;
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
