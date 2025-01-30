package org.sponsor.account.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserSponsorLevelTransaction;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.repository.UserSponsorLevelTransactionRepository;
import org.sponsor.account.repository.UserSponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSponsorLevelTransactionServiceImpl implements UserSponsorLevelTransactionService {

	private static final String LEVEL_INCOME = "Level income";
	
	@Autowired
	private BusinessFinancialWalletTransactionService businessFinancialWalletTransactionService;

	@Autowired
	private UserFinancialWalletTransactionService userFinancialWalletTransactionService;
	
	@Autowired
	private UserFinancialWalletService userFinancialWalletService;
	
	@Autowired
	private UserSponsorRepository userSponsorRepository;

	@Autowired
	private UserSponsorLevelTransactionRepository userSponsorLevelTransactionRepository;
	
	private static final Map<Long, Double> levelIncomeMap = new HashMap<>()

	{
		private static final long serialVersionUID = 1L;

		{
			put(1l, 20d);
			put(2l, 40d);
			put(3l, 80d);
			put(4l, 160d);
			put(5l, 320d);
			put(6l, 640d);
			put(7l, 1280d);
			put(8l, 2560d);
			put(9l, 5120d);
			put(10l, 10240d);
		}
	};
	
	@Override
	public void fillLevel(EOUserSponsor sponsorLeader) {
		if (sponsorLeader == null) {
			return;
		}
		Long countSponsors = userSponsorRepository.countSponsors(sponsorLeader.getSponsorId(), sponsorLeader.getLevel());
		Long level = countSponsors != null && countSponsors != 0 && countSponsors >= 2 ? sponsorLeader.getLevel() + 1l : sponsorLeader.getLevel();
		sponsorLeader.setLevel(level);
		sponsorLeader = userSponsorRepository.saveAndFlush(sponsorLeader);
		addUserSponsorLevelTransaction(sponsorLeader, level);
		fillLevel(sponsorLeader.getSponsorLeader());
	}

	private void addUserSponsorLevelTransaction(EOUserSponsor sponsorLeader, Long level) {
		Optional<EOUserSponsorLevelTransaction> find = userSponsorLevelTransactionRepository.findByUserSponsorIdAndLevel(sponsorLeader.getId(), level);
		if (find.isPresent() || level == 0l) {
			return;
		}
		Double amount = levelIncomeMap.get(level);
		addLevelIncome(sponsorLeader, level, amount);
	}

	@Override
	public void addLevelIncome(EOUserSponsor sponsorLeader, Long level, Double amount) {
		addBussinessSponsorLevelTransaction(sponsorLeader.getSponsorBussiness(), level, amount);

		EOUserFinancialWalletTransaction amountTransaction = userFinancialWalletTransactionService.addCredit(amount,
				sponsorLeader, "", LEVEL_INCOME + " for complete the level: " + level);
		
		userFinancialWalletTransactionService.feesDebit(amount, amountTransaction, sponsorLeader, null, TRANSACTION_FEES);
		
		businessFinancialWalletTransactionService.feesCredit(amount, amountTransaction, sponsorLeader.getSponsorBussiness(), null, TRANSACTION_FEES);
		
		EOUserSponsorLevelTransaction eoUserLevelTransaction = new EOUserSponsorLevelTransaction();
		eoUserLevelTransaction.setUserSponsor(sponsorLeader);
		eoUserLevelTransaction.setLevel(level);
		eoUserLevelTransaction.setUserTransaction(amountTransaction);
		eoUserLevelTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
		eoUserLevelTransaction = userSponsorLevelTransactionRepository.saveAndFlush(eoUserLevelTransaction);
	 
		userFinancialWalletService.addCreditLevelIncome(amount, sponsorLeader);
	}

	private void addBussinessSponsorLevelTransaction(EOBusinessSponsor sponsorLeader, Long level, Double amount) {
		businessFinancialWalletTransactionService.addDebit(amount, sponsorLeader, "",
				LEVEL_INCOME + " of sponsor '" + sponsorLeader.getSponsorId() + "' for complete the level : " + level);
	}

	@Override
	public Double totalLevelIncome(Long id) {
		return userSponsorLevelTransactionRepository.totalLevelIncome(id);
	}

}
