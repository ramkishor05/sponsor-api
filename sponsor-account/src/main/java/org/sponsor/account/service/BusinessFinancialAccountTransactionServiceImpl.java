package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.account.constants.RecordStatus;
import org.sponsor.account.constants.TransactionType;
import org.sponsor.account.entities.EOBusinessFinancialAccount;
import org.sponsor.account.entities.EOBusinessFinancialAccountTransaction;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.sponsor.account.mapper.BusinessAccountTransactionMapper;
import org.sponsor.account.model.UIBusinessFinancialAccountTransaction;
import org.sponsor.account.repository.BusinessFinancialAccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessFinancialAccountTransactionServiceImpl extends CrudServiceImpl<UIBusinessFinancialAccountTransaction, EOBusinessFinancialAccountTransaction, Long> implements BusinessFinancialAccountTransactionService {

	@Autowired
	private BusinessAccountTransactionMapper bussinessAccountTransactionMapper;
	
	@Autowired
	private BusinessFinancialAccountTransactionRepository bussinessAccountTransactionRepository;
	
	@Autowired
	private BusinessFinancialAccountService businessAccountService;
	
	@Override
	public JpaRepository<EOBusinessFinancialAccountTransaction, Long> getRepository() {
		return bussinessAccountTransactionRepository;
	}

	@Override
	public GenericMapper<EOBusinessFinancialAccountTransaction, UIBusinessFinancialAccountTransaction> getMapper() {
		return bussinessAccountTransactionMapper;
	}

	@Override
	public EOBusinessFinancialAccountTransaction addCredit(double amount, EOBusinessSponsor sponsorLeader, String utrNumber, String remarks) {
		EOBusinessFinancialAccountTransaction creditAmount = creditAmount(amount, sponsorLeader, utrNumber, remarks);
		return creditAmount;
	}

	private EOBusinessFinancialAccountTransaction creditAmount(double amount, EOBusinessSponsor sponsorLeader, String utrNumber,
			String remarks) {
		EOBusinessFinancialAccount eoBussinessAccount=businessAccountService.addCredit(amount, sponsorLeader);
		EOBusinessFinancialAccountTransaction eoBussinessTransaction=new EOBusinessFinancialAccountTransaction();
		eoBussinessTransaction.setBussinessFinancialAccount(eoBussinessAccount);
	    eoBussinessTransaction.setAmount(amount);
	    eoBussinessTransaction.setUtrNumber(utrNumber);
	    eoBussinessTransaction.setRemarks(remarks);
	    eoBussinessTransaction.setType(TransactionType.CREDIT.toString());
	    eoBussinessTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    return bussinessAccountTransactionRepository.saveAndFlush(eoBussinessTransaction);
	}

	@Override
	public EOBusinessFinancialAccountTransaction addDebit(double amount, EOBusinessSponsor sponsorLeader,  String utrNumber, String remarks) {
		EOBusinessFinancialAccountTransaction debitAmount = debitAmount(amount, sponsorLeader,  utrNumber, remarks);
		return debitAmount;
	}

	private EOBusinessFinancialAccountTransaction debitAmount(double amount, EOBusinessSponsor sponsorLeader, String utrNumber, String remarks) {
		EOBusinessFinancialAccount eoBussinessAccount=businessAccountService.addDebit(amount, sponsorLeader);
		EOBusinessFinancialAccountTransaction eoBussinessTransaction=new EOBusinessFinancialAccountTransaction();
		eoBussinessTransaction.setBussinessFinancialAccount(eoBussinessAccount);
	    eoBussinessTransaction.setAmount(amount);
	    eoBussinessTransaction.setUtrNumber(utrNumber);
	    eoBussinessTransaction.setRemarks(remarks);
	    eoBussinessTransaction.setType(TransactionType.DEBIT.toString());
	    eoBussinessTransaction.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    EOBusinessFinancialAccountTransaction eoBusinessAccountTransaction= bussinessAccountTransactionRepository.saveAndFlush(eoBussinessTransaction);
		return eoBusinessAccountTransaction;
	}
}
