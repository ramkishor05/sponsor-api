package org.sponsor.form.role.controller;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuGroup;
import org.sponsor.form.role.model.menus.UIUserRoleMenuGroup;
import org.sponsor.form.role.service.UserRoleMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/user/role/menu/group")
@CrossOrigin("*")
public class GlobalUserRoleMenuGroupController implements CrudController<UIUserRoleMenuGroup, EOUserRoleMenuGroup, Long>{
	
	@Autowired
    private UserRoleMenuGroupService roleMenuGroupService;

	@Override
	public CrudService<UIUserRoleMenuGroup, EOUserRoleMenuGroup, Long> getService() {
		return roleMenuGroupService;
	}
	
	@GetMapping("/type/{type}")
	public ResponseEntity<List<UIUserRoleMenuGroup>> getRoleMenuGroupList(@PathVariable String type){
    	return ResponseEntity.ok(roleMenuGroupService.getRoleMenuGroupList(type));
	}

}
