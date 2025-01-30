package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserSponsorRoyaltyTransaction;
import org.sponsor.account.model.UIUserSponsorRoyaltyTransaction;
import org.sponsor.account.service.UserSponsorRoyaltyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/user/sponsor/royalty")
@CrossOrigin("*")
public class GlobalUserSponsorRoyaltyTransactionController implements CrudController<UIUserSponsorRoyaltyTransaction, EOUserSponsorRoyaltyTransaction, Long> {

	@Autowired
	private UserSponsorRoyaltyTransactionService userSponsorRoyaltyTransactionService;
	
	@Override
	public CrudService<UIUserSponsorRoyaltyTransaction, EOUserSponsorRoyaltyTransaction, Long> getService() {
		return userSponsorRoyaltyTransactionService;
	}
	
}
