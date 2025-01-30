package org.sponsor.account.repository;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOUserFinancialWalletTransaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserFinancialWalletTransactionRepository  extends CustomRepository<EOUserFinancialWalletTransaction, Long>{

}
