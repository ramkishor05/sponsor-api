package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.entities.EOUserFinancialAccount;
import org.sponsor.account.entities.EOUserFinancialBankAccount;
import org.sponsor.account.exceptions.InvalidParamException;
import org.sponsor.account.mapper.UserFinancialBankAccountMapper;
import org.sponsor.account.model.UIUserFinancialBankAccount;
import org.sponsor.account.repository.UserFinancialAccountRepository;
import org.sponsor.account.repository.UserFinancialBankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFinancialBankAccountServiceImpl extends CrudServiceImpl<UIUserFinancialBankAccount, EOUserFinancialBankAccount, Long> implements UserFinancialBankAccountService {

	@Autowired
	private UserFinancialBankAccountRepository userFinancialBankAccountRepository;
	
	@Autowired
	private UserFinancialBankAccountMapper userFinancialBankAccountMapper;
	
	@Autowired
	private UserFinancialAccountRepository userFinancialAccountRepository;
	
	@Override
	public JpaRepository<EOUserFinancialBankAccount, Long> getRepository() {
		return userFinancialBankAccountRepository;
	}

	@Override
	public GenericMapper<EOUserFinancialBankAccount, UIUserFinancialBankAccount> getMapper() {
		return userFinancialBankAccountMapper;
	}

	@Override
	public void preAdd(UIUserFinancialBankAccount data, EOUserFinancialBankAccount entity) {
		EOUserFinancialAccount userFinancialAccount = userFinancialAccountRepository.findById(data.getUserFinancialAccountId()).orElseThrow(()-> new InvalidParamException());
		entity.setUserFinancialAccount(userFinancialAccount);
	}
	
	@Override
	public void preUpdate(UIUserFinancialBankAccount data, EOUserFinancialBankAccount entity) {
		EOUserFinancialAccount userFinancialAccount = userFinancialAccountRepository.findById(data.getUserFinancialAccountId()).orElseThrow(()-> new InvalidParamException());
		entity.setUserFinancialAccount(userFinancialAccount);
	}
	
	@Override
	public void postFetch(EOUserFinancialBankAccount findObject, UIUserFinancialBankAccount dtoObject) {
		dtoObject.setUserFinancialAccountId(findObject.getUserFinancialAccount().getId());
	}
}
