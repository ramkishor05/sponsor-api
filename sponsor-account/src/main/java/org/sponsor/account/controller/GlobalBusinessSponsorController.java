package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.model.UIBusinessSponsorModel;
import org.sponsor.account.service.BusinessSponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/business/sponsor")
@CrossOrigin("*")
public class GlobalBusinessSponsorController implements CrudController<UIBusinessSponsorModel, EOBusinessSponsor, Long> {

	@Autowired
	private BusinessSponsorService businessSponsorService;

	@Override
	public CrudService<UIBusinessSponsorModel, EOBusinessSponsor, Long> getService() {
		return businessSponsorService;
	}
	
}
