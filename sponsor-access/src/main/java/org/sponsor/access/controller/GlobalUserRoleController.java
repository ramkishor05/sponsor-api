package org.sponsor.access.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.access.entities.EOUserRole;
import org.sponsor.access.model.UIUserRole;
import org.sponsor.access.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/user/role")
@CrossOrigin("*")
public class GlobalUserRoleController implements CrudController<UIUserRole, EOUserRole, Long>{
	
	@Autowired
    private UserRoleService userRolelService;

	@Override
	public CrudService<UIUserRole, EOUserRole, Long> getService() {
		return userRolelService;
	}
	
}
