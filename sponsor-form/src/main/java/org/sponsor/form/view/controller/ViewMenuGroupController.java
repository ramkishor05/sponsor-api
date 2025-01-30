package org.sponsor.form.view.controller;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.menus.EOViewMenuGroup;
import org.sponsor.form.view.model.menus.UIViewMenuGroup;
import org.sponsor.form.view.service.ViewMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/menu/group")
public class ViewMenuGroupController implements CrudController<UIViewMenuGroup, EOViewMenuGroup, Long>{
	
	@Autowired
    private ViewMenuGroupService menuGroupService;
	
	@GetMapping("/role/{roleId}")
	public ResponseEntity<List<UIViewMenuGroup>> getMenuGroupListByRole(@PathVariable String roleId){
    	return ResponseEntity.ok(menuGroupService.getMenuGroupListByRole(roleId));
	}

	@Override
	public CrudService<UIViewMenuGroup, EOViewMenuGroup, Long> getService() {
		return menuGroupService;
	}
}
