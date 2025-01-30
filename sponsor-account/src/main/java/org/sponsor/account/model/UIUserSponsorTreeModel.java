package org.sponsor.account.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UIUserSponsorTreeModel extends UIModel {
	private String name;
	
	private UIUserSponsorTreeModel parent;
	private List<UIUserSponsorTreeModel> children;
	private Map<String, Object> attributes;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UIUserSponsorTreeModel getParent() {
		return parent;
	}

	public void setParent(UIUserSponsorTreeModel parent) {
		this.parent = parent;
	}

	public List<UIUserSponsorTreeModel> getChildren() {
		if(children==null) {
			children=new ArrayList<UIUserSponsorTreeModel>();
		}
		return children;
	}

	public void setChildren(List<UIUserSponsorTreeModel> children) {
		this.children = children;
	}

	public Map<String, Object> getAttributes() {
		if(attributes==null) {
			attributes=new HashMap<String, Object>();
		}
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
}
