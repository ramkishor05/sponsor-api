package org.sponsor.form.view.controller;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.pages.EOViewPageGroup;
import org.sponsor.form.view.model.pages.UIViewPageGroup;
import org.sponsor.form.view.service.ViewPageGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/page/group")
@CrossOrigin("*")
public class ViewPageGroupController implements CrudController<UIViewPageGroup, EOViewPageGroup, Long>{
	
	@Autowired
    private ViewPageGroupService pageGroupService;
	
	@GetMapping("/role/{roleId}")
	public ResponseEntity<List<UIViewPageGroup>> getPageGroupListByRole(@PathVariable Long roleId){
    	return ResponseEntity.ok(pageGroupService.getPageGroupListByRole(roleId));
	}

	@Override
	public CrudService<UIViewPageGroup, EOViewPageGroup, Long> getService() {
		return pageGroupService;
	}
}
