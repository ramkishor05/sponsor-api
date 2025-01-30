package org.sponsor.form.view.controller;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.menus.EOViewMenuItem;
import org.sponsor.form.view.model.menus.UIViewMenuItem;
import org.sponsor.form.view.service.ViewMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/menu/item")
@CrossOrigin("*")
public class ViewMenuItemController implements CrudController<UIViewMenuItem, EOViewMenuItem, Long>{
	
	@Autowired
    private ViewMenuItemService menuItemService;

	@Override
	public CrudService<UIViewMenuItem, EOViewMenuItem, Long> getService() {
		return menuItemService;
	}
	
	@GetMapping("/role/{roleId}")
	public ResponseEntity<List<UIViewMenuItem>> getMenuGroupListByRole(@PathVariable String roleId){
    	return ResponseEntity.ok(menuItemService.getMenuItemListByRole(roleId));
	}

	
}
