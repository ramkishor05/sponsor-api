package org.sponsor.account.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.BoostStatus;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserSponsorBoostTransaction;
import org.sponsor.account.entities.EOUserFinancialWallet;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.exceptions.BoostAlreadyExistsException;
import org.sponsor.account.exceptions.BoostNotAllowedException;
import org.sponsor.account.mapper.UserSponsorBoostTransactionMapper;
import org.sponsor.account.model.UIUserSponsorBoostTransaction;
import org.sponsor.account.repository.UserSponsorBoostTransactionRepository;
import org.sponsor.account.repository.UserSponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class UserSponsorBoostTransactionServiceImpl extends CrudServiceImpl<UIUserSponsorBoostTransaction, EOUserSponsorBoostTransaction, Long>  implements UserSponsorBoostTransactionService{

	@Autowired
	private UserSponsorBoostTransactionRepository userSponsorBoostTransactionRepository;
	
	@Autowired
	private UserSponsorBoostTransactionMapper userSponsorBoostTransactionMapper;
	
	@Autowired
	private UserFinancialWalletTransactionService userWalletTransactionService;
	
	@Autowired
	private UserFinancialWalletService userWalletService;
	
	@Autowired
	private BusinessFinancialWalletTransactionService bussinessWalletTransactionService;
	
	@Autowired
	private UserSponsorRepository userSponsorRepository;
	
	@Override
	public JpaRepository<EOUserSponsorBoostTransaction, Long> getRepository() {
		return userSponsorBoostTransactionRepository;
	}

	@Override
	public GenericMapper<EOUserSponsorBoostTransaction, UIUserSponsorBoostTransaction> getMapper() {
		return userSponsorBoostTransactionMapper;
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
 
	@Override
	public void preAdd(UIUserSponsorBoostTransaction data, EOUserSponsorBoostTransaction entity) {
		EOUserSponsor userSponsor = getCurrentSponsor(null);
		if(userSponsorBoostTransactionRepository.existsByUserSponsorIdAndStatus(userSponsor.getId(), BoostStatus.Inprocess.toString())){
			throw new BoostAlreadyExistsException();
		}
		EOUserFinancialWallet userWallet = userWalletService.getUserFinancialWallet(userSponsor);
		if(userWallet.getSponsorIncome()<250d) {
			throw new BoostNotAllowedException();
		}
		EOBusinessSponsor sponsorBussiness = userSponsor.getSponsorBussiness();
		entity.setUserSponsor(userSponsor);
		EOUserFinancialWalletTransaction investTransaction = userWalletTransactionService.addDebit(data.getInvestAmount(), userSponsor, "", "Investment amount");
		entity.setInvestTransaction(investTransaction);
		bussinessWalletTransactionService.addCredit(data.getInvestAmount(), userSponsor.getSponsorBussiness(), "", "Investment amount");
		
		userWalletTransactionService.feesDebit(data.getInvestAmount(), investTransaction, userSponsor, null, TRANSACTION_FEES);
		
		bussinessWalletTransactionService.feesCredit(data.getInvestAmount(), investTransaction, sponsorBussiness, null, TRANSACTION_FEES);
		
		entity.setStatus(BoostStatus.Inprocess.toString());
	}
	
	@Override
	public List<EOUserSponsorBoostTransaction> repositoryFindAll(Map<String, List<String>> headers, Map<String, Object> filters) {
		Long sponsorId = getSponsorId(headers);
		if(sponsorId!=null && !sponsorId.equals(0l)) {
			return  findAllByCurrentSponsorId(sponsorId);
		} else {
			Long userId = Long.valueOf(ApiTokenContext.getContext().getUserId());
			return findAllByCurrentUserId(userId);
		}
	}
	
	private List<EOUserSponsorBoostTransaction> findAllByCurrentUserId(Long userId) {
		return userSponsorBoostTransactionRepository.findAllByAccountId(userId);
	}

	private List<EOUserSponsorBoostTransaction> findAllByCurrentSponsorId(Long sponsorId) {
		return userSponsorBoostTransactionRepository.findAllBySponsorId(sponsorId);
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
	public Boolean existsByUserSponsorIdAndStatus(Long id, String status) {
		return userSponsorBoostTransactionRepository.existsByUserSponsorIdAndStatus(id, status);
	}

}


