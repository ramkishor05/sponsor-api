package org.sponsor.account.repository;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOBusinessFinancialAccountTransaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BusinessFinancialAccountTransactionRepository extends CustomRepository<EOBusinessFinancialAccountTransaction, Long>{

}
