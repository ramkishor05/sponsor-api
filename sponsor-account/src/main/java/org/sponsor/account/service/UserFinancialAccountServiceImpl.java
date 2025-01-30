package org.sponsor.account.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.entities.EOUserFinancialAccount;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.mapper.UserFinancialAccountMapper;
import org.sponsor.account.model.UIUserFinancialAccount;
import org.sponsor.account.repository.UserFinancialAccountRepository;
import org.sponsor.account.repository.UserSponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class UserFinancialAccountServiceImpl extends CrudServiceImpl<UIUserFinancialAccount, EOUserFinancialAccount, Long> implements UserFinancialAccountService {

	@Autowired
	private UserFinancialAccountMapper userFinancialAccountMapper;
	
	@Autowired
	private UserFinancialAccountRepository userFinancialAccountRepository;
	
	@Autowired
	private UserSponsorRepository userSponsorRepository;
	
	@Override
	public JpaRepository<EOUserFinancialAccount, Long> getRepository() {
		return userFinancialAccountRepository;
	}

	@Override
	public GenericMapper<EOUserFinancialAccount, UIUserFinancialAccount> getMapper() {
		return userFinancialAccountMapper;
	}

	@Override
	public EOUserFinancialAccount addCredit(double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialAccount eoUserAccount=getUserFinancialAccount(sponsorLeader);
		eoUserAccount.setBalance(eoUserAccount.getBalance()+amount);
	    return userFinancialAccountRepository.saveAndFlush(eoUserAccount);
	}

	@Override
	public EOUserFinancialAccount getUserFinancialAccount(EOUserSponsor sponsorLeader) {
		return userFinancialAccountRepository.findByUserSponsorId(sponsorLeader.getId()).orElseGet(()->{
			EOUserFinancialAccount userAccount=new EOUserFinancialAccount();
			userAccount.setUserSponsor(sponsorLeader);
			userAccount.setRecordState(RecordStatus.ACTIVETED.getStatus());
			return userAccount;
		});
	}
	
	@Override
	public UIUserFinancialAccount getUserFinancialAccountModel(EOUserSponsor sponsorLeader) {
		EOUserFinancialAccount userAccount = getUserFinancialAccount(sponsorLeader);
		UIUserFinancialAccount dtoObject = getMapper().mapToDTO(userAccount);
		postFetch(userAccount, dtoObject);
		return dtoObject;
	}
	
	@Override
	public void postFetch(EOUserFinancialAccount findObject, UIUserFinancialAccount dtoObject) {
		dtoObject.setApplicableBoost(userSponsorRepository.countSponsors(findObject.getUserSponsor().getSponsorId())>=2 && dtoObject.getBalance()>=250 );
	}
	
	@Override
	public EOUserFinancialAccount addDebit(double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialAccount eoUserAccount=getUserFinancialAccount(sponsorLeader);
		eoUserAccount.setBalance(eoUserAccount.getBalance()-amount);
	    return userFinancialAccountRepository.saveAndFlush(eoUserAccount);
	}
	
	@Override
	public UIUserFinancialAccount fetchFinancialCurrent(Map<String, List<String>> headers) {
		EOUserSponsor eoUserSponsor = getCurrentSponsor(headers);
		if(eoUserSponsor==null) {
			return null;
		}
		return getMapper().mapToDTO(getUserFinancialAccount(eoUserSponsor));
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
	public EOUserFinancialAccount addCreditSponsorIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialAccount eoUserAccount=getUserFinancialAccount(sponsorLeader);
		eoUserAccount.setSponsorIncome(eoUserAccount.getSponsorIncome()+amount);
	    return userFinancialAccountRepository.saveAndFlush(eoUserAccount);
	}

	@Override
	public EOUserFinancialAccount addDebitSponsorIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialAccount eoUserAccount=getUserFinancialAccount(sponsorLeader);
		eoUserAccount.setSponsorIncome(eoUserAccount.getSponsorIncome()-amount);
	    return userFinancialAccountRepository.saveAndFlush(eoUserAccount);
	}

	@Override
	public EOUserFinancialAccount addCreditLevelIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialAccount eoUserAccount=getUserFinancialAccount(sponsorLeader);
		eoUserAccount.setLevelIncome(eoUserAccount.getLevelIncome()+amount);
	    return userFinancialAccountRepository.saveAndFlush(eoUserAccount);
	}

	@Override
	public EOUserFinancialAccount addDebitLevelIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialAccount eoUserAccount=getUserFinancialAccount(sponsorLeader);
		eoUserAccount.setLevelIncome(eoUserAccount.getLevelIncome()-amount);
	    return userFinancialAccountRepository.saveAndFlush(eoUserAccount);
	}

	@Override
	public EOUserFinancialAccount addCreditBoostIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialAccount eoUserAccount=getUserFinancialAccount(sponsorLeader);
		eoUserAccount.setBoostIncome(eoUserAccount.getBoostIncome()+amount);
	    return userFinancialAccountRepository.saveAndFlush(eoUserAccount);
	}

	@Override
	public EOUserFinancialAccount addDebitBoostIncome(Double amount, EOUserSponsor sponsorLeader) {
		EOUserFinancialAccount eoUserAccount=getUserFinancialAccount(sponsorLeader);
		eoUserAccount.setBoostIncome(eoUserAccount.getBoostIncome()-amount);
	    return userFinancialAccountRepository.saveAndFlush(eoUserAccount);
	}

}
