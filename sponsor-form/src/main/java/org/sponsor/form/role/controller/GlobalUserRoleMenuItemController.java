package org.sponsor.form.role.controller;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuItem;
import org.sponsor.form.role.model.menus.UIUserRoleMenuItem;
import org.sponsor.form.role.service.UserRoleMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/user/role/menu/item")
public class GlobalUserRoleMenuItemController implements CrudController<UIUserRoleMenuItem, EOUserRoleMenuItem, Long>{
	
	@Autowired
    private UserRoleMenuItemService roleMenuItemService;
	
	@GetMapping("/type/{type}")
	public ResponseEntity<List<UIUserRoleMenuItem>> getRoleMenuItemList(@PathVariable String type){
    	return ResponseEntity.ok(roleMenuItemService.getRoleMenuItemList(type));
	}

	@Override
	public CrudService<UIUserRoleMenuItem, EOUserRoleMenuItem, Long> getService() {
		return roleMenuItemService;
	}
	
}
