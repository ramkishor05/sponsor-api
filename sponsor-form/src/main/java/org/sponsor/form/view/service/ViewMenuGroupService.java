package org.sponsor.form.view.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.menus.EOViewMenuGroup;
import org.sponsor.form.view.model.menus.UIViewMenuGroup;

public interface ViewMenuGroupService extends CrudService<UIViewMenuGroup, EOViewMenuGroup, Long>{

	List<UIViewMenuGroup> getMenuGroupListByRole(String roleId);
}
