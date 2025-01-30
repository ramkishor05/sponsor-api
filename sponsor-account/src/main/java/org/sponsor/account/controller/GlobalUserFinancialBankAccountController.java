package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserFinancialBankAccount;
import org.sponsor.account.model.UIUserFinancialBankAccount;
import org.sponsor.account.service.UserFinancialBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/user/financial/bank/account")
@CrossOrigin("*")
public class GlobalUserFinancialBankAccountController implements CrudController<UIUserFinancialBankAccount, EOUserFinancialBankAccount, Long>{

	@Autowired
	private UserFinancialBankAccountService userFinancialBankAccountService;
	
	@Override
	public CrudService<UIUserFinancialBankAccount, EOUserFinancialBankAccount, Long> getService() {
		return userFinancialBankAccountService;
	}

}
