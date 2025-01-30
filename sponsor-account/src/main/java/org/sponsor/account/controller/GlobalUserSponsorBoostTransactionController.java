package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserSponsorBoostTransaction;
import org.sponsor.account.model.UIUserSponsorBoostTransaction;
import org.sponsor.account.service.UserSponsorBoostTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/user/sponsor/boost")
@CrossOrigin("*")
public class GlobalUserSponsorBoostTransactionController implements CrudController<UIUserSponsorBoostTransaction, EOUserSponsorBoostTransaction, Long> {

	@Autowired
	private UserSponsorBoostTransactionService userSponsorBoostTransactionService;
	
	@Override
	public CrudService<UIUserSponsorBoostTransaction, EOUserSponsorBoostTransaction, Long> getService() {
		return userSponsorBoostTransactionService;
	}

	
}
