package org.sponsor.account.service;

import java.util.List;
import java.util.Map;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserFinancialWallet;
import org.sponsor.account.model.UIUserFinancialWallet;

public interface UserFinancialWalletService extends CrudService<UIUserFinancialWallet, EOUserFinancialWallet, Long>{

	EOUserFinancialWallet addCredit(double d, EOUserSponsor sponsorLeader);
	
	EOUserFinancialWallet addDebit(double d, EOUserSponsor sponsorLeader);

	EOUserFinancialWallet getUserFinancialWallet(EOUserSponsor sponsorLeader);
	
	UIUserFinancialWallet getUserFinancialWalletModel(EOUserSponsor sponsorLeader);

	UIUserFinancialWallet fetchCurrent(Map<String, List<String>> headers);

	EOUserFinancialWallet addCreditSponsorIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialWallet addDebitSponsorIncome(Double amount, EOUserSponsor sponsorLeader);

	EOUserFinancialWallet addCreditLevelIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialWallet addDebitLevelIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialWallet addCreditBoostIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialWallet addDebitBoostIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialWallet addCreditRoyaltyIncome(Double amount, EOUserSponsor sponsorLeader);
	
	EOUserFinancialWallet addDebitRoyaltyIncome(Double amount, EOUserSponsor sponsorLeader);
}
