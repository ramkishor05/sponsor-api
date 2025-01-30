package org.sponsor.account.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOBusinessFinancialAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BusinessFinancialAccountRepository extends CustomRepository<EOBusinessFinancialAccount, Long>{

	@Query(nativeQuery = true,  value="select * from BUSINESS_FINANCIAL_ACCOUNT US where US.BUSSINESS_SPONSOR_ID = :userSponsorId")
	Optional<EOBusinessFinancialAccount> findByBussinessSponsorId(Long userSponsorId);

}
