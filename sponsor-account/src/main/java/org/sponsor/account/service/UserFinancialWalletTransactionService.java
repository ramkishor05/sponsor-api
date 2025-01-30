package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.model.UIUserFinancialWalletTransaction;

public interface UserFinancialWalletTransactionService extends CrudService<UIUserFinancialWalletTransaction, EOUserFinancialWalletTransaction, Long>, TransactionService{

	EOUserFinancialWalletTransaction addCredit(double amount, EOUserSponsor sponsorLeader, String utrNumber, String remarks);
	
	EOUserFinancialWalletTransaction addDebit(double amount, EOUserSponsor sponsorLeader, String utrNumber, String remarks);

	EOUserFinancialWalletTransaction feesDebit(Double amount, EOUserFinancialWalletTransaction UserWalletTransactionAmount, EOUserSponsor sponsorLeader,
			String utrNumber, String remarks);

}
