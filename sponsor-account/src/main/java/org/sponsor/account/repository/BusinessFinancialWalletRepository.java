package org.sponsor.account.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOBusinessFinancialWallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BusinessFinancialWalletRepository extends CustomRepository<EOBusinessFinancialWallet, Long>{

	@Query(nativeQuery = true,  value="select * from BUSSINESS_FINANCIAL_WALLET US where US.BUSSINESS_SPONSOR_ID = :userSponsorId")
	Optional<EOBusinessFinancialWallet> findByBussinessSponsorId(Long userSponsorId);

}
