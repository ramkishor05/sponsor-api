package org.sponsor.account.repository;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOBusinessFinancialWalletTransaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BusinessFinancialWalletTransactionRepository extends CustomRepository<EOBusinessFinancialWalletTransaction, Long>{

}
