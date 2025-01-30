package org.sponsor.account.service;

import java.util.List;
import java.util.Map;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserFinancialAccount;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.model.UIUserFinancialAccount;

public interface UserFinancialAccountService extends CrudService<UIUserFinancialAccount, EOUserFinancialAccount, Long>{

	EOUserFinancialAccount addCredit(double d, EOUserSponsor sponsorLeader);
	
	EOUserFinancialAccount addDebit(double d, EOUserSponsor sponsorLeader);

	EOUserFinancialAccount getUserFinancialAccount(EOUserSponsor sponsorLeader);
	
	UIUserFinancialAccount getUserFinancialAccountModel(EOUserSponsor sponsorLeader);

	UIUserFinancialAccount fetchFinancialCurrent(Map<String, List<String>> headers);

	EOUserFinancialAccount addCreditSponsorIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialAccount addDebitSponsorIncome(Double amount, EOUserSponsor sponsorLeader);

	EOUserFinancialAccount addCreditLevelIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialAccount addDebitLevelIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialAccount addCreditBoostIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialAccount addDebitBoostIncome(Double amount, EOUserSponsor sponsorLeader);

}
