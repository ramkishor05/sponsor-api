package org.sponsor.account.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserFinancialBankUpi;
import org.sponsor.account.model.UIUserFinancialBankUpi;
import org.sponsor.account.service.UserFinancialBankUpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/user/financial/bank/upi")
@CrossOrigin("*")
public class GlobalUserFinancialBankUpiController implements CrudController<UIUserFinancialBankUpi, EOUserFinancialBankUpi, Long>{

	@Autowired
	private UserFinancialBankUpiService userFinancialBankUpiService;
	
	@Override
	public CrudService<UIUserFinancialBankUpi, EOUserFinancialBankUpi, Long> getService() {
		return userFinancialBankUpiService;
	}

}
