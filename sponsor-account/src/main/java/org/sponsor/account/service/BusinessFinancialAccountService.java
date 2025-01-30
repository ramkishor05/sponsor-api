package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOBusinessFinancialAccount;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.model.UIBusinessFinancialAccount;

public interface BusinessFinancialAccountService extends CrudService<UIBusinessFinancialAccount, EOBusinessFinancialAccount, Long>{

	EOBusinessFinancialAccount addCredit(double amount, EOBusinessSponsor sponsorLeader);

	EOBusinessFinancialAccount addDebit(double amount, EOBusinessSponsor sponsorLeader);

	EOBusinessFinancialAccount getBussinessAccount(EOBusinessSponsor sponsorLeader);

	UIBusinessFinancialAccount getBussinessAccountModel(EOBusinessSponsor sponsorLeader);

	UIBusinessFinancialAccount fetchCurrent();

}
