package org.sponsor.account.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UIBusinessSponsorTreeModel {

	private String name;

	private UIBusinessSponsorTreeModel parent;
	private List<UIBusinessSponsorTreeModel> children;
	private Map<String, Object> attributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UIBusinessSponsorTreeModel getParent() {
		return parent;
	}

	public void setParent(UIBusinessSponsorTreeModel parent) {
		this.parent = parent;
	}

	public List<UIBusinessSponsorTreeModel> getChildren() {
		if (children == null) {
			children = new ArrayList<UIBusinessSponsorTreeModel>();
		}
		return children;
	}

	public void setChildren(List<UIBusinessSponsorTreeModel> children) {
		this.children = children;
	}

	public Map<String, Object> getAttributes() {
		if (attributes == null) {
			attributes = new HashMap<String, Object>();
		}
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
}
