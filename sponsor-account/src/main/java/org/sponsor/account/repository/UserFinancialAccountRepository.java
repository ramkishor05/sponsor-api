package org.sponsor.account.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOUserFinancialAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserFinancialAccountRepository  extends CustomRepository<EOUserFinancialAccount, Long>{

	@Query(nativeQuery = true,  value="select * from USER_FINANCIAL_ACCOUNT US where US.USER_SPONSOR_ID = :userSponsorId")
	Optional<EOUserFinancialAccount> findByUserSponsorId(Long userSponsorId);

}
