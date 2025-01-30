package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOBusinessFinancialWallet;
import org.sponsor.account.model.UIBusinessFinancialWallet;

public interface BusinessFinancialWalletService extends CrudService<UIBusinessFinancialWallet, EOBusinessFinancialWallet, Long>{

	EOBusinessFinancialWallet addCredit(double amount, EOBusinessSponsor sponsorLeader);

	EOBusinessFinancialWallet addDebit(double amount, EOBusinessSponsor sponsorLeader);

	EOBusinessFinancialWallet getBussinessWallet(EOBusinessSponsor sponsorLeader);

	UIBusinessFinancialWallet getBussinessWalletModel(EOBusinessSponsor sponsorLeader);

	UIBusinessFinancialWallet fetchCurrent();

}
