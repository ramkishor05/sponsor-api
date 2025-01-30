package org.sponsor.account.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserFinancialWallet;
import org.sponsor.account.mapper.UserFinancialWalletMapper;
import org.sponsor.account.model.UIUserFinancialWallet;
import org.sponsor.account.repository.UserSponsorRepository;
import org.sponsor.account.repository.UserFinancialWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class UserFinancialWalletServiceImpl extends CrudServiceImpl<UIUserFinancialWallet, EOUserFinancialWallet, Long> implements UserFinancialWalletService {

	@Autowired
	private UserFinancialWalletMapper userFinancialWalletMapper;
	
	@Autowired
	private UserFinancialWalletRepository userFinancialWalletRepository;
	
	@Autowired
	private UserSponsorRepository userSponsorRepository;
	
	@Override
	public JpaRepository<EOUserFinancialWallet, Long> getRepository() {
		return userFinancialWalletRepository;
	}

	@Override
	public GenericMapper<EOUserFinancialWallet, UIUserFinancialWallet> getMapper() {
		return userFinancialWalletMapper;
	}

	@Override
	public EOUserFinancialWallet addCredit(double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setBalance(eoUserWallet.getBalance()+amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}

	@Override
	public EOUserFinancialWallet getUserFinancialWallet(EOUserSponsor sponsorLeader) {
		return userFinancialWalletRepository.findByUserSponsorId(sponsorLeader.getId()).orElseGet(()->{
			EOUserFinancialWallet userWallet=new EOUserFinancialWallet();
			userWallet.setUserSponsor(sponsorLeader);
			userWallet.setRecordState(RecordStatus.ACTIVETED.getStatus());
			return userWallet;
		});
	}
	
	@Override
	public UIUserFinancialWallet getUserFinancialWalletModel(EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet userWallet = getUserFinancialWallet(sponsorLeader);
		UIUserFinancialWallet dtoObject = getMapper().mapToDTO(userWallet);
		postFetch(userWallet, dtoObject);
		return dtoObject;
	}
	
	@Override
	public void postFetch(EOUserFinancialWallet findObject, UIUserFinancialWallet dtoObject) {
		dtoObject.setApplicableBoost(userSponsorRepository.countSponsors(findObject.getUserSponsor().getSponsorId())>=2 && dtoObject.getBalance()>=250 );
	}
	
	@Override
	public EOUserFinancialWallet addDebit(double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setBalance(eoUserWallet.getBalance()-amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}
	
	@Override
	public UIUserFinancialWallet fetchCurrent(Map<String, List<String>> headers) {
		EOUserSponsor eoUserSponsor = getCurrentSponsor(headers);
		if(eoUserSponsor==null) {
			return null;
		}
		return getMapper().mapToDTO(getUserFinancialWallet(eoUserSponsor));
	}
	
	public EOUserSponsor getCurrentSponsor(Map<String, List<String>> headers) {
		Long sponsorId = getSponsorId(headers);
		if(sponsorId!=null && !sponsorId.equals(0l)) {
			return  userSponsorRepository.findOneBySponsorId(sponsorId);
		} else {
			Long userId = Long.valueOf(ApiTokenContext.getContext().getUserId());
			return  userSponsorRepository.findOneByUserId(userId);
		}
	}
	
	private Long getSponsorId(Map<String, List<String>> headers) {
		if(headers==null) {
			return null;
		}
		List<String> sponsorIds = headers.getOrDefault("sponsorid", Arrays.asList());
		Long sponsorId = null;
		if(!CollectionUtils.isEmpty(sponsorIds)) {
			try {
				sponsorId=Long.valueOf(sponsorIds.get(0));
			}catch (Exception e) {
			}
		}
		return sponsorId;
	}

	@Override
	public EOUserFinancialWallet addCreditSponsorIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setSponsorIncome(eoUserWallet.getSponsorIncome()+amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}

	@Override
	public EOUserFinancialWallet addDebitSponsorIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setSponsorIncome(eoUserWallet.getSponsorIncome()-amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}

	@Override
	public EOUserFinancialWallet addCreditLevelIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setLevelIncome(eoUserWallet.getLevelIncome()+amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}

	@Override
	public EOUserFinancialWallet addDebitLevelIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setLevelIncome(eoUserWallet.getLevelIncome()-amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}

	@Override
	public EOUserFinancialWallet addCreditBoostIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setBoostIncome(eoUserWallet.getBoostIncome()+amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}

	@Override
	public EOUserFinancialWallet addDebitBoostIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setBoostIncome(eoUserWallet.getBoostIncome()-amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}
	
	@Override
	public EOUserFinancialWallet addCreditRoyaltyIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setRoyaltyIncome(eoUserWallet.getRoyaltyIncome()+amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}
	
	@Override
	public EOUserFinancialWallet addDebitRoyaltyIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialWallet eoUserWallet=getUserFinancialWallet(sponsorLeader);
		eoUserWallet.setRoyaltyIncome(eoUserWallet.getRoyaltyIncome()-amount);
	    return userFinancialWalletRepository.saveAndFlush(eoUserWallet);
	}
}
