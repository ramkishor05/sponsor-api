package org.sponsor.account.service;

import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.entities.EOBusinessFinancialWalletTransaction;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserSponsorLinkTransaction;
import org.sponsor.account.model.UIUserSponsorModel;
import org.sponsor.account.repository.UserSponsorLinkTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSponsorLinkTransactionServiceImpl implements UserSponsorLinkTransactionService {

	private static final String SPONSOR_INCOME_LABEL = "Sponsor income";

	private static final double USER_AMOUNT_LINKED = 700d;

	public static double percentage(Double perAmount, Double realAmount) {
		return ((perAmount / 100D) * realAmount);
	}
	
	@Autowired
	private BusinessFinancialWalletTransactionService businessFinancialWalletTransactionService;

	@Autowired
	private UserSponsorLinkTransactionRepository userSponsorLinkTransactionRepository;

	@Autowired
	private UserFinancialWalletTransactionService userFinancialWalletTransactionService;
	
	@Autowired
	private UserFinancialWalletService userFinancialWalletService;
	
	@Override
	public void addUserSponsorLinkTransaction(EOUserSponsor entity, String utrNumber, String receipt) {
		addUserSponsorLinkTransaction(entity.getSponsorLeader(), entity, utrNumber);
	}

	private void addUserSponsorLinkTransaction(EOUserSponsor sponsorLeader, EOUserSponsor sponsorLink,
			String utrNumber) {
		EOBusinessSponsor sponsorBussiness = sponsorLink.getSponsorBussiness();
		
		addUserSponsorLinkTransaction(sponsorLeader, sponsorLink, utrNumber, sponsorBussiness, SponsorStep.Direct, percentage(20D, USER_AMOUNT_LINKED));
		
		if(sponsorLeader.getSponsorLeader()!=null) {
		   addUserSponsorLinkTransaction(sponsorLeader.getSponsorLeader(), sponsorLink, utrNumber, sponsorBussiness, SponsorStep.Leadership, percentage(10D, USER_AMOUNT_LINKED));
		
		   if(sponsorLeader.getSponsorLeader().getSponsorLeader()!=null) {
			 addUserSponsorLinkTransaction(sponsorLeader.getSponsorLeader().getSponsorLeader(), sponsorLink, utrNumber, sponsorBussiness, SponsorStep.Mangement, percentage(5D, USER_AMOUNT_LINKED));
		   }
		}
	}
	
	enum SponsorStep{
		Direct, Leadership, Mangement;
	}

	private EOUserSponsorLinkTransaction addUserSponsorLinkTransaction(EOUserSponsor sponsorLeader,
			EOUserSponsor sponsorLink, String utrNumber, EOBusinessSponsor sponsorBussiness, SponsorStep step, Double amount ) {
		EOBusinessFinancialWalletTransaction businessSponsorLinkTransaction = businessFinancialWalletTransactionService.addDebit(
				amount, sponsorBussiness, utrNumber,
				SPONSOR_INCOME_LABEL + " of sponsor '" + sponsorLink.getSponsorId() + "' for "+step+" link");
		
		EOUserFinancialWalletTransaction userSponsorLinkTransaction = userFinancialWalletTransactionService.addCredit(
				amount, sponsorLeader, utrNumber,
				SPONSOR_INCOME_LABEL + " of sponsor '" + sponsorLink.getSponsorId() + "' for "+step+" link");
		
		userFinancialWalletTransactionService.feesDebit(amount, userSponsorLinkTransaction, sponsorLeader, utrNumber, TRANSACTION_FEES);
		
		businessFinancialWalletTransactionService.feesCredit(amount, userSponsorLinkTransaction, sponsorBussiness, utrNumber, TRANSACTION_FEES);
		
		EOUserSponsorLinkTransaction userSponsorTransaction = new EOUserSponsorLinkTransaction();
		userSponsorTransaction.setUserSponsor(sponsorLeader);
		userSponsorTransaction.setLinkSponsor(sponsorLink);
		userSponsorTransaction.setBusinessSponsorIncome(businessSponsorLinkTransaction);
		userSponsorTransaction.setUserSponsorIncome(userSponsorLinkTransaction);
		userSponsorTransaction.setStep(step.toString());
		userSponsorTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
		userSponsorTransaction=userSponsorLinkTransactionRepository.saveAndFlush(userSponsorTransaction);
		
		userFinancialWalletService.addCreditSponsorIncome(amount, sponsorLeader);
		
		return userSponsorTransaction;
	}

	@Override
	public void fillTransactionDetail(Long id, UIUserSponsorModel dtoObject) {
		userSponsorLinkTransactionRepository.findByUserSponsorId(id).ifPresent(userSponsorLinkTransactionList -> {
			userSponsorLinkTransactionList.forEach(userSponsorLinkTransaction -> {
				dtoObject.setUtrNumber(userSponsorLinkTransaction.getUserSponsorIncome().getUtrNumber());
			});
		});
	}

	
}
