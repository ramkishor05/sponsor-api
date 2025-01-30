package org.sponsor.form.role.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuItem;
import org.sponsor.form.role.model.menus.UIUserRoleMenuItem;

public interface UserRoleMenuItemService extends CrudService<UIUserRoleMenuItem, EOUserRoleMenuItem, Long>{

	List<UIUserRoleMenuItem> getRoleMenuItemList(String type);

}
