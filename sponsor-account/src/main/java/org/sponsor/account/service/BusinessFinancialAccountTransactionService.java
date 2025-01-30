package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOBusinessFinancialAccountTransaction;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.model.UIBusinessFinancialAccountTransaction;

public interface BusinessFinancialAccountTransactionService extends CrudService<UIBusinessFinancialAccountTransaction, EOBusinessFinancialAccountTransaction, Long> , TransactionService{

	EOBusinessFinancialAccountTransaction addCredit(double amount, EOBusinessSponsor sponsorLeader, String utrNumber, String remarks);
	
	EOBusinessFinancialAccountTransaction addDebit(double amount, EOBusinessSponsor sponsorLeader, String utrNumber, String remarks);

}
