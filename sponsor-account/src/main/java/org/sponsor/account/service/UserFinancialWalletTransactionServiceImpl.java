package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.constants.TransactionType;
import org.sponsor.account.entities.EOUserFinancialWallet;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.entities.EOUserSponsor;
import org.sponsor.account.mapper.UserFinancialWalletTransactionMapper;
import org.sponsor.account.model.UIUserFinancialWalletTransaction;
import org.sponsor.account.repository.UserFinancialWalletRepository;
import org.sponsor.account.repository.UserFinancialWalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFinancialWalletTransactionServiceImpl extends CrudServiceImpl<UIUserFinancialWalletTransaction, EOUserFinancialWalletTransaction, Long> implements UserFinancialWalletTransactionService {

	@Autowired
	private UserFinancialWalletTransactionMapper userFinancialWalletTransactionMapper;
	
	@Autowired
	private UserFinancialWalletTransactionRepository userFinancialWalletTransactionRepository;
	
	@Autowired
	private UserFinancialWalletService userWalletService;

	@Autowired
	private UserFinancialWalletRepository userWalletRepository;

	@Override
	public JpaRepository<EOUserFinancialWalletTransaction, Long> getRepository() {
		return userFinancialWalletTransactionRepository;
	}

	@Override
	public GenericMapper<EOUserFinancialWalletTransaction, UIUserFinancialWalletTransaction> getMapper() {
		return userFinancialWalletTransactionMapper;
	}


	@Override
	public EOUserFinancialWalletTransaction feesDebit(Double amount, EOUserFinancialWalletTransaction UserWalletTransactionAmount, EOUserSponsor sponsorLeader, String utrNumber, String remarks) {
		Double finalFees = finalFees(amount);
		if(finalFees==0.0) {
			return null;
		}
		
		EOUserFinancialWalletTransaction fees = debitAmount(finalFees,sponsorLeader, utrNumber, remarks );
		
		EOUserFinancialWallet eoUserWallet=fees.getUserFinancialWallet();
		eoUserWallet.setFees(eoUserWallet.getFees()+finalFees);
		userWalletRepository.saveAndFlush(eoUserWallet);
		return fees;
	}

	@Override
	public EOUserFinancialWalletTransaction addCredit(double amount, EOUserSponsor sponsorLeader, String utrNumber, String remarks) {
		double finalAmount = amount;
		EOUserFinancialWalletTransaction creditAmount = creditAmount(finalAmount, sponsorLeader, utrNumber, remarks);
		return creditAmount;
	}

	private EOUserFinancialWalletTransaction creditAmount(double amount, EOUserSponsor sponsorLeader, String utrNumber,
			String remarks) {
		EOUserFinancialWallet eoUserWallet=userWalletService.addCredit(amount, sponsorLeader);
		EOUserFinancialWalletTransaction eoUserTransaction=new EOUserFinancialWalletTransaction();
		eoUserTransaction.setUserFinancialWallet(eoUserWallet);
	    eoUserTransaction.setAmount(amount);
	    eoUserTransaction.setUtrNumber(utrNumber);
	    eoUserTransaction.setRemarks(remarks);
	    eoUserTransaction.setType(TransactionType.CREDIT.toString());
	    eoUserTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    return userFinancialWalletTransactionRepository.saveAndFlush(eoUserTransaction);
	}

	@Override
	public EOUserFinancialWalletTransaction addDebit(double amount, EOUserSponsor sponsorLeader,  String utrNumber, String remarks) {
		double finalAmount = amount;
		EOUserFinancialWalletTransaction debitAmount = debitAmount(finalAmount, sponsorLeader,  utrNumber, remarks);
		return debitAmount;
	}

	private EOUserFinancialWalletTransaction debitAmount(double amount, EOUserSponsor sponsorLeader, String utrNumber, String remarks) {
		EOUserFinancialWallet eoUserWallet=userWalletService.addDebit(amount, sponsorLeader);
		EOUserFinancialWalletTransaction eoUserTransaction=new EOUserFinancialWalletTransaction();
		eoUserTransaction.setUserFinancialWallet(eoUserWallet);
	    eoUserTransaction.setAmount(amount);
	    eoUserTransaction.setUtrNumber(utrNumber);
	    eoUserTransaction.setRemarks(remarks);
	    eoUserTransaction.setType(TransactionType.DEBIT.toString());
	    eoUserTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
		return userFinancialWalletTransactionRepository.saveAndFlush(eoUserTransaction);
	}
}
