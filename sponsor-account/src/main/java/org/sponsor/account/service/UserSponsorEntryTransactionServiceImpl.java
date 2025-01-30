package org.sponsor.account.service;

import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOBusinessSponsorEntryTransaction;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.entities.EOUserSponsorEntryTransaction;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.repository.UserSponsorEntryTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSponsorEntryTransactionServiceImpl implements UserSponsorEntryTransactionService {


	private static final String BUSSINESS_PRODUCT_PURCHASE_LABEL = "Product purchase";

	private static final String BUSSINESS_REGISTRATION_LABEL = "Registration amount";

	private static final double BUSSINESS_PRODUCT_AMOUNT = 300d;

	private static final double BUSSINESS_AMOUNT_LINKED = 700d;

	private static final double BUSSINESS_AMOUNT_FEES = 10d;

	private static final double BUSSINESS_REGISTRATION_AMOUNT = BUSSINESS_AMOUNT_LINKED + BUSSINESS_PRODUCT_AMOUNT
			+ BUSSINESS_AMOUNT_FEES;

	public static double percentage(Double perAmount, Double realAmount) {
		return ((perAmount / 100D) * realAmount);
	}
	
	@Autowired
	private BusinessSponsorEntryTransactionService bussinessSponsorEntryTransactionService;
	
	@Autowired
	private UserSponsorEntryTransactionRepository userSponsorEntryTransactionRepository;

	@Autowired
	private UserFinancialWalletTransactionService userWalletTransactionService;

	@Override
	public void addUserSponsorEntryTransaction(EOUserSponsor sponsorLink, String utrNumber, String receipt) {
		EOBusinessSponsor sponsorBussiness = sponsorLink.getSponsorBussiness();
		
		EOUserFinancialWalletTransaction userEntryAmount = userWalletTransactionService.addCredit(
				BUSSINESS_REGISTRATION_AMOUNT, sponsorLink, utrNumber,
				BUSSINESS_REGISTRATION_LABEL + " of sponsor '" + sponsorLink.getSponsorId() + "'");

		EOUserFinancialWalletTransaction userSponsorLink = userWalletTransactionService.addDebit(
				BUSSINESS_AMOUNT_LINKED, sponsorLink, utrNumber,
				BUSSINESS_REGISTRATION_LABEL + " of sponsor '" + sponsorLink.getSponsorId() + "' for add");

		EOUserFinancialWalletTransaction userSponsorProduct = userWalletTransactionService.addDebit(
				BUSSINESS_PRODUCT_AMOUNT, sponsorLink, utrNumber,
				BUSSINESS_PRODUCT_PURCHASE_LABEL + " of sponsor '" + sponsorLink.getSponsorId() + "' for add");
		
		EOUserFinancialWalletTransaction transactionFees = userWalletTransactionService.feesDebit(BUSSINESS_REGISTRATION_AMOUNT, userEntryAmount, sponsorLink, utrNumber, TRANSACTION_FEES);
		
		EOBusinessSponsorEntryTransaction businessEntryAmount = bussinessSponsorEntryTransactionService.addBussinessSponsorEntryTransaction(sponsorBussiness, sponsorLink, utrNumber);
		
		EOUserSponsorEntryTransaction userSponsorEntryTransaction=new EOUserSponsorEntryTransaction();

		userSponsorEntryTransaction.setUserSponsor(sponsorLink);
		
		userSponsorEntryTransaction.setUserEntryAmount(userEntryAmount);
		
		userSponsorEntryTransaction.setUserSponsorAmount(userSponsorLink);
		
		userSponsorEntryTransaction.setUserProductAmount(userSponsorProduct);
		
		userSponsorEntryTransaction.setUserTransactionFees(transactionFees);
		
		userSponsorEntryTransaction.setBusinessEntryAmount(businessEntryAmount);
		
		userSponsorEntryTransactionRepository.saveAndFlush(userSponsorEntryTransaction);
	}
	
}
