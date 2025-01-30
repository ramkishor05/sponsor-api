package org.sponsor.form.view.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.menus.EOViewMenuItem;
import org.sponsor.form.view.model.menus.UIViewMenuItem;

public interface ViewMenuItemService extends CrudService<UIViewMenuItem, EOViewMenuItem, Long>{

	List<UIViewMenuItem> getMenuItemList(String type);

	List<UIViewMenuItem> getMenuItemListByRole(String roleId);

}
