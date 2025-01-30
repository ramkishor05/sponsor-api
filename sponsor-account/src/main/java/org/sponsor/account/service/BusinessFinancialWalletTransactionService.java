package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOBusinessFinancialWalletTransaction;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.model.UIBusinessFinancialWalletTransaction;

public interface BusinessFinancialWalletTransactionService extends CrudService<UIBusinessFinancialWalletTransaction, EOBusinessFinancialWalletTransaction, Long>, TransactionService{

	EOBusinessFinancialWalletTransaction addCredit(Double amount, EOBusinessSponsor sponsorLeader, String utrNumber, String remarks);
	
	EOBusinessFinancialWalletTransaction addDebit(Double amount, EOBusinessSponsor sponsorLeader, String utrNumber, String remarks);

	EOBusinessFinancialWalletTransaction feesCredit(Double amount, EOUserFinancialWalletTransaction transactionAmount,
			EOBusinessSponsor sponsorLeader, String utrNumber, String remarks);

}
