package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserFinancialBankAccount;
import org.sponsor.account.model.UIUserFinancialBankAccount;

public interface UserFinancialBankAccountService extends CrudService<UIUserFinancialBankAccount, EOUserFinancialBankAccount, Long>{

}
