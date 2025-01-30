package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOBusinessFinancialWallet;
import org.sponsor.account.mapper.BusinessFinancialWalletMapper;
import org.sponsor.account.model.UIBusinessFinancialWallet;
import org.sponsor.account.repository.BusinessSponsorRepository;
import org.sponsor.account.repository.BusinessFinancialWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessFinancialWalletServiceImpl extends CrudServiceImpl<UIBusinessFinancialWallet, EOBusinessFinancialWallet, Long> implements BusinessFinancialWalletService {

	@Autowired
	private BusinessFinancialWalletMapper businessFinancialWalletMapper;
	
	@Autowired
	private BusinessFinancialWalletRepository businessFinancialWalletRepository;
	
	@Autowired
	private BusinessSponsorRepository bussinessSponsorRepository;
	
	@Override
	public JpaRepository<EOBusinessFinancialWallet, Long> getRepository() {
		return businessFinancialWalletRepository;
	}

	@Override
	public GenericMapper<EOBusinessFinancialWallet, UIBusinessFinancialWallet> getMapper() {
		return businessFinancialWalletMapper;
	}

	@Override
	public EOBusinessFinancialWallet addCredit(double amount, EOBusinessSponsor sponsorLeader) {
		EOBusinessFinancialWallet eoBussinessWallet=getBussinessWallet(sponsorLeader);
		eoBussinessWallet.setBalance(eoBussinessWallet.getBalance()+amount);
	    return businessFinancialWalletRepository.saveAndFlush(eoBussinessWallet);
	}

	@Override
	public EOBusinessFinancialWallet getBussinessWallet(EOBusinessSponsor sponsorLeader) {
		return businessFinancialWalletRepository.findByBussinessSponsorId(sponsorLeader.getId()).orElseGet(()->{
			EOBusinessFinancialWallet userWallet=new EOBusinessFinancialWallet();
			userWallet.setBussinessSponsor(sponsorLeader);
			userWallet.setRecordState(RecordStatus.ACTIVETED.getStatus());
			return userWallet;
		});
	}
	
	@Override
	public UIBusinessFinancialWallet getBussinessWalletModel(EOBusinessSponsor sponsorLeader) {
		return getMapper().mapToDTO(getBussinessWallet(sponsorLeader));
	}
	
	@Override
	public EOBusinessFinancialWallet addDebit(double amount, EOBusinessSponsor sponsorLeader) {
		EOBusinessFinancialWallet eoBussinessWallet=getBussinessWallet(sponsorLeader);
		eoBussinessWallet.setBalance(eoBussinessWallet.getBalance()-amount);
	    return businessFinancialWalletRepository.saveAndFlush(eoBussinessWallet);
	}

	@Override
	public UIBusinessFinancialWallet fetchCurrent() {
		Long userId = Long.valueOf(ApiTokenContext.getContext().getUserId());
		EOBusinessSponsor eoBussinessSponsor = bussinessSponsorRepository.findOneByUserId(userId);
		if(eoBussinessSponsor==null) {
			return null;
		}
		return getMapper().mapToDTO(getBussinessWallet(eoBussinessSponsor));
	}
}
