package org.sponsor.account.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOUserFinancialWallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserFinancialWalletRepository  extends CustomRepository<EOUserFinancialWallet, Long>{

	@Query(nativeQuery = true,  value="select * from USER_FINANCIAL_WALLET US where US.USER_SPONSOR_ID = :userSponsorId")
	Optional<EOUserFinancialWallet> findByUserSponsorId(Long userSponsorId);

}
