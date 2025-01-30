package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.entities.EOUserFinancialAccount;
import org.sponsor.account.entities.EOUserFinancialBankUpi;
import org.sponsor.account.exceptions.InvalidParamException;
import org.sponsor.account.mapper.UserFinancialBankUpiMapper;
import org.sponsor.account.model.UIUserFinancialBankUpi;
import org.sponsor.account.repository.UserFinancialAccountRepository;
import org.sponsor.account.repository.UserFinancialBankUpiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFinancialBankUpiServiceImpl extends CrudServiceImpl<UIUserFinancialBankUpi, EOUserFinancialBankUpi, Long> implements UserFinancialBankUpiService {

	@Autowired
	private UserFinancialBankUpiRepository userFinancialBankUpiRepository;
	
	@Autowired
	private UserFinancialBankUpiMapper userFinancialBankUpiMapper;
	
	@Autowired
	private UserFinancialAccountRepository userFinancialAccountRepository;
	
	@Override
	public JpaRepository<EOUserFinancialBankUpi, Long> getRepository() {
		return userFinancialBankUpiRepository;
	}

	@Override
	public GenericMapper<EOUserFinancialBankUpi, UIUserFinancialBankUpi> getMapper() {
		return userFinancialBankUpiMapper;
	}

	@Override
	public void preAdd(UIUserFinancialBankUpi data, EOUserFinancialBankUpi entity) {
		EOUserFinancialAccount userFinancialAccount = userFinancialAccountRepository.findById(data.getUserFinancialAccountId()).orElseThrow(()-> new InvalidParamException());
		entity.setUserFinancialAccount(userFinancialAccount);
	}
	
	@Override
	public void preUpdate(UIUserFinancialBankUpi data, EOUserFinancialBankUpi entity) {
		EOUserFinancialAccount userFinancialAccount = userFinancialAccountRepository.findById(data.getUserFinancialAccountId()).orElseThrow(()-> new InvalidParamException());
		entity.setUserFinancialAccount(userFinancialAccount);
	}
	
	@Override
	public void postFetch(EOUserFinancialBankUpi findObject, UIUserFinancialBankUpi dtoObject) {
		dtoObject.setUserFinancialAccountId(findObject.getUserFinancialAccount().getId());
	}
}
