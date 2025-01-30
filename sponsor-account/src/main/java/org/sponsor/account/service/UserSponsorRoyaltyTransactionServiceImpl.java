package org.sponsor.account.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserSponsorRoyaltyTransaction;
import org.sponsor.account.mapper.UserSponsorRoyaltyTransactionMapper;
import org.sponsor.account.model.UIUserSponsorRoyaltyTransaction;
import org.sponsor.account.repository.UserSponsorRoyaltyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class UserSponsorRoyaltyTransactionServiceImpl extends CrudServiceImpl<UIUserSponsorRoyaltyTransaction, EOUserSponsorRoyaltyTransaction, Long>  implements UserSponsorRoyaltyTransactionService{

	@Autowired
	private UserSponsorRoyaltyTransactionRepository userSponsorRoyaltyTransactionRepository;
	
	@Autowired
	private UserSponsorRoyaltyTransactionMapper userSponsorRoyaltyTransactionMapper;
	
	@Autowired
	private UserFinancialWalletTransactionService userFinancialWalletTransactionService;
	
	@Autowired
	private UserFinancialWalletService userFinancialWalletService;
	
	@Autowired
	private BusinessFinancialWalletTransactionService businessFinancialWalletTransactionService;
	
	@Override
	public JpaRepository<EOUserSponsorRoyaltyTransaction, Long> getRepository() {
		return userSponsorRoyaltyTransactionRepository;
	}

	@Override
	public GenericMapper<EOUserSponsorRoyaltyTransaction, UIUserSponsorRoyaltyTransaction> getMapper() {
		return userSponsorRoyaltyTransactionMapper;
	}
	
	@Override
	public EOUserSponsorRoyaltyTransaction creditRoyalty(double amount,int year, int month, Date date, EOUserSponsor userSponsor) {
		Optional<EOUserSponsorRoyaltyTransaction> findRoyaltyTransaction = userSponsorRoyaltyTransactionRepository.findOneByUserSponsorIdAndYearAndMonth(userSponsor.getId(), year, month);
		if(findRoyaltyTransaction.isPresent()) {
			return findRoyaltyTransaction.get();
		}
		businessFinancialWalletTransactionService.addDebit(amount, userSponsor.getSponsorBussiness(), "", "Royalty income of sponsor '"+userSponsor.getSponsorId()+"' for month '"+month+"', year '"+month+"'");
		EOUserSponsorRoyaltyTransaction eoUserSponsorRoyaltyTransaction = new EOUserSponsorRoyaltyTransaction();
		eoUserSponsorRoyaltyTransaction.setMonth(month);
		eoUserSponsorRoyaltyTransaction.setYear(year);
		eoUserSponsorRoyaltyTransaction.setTrsDate(date);
		eoUserSponsorRoyaltyTransaction.setUserSponsor(userSponsor);
		eoUserSponsorRoyaltyTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
		eoUserSponsorRoyaltyTransaction.setUserWalletTransaction(userFinancialWalletTransactionService.addCredit(amount, userSponsor, "", "Royalty income of sponsor '"+userSponsor.getSponsorId()+"' for month '"+month+"', year '"+month+"'"));
		eoUserSponsorRoyaltyTransaction=userSponsorRoyaltyTransactionRepository.saveAndFlush(eoUserSponsorRoyaltyTransaction);
		
		userFinancialWalletService.addCreditSponsorIncome(amount, userSponsor);
		
		return eoUserSponsorRoyaltyTransaction;
	}
 
	@Override
	public List<EOUserSponsorRoyaltyTransaction> repositoryFindAll(Map<String, List<String>> headers, Map<String, Object> filters) {
		Long sponsorId = getSponsorId(headers);
		if(sponsorId!=null && !sponsorId.equals(0l)) {
			return  findAllByCurrentSponsorId(sponsorId);
		} else {
			Long userId = Long.valueOf(ApiTokenContext.getContext().getUserId());
			return findAllByCurrentUserId(userId);
		}
	}

	private List<EOUserSponsorRoyaltyTransaction> findAllByCurrentUserId(Long userId) {
		return userSponsorRoyaltyTransactionRepository.findAllByAccountId(userId);
	}

	private List<EOUserSponsorRoyaltyTransaction> findAllByCurrentSponsorId(Long sponsorId) {
		return userSponsorRoyaltyTransactionRepository.findAllBySponsorId(sponsorId);
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

}


