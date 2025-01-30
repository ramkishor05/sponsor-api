package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.constants.TransactionType;
import org.sponsor.account.entities.EOBusinessFinancialWallet;
import org.sponsor.account.entities.EOBusinessFinancialWalletTransaction;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.sponsor.account.mapper.BusinessWalletTransactionMapper;
import org.sponsor.account.model.UIBusinessFinancialWalletTransaction;
import org.sponsor.account.repository.BusinessFinancialWalletRepository;
import org.sponsor.account.repository.BusinessFinancialWalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessFinancialWalletTransactionServiceImpl extends CrudServiceImpl<UIBusinessFinancialWalletTransaction, EOBusinessFinancialWalletTransaction, Long> implements BusinessFinancialWalletTransactionService {

	@Autowired
	private BusinessWalletTransactionMapper businessFinancialWalletTransactionMapper;
	
	@Autowired
	private BusinessFinancialWalletTransactionRepository businessFinancialWalletTransactionRepository;
	
	@Autowired
	private BusinessFinancialWalletService businessFinancialWalletService;
	
	@Autowired
	private BusinessFinancialWalletRepository bussinessFinancialWalletRepository;

	@Override
	public JpaRepository<EOBusinessFinancialWalletTransaction, Long> getRepository() {
		return businessFinancialWalletTransactionRepository;
	}

	@Override
	public GenericMapper<EOBusinessFinancialWalletTransaction, UIBusinessFinancialWalletTransaction> getMapper() {
		return businessFinancialWalletTransactionMapper;
	}
	
	@Override
	public EOBusinessFinancialWalletTransaction feesCredit(Double amount, EOUserFinancialWalletTransaction transactionAmount, EOBusinessSponsor sponsorLeader, String utrNumber, String remarks) {
		Double finalFees = finalFees(amount);
		if(finalFees<=0.0) {
			return null;
		}
		EOBusinessFinancialWalletTransaction fees = creditAmount(finalFees,sponsorLeader, utrNumber, remarks );
		EOBusinessFinancialWallet eoBussinessWallet=fees.getBusinessFinancialWallet();
		eoBussinessWallet.setFees(eoBussinessWallet.getFees()+finalFees);
	    bussinessFinancialWalletRepository.saveAndFlush(eoBussinessWallet);
	    return fees;
	}

	@Override
	public EOBusinessFinancialWalletTransaction addCredit(Double amount, EOBusinessSponsor sponsorLeader, String utrNumber, String remarks) {
		double finalAmount = amount ;
		EOBusinessFinancialWalletTransaction creditAmount = creditAmount(finalAmount, sponsorLeader, utrNumber, remarks);
		return creditAmount;
	}

	private EOBusinessFinancialWalletTransaction creditAmount(double amount, EOBusinessSponsor sponsorLeader, String utrNumber,
			String remarks) {
		EOBusinessFinancialWallet eoBussinessWallet=businessFinancialWalletService.addCredit(amount, sponsorLeader);
		EOBusinessFinancialWalletTransaction eoBussinessTransaction=new EOBusinessFinancialWalletTransaction();
		eoBussinessTransaction.setBusinessFinancialWallet(eoBussinessWallet);
	    eoBussinessTransaction.setAmount(amount);
	    eoBussinessTransaction.setUtrNumber(utrNumber);
	    eoBussinessTransaction.setRemarks(remarks);
	    eoBussinessTransaction.setType(TransactionType.CREDIT.toString());
	    eoBussinessTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    return businessFinancialWalletTransactionRepository.saveAndFlush(eoBussinessTransaction);
	}

	@Override
	public EOBusinessFinancialWalletTransaction addDebit(Double amount, EOBusinessSponsor sponsorLeader,  String utrNumber, String remarks) {
		double finalAmount = amount ;
		EOBusinessFinancialWalletTransaction debitAmount = debitAmount(finalAmount, sponsorLeader,  utrNumber, remarks);
		return debitAmount;
	}

	private EOBusinessFinancialWalletTransaction debitAmount(double amount, EOBusinessSponsor sponsorLeader, String utrNumber, String remarks) {
		EOBusinessFinancialWallet eoBussinessWallet=businessFinancialWalletService.addDebit(amount, sponsorLeader);
		EOBusinessFinancialWalletTransaction eoBussinessTransaction=new EOBusinessFinancialWalletTransaction();
		eoBussinessTransaction.setBusinessFinancialWallet(eoBussinessWallet);
	    eoBussinessTransaction.setAmount(amount);
	    eoBussinessTransaction.setUtrNumber(utrNumber);
	    eoBussinessTransaction.setRemarks(remarks);
	    eoBussinessTransaction.setType(TransactionType.DEBIT.toString());
	    eoBussinessTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    EOBusinessFinancialWalletTransaction eoBusinessWalletTransaction= businessFinancialWalletTransactionRepository.saveAndFlush(eoBussinessTransaction);
		return eoBusinessWalletTransaction;
	}
}
