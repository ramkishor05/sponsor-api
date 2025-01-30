package org.sponsor.form.role.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuGroup;
import org.sponsor.form.role.model.menus.UIUserRoleMenuGroup;

public interface UserRoleMenuGroupService extends CrudService<UIUserRoleMenuGroup, EOUserRoleMenuGroup, Long>{

	List<UIUserRoleMenuGroup> getRoleMenuGroupList(String type);


}
