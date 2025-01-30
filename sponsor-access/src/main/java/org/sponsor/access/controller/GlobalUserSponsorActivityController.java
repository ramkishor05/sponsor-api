package org.sponsor.access.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.access.entities.EOUserSponsorActivity;
import org.sponsor.access.model.UIUserSponsorActivity;
import org.sponsor.access.service.UserSponsorActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/user/sponsor/activity")
@CrossOrigin("*")
public class GlobalUserSponsorActivityController implements CrudController<UIUserSponsorActivity, EOUserSponsorActivity, Long> {
	
	@Autowired
    private UserSponsorActivityService userSponsorActivityService;
	
	@Override
	public CrudService<UIUserSponsorActivity, EOUserSponsorActivity, Long> getService() {
		return userSponsorActivityService;
	}
	
}
