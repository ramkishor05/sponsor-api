package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.entities.EOBusinessFinancialAccount;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.mapper.BusinessFinancialAccountMapper;
import org.sponsor.account.model.UIBusinessFinancialAccount;
import org.sponsor.account.repository.BusinessFinancialAccountRepository;
import org.sponsor.account.repository.BusinessSponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessFinancialAccountServiceImpl extends CrudServiceImpl<UIBusinessFinancialAccount, EOBusinessFinancialAccount, Long> implements BusinessFinancialAccountService {

	@Autowired
	private BusinessFinancialAccountMapper businessFinancialAccountMapper;
	
	@Autowired
	private BusinessFinancialAccountRepository businessFinancialAccountRepository;
	
	@Autowired
	private BusinessSponsorRepository bussinessSponsorRepository;
	
	@Override
	public JpaRepository<EOBusinessFinancialAccount, Long> getRepository() {
		return businessFinancialAccountRepository;
	}

	@Override
	public GenericMapper<EOBusinessFinancialAccount, UIBusinessFinancialAccount> getMapper() {
		return businessFinancialAccountMapper;
	}

	@Override
	public EOBusinessFinancialAccount addCredit(double amount, EOBusinessSponsor sponsorLeader) {
		EOBusinessFinancialAccount eoBussinessAccount=getBussinessAccount(sponsorLeader);
		eoBussinessAccount.setBalance(eoBussinessAccount.getBalance()+amount);
	    return businessFinancialAccountRepository.saveAndFlush(eoBussinessAccount);
	}

	@Override
	public EOBusinessFinancialAccount getBussinessAccount(EOBusinessSponsor sponsorLeader) {
		return businessFinancialAccountRepository.findByBussinessSponsorId(sponsorLeader.getId()).orElseGet(()->{
			EOBusinessFinancialAccount userAccount=new EOBusinessFinancialAccount();
			userAccount.setBussinessSponsor(sponsorLeader);
			userAccount.setRecordState(RecordStatus.ACTIVETED.getStatus());
			return userAccount;
		});
	}
	
	@Override
	public UIBusinessFinancialAccount getBussinessAccountModel(EOBusinessSponsor sponsorLeader) {
		return getMapper().mapToDTO(getBussinessAccount(sponsorLeader));
	}
	
	@Override
	public EOBusinessFinancialAccount addDebit(double amount, EOBusinessSponsor sponsorLeader) {
		EOBusinessFinancialAccount eoBussinessAccount=getBussinessAccount(sponsorLeader);
		eoBussinessAccount.setBalance(eoBussinessAccount.getBalance()-amount);
	    return businessFinancialAccountRepository.saveAndFlush(eoBussinessAccount);
	}

	@Override
	public UIBusinessFinancialAccount fetchCurrent() {
		Long userId = Long.valueOf(ApiTokenContext.getContext().getUserId());
		EOBusinessSponsor eoBussinessSponsor = bussinessSponsorRepository.findOneByUserId(userId);
		if(eoBussinessSponsor==null) {
			return null;
		}
		return getMapper().mapToDTO(getBussinessAccount(eoBussinessSponsor));
	}
	
}
