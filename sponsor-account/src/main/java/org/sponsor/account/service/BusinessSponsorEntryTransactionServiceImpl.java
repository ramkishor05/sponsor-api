package org.sponsor.account.service;

import java.util.Optional;

import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.entities.EOBusinessFinancialAccountTransaction;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOBusinessSponsorEntryTransaction;
import org.sponsor.account.entities.EOBusinessFinancialWalletTransaction;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.repository.BusinessSponsorEntryTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessSponsorEntryTransactionServiceImpl implements BusinessSponsorEntryTransactionService {


	private static final String BUSSINESS_PRODUCT_PURCHASE_LABEL = "Product purchase";

	private static final String BUSSINESS_REGISTRATION_LABEL = "Registration amount";

	private static final double BUSSINESS_PRODUCT_AMOUNT = 300d;

	private static final double BUSSINESS_AMOUNT_LINKED = 700d;

	private static final double BUSSINESS_AMOUNT_FEES = 10d;

	private static final double BUSSINESS_TRANSACTION_AMOUNT = BUSSINESS_AMOUNT_LINKED + BUSSINESS_PRODUCT_AMOUNT
			+ BUSSINESS_AMOUNT_FEES;
	
	@Autowired
	private BusinessFinancialAccountTransactionService bussinessAccountTransactionService;

	@Autowired
	private BusinessSponsorEntryTransactionRepository businessSponsorEntryTransactionRepository;

	@Autowired
	private BusinessFinancialWalletTransactionService bussinessWalletTransactionService;
	
	public EOBusinessSponsorEntryTransaction addBussinessSponsorEntryTransaction(EOBusinessSponsor sponsorLeader, EOUserSponsor sponsorLink,
			String utrNumber) {
		Optional<EOBusinessSponsorEntryTransaction> find = businessSponsorEntryTransactionRepository.findByUserSponsorIdAndSponsorLinkId(sponsorLeader.getId(), sponsorLink.getId());
		EOBusinessSponsorEntryTransaction eoUserSponsorTransaction = find.orElseGet(() -> {
			
			EOBusinessFinancialAccountTransaction eoBussinessAccountAmount = bussinessAccountTransactionService.addCredit(
					BUSSINESS_TRANSACTION_AMOUNT, sponsorLeader, utrNumber,
					BUSSINESS_REGISTRATION_LABEL + " of sponsor '" + sponsorLink.getSponsorId() + "'");

			EOBusinessFinancialWalletTransaction businessSponsorLink = bussinessWalletTransactionService.addCredit(
					BUSSINESS_AMOUNT_LINKED, sponsorLeader, utrNumber,
					BUSSINESS_REGISTRATION_LABEL + " of sponsor '" + sponsorLink.getSponsorId() + "' for add");

			EOBusinessFinancialWalletTransaction businessSponsorProduct = bussinessWalletTransactionService.addCredit(
					BUSSINESS_PRODUCT_AMOUNT, sponsorLeader, utrNumber,
					BUSSINESS_PRODUCT_PURCHASE_LABEL + " of sponsor '" + sponsorLink.getSponsorId() + "' for add");
			
			EOBusinessFinancialWalletTransaction feesCredit = bussinessWalletTransactionService.feesCredit(BUSSINESS_TRANSACTION_AMOUNT, null, sponsorLeader, utrNumber, TRANSACTION_FEES);
			
			EOBusinessSponsorEntryTransaction userSponsorTransaction = new EOBusinessSponsorEntryTransaction();
			userSponsorTransaction.setBussinessSponsor(sponsorLeader);
			userSponsorTransaction.setLinkSponsor(sponsorLink);
			userSponsorTransaction.setBusinessAccountAmount(eoBussinessAccountAmount);
			userSponsorTransaction.setBusinessSponsorAmount(businessSponsorLink);
			userSponsorTransaction.setBussinessProductAmount(businessSponsorProduct);
			userSponsorTransaction.setBussinessTransactionFees(feesCredit);
			userSponsorTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
			return userSponsorTransaction;
		});

		return businessSponsorEntryTransactionRepository.saveAndFlush(eoUserSponsorTransaction);
	}

}
