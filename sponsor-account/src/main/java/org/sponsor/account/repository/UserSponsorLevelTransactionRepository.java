package org.sponsor.account.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.constants.TableConstants;
import org.sponsor.account.entities.EOUserSponsorLevelTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSponsorLevelTransactionRepository  extends CustomRepository<EOUserSponsorLevelTransaction, Long>{

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_LEVEL_TRANSACTION US where US.USER_SPONSOR_ID = ?1")
	Optional<EOUserSponsorLevelTransaction> findByUseruSponsorId(Long userSponsorId);

	@Query(nativeQuery = true,  value="select US.* from USER_SPONSOR_LEVEL_TRANSACTION US where US.USER_SPONSOR_ID = ?1 and US.LEVEL = ?2")
	Optional<EOUserSponsorLevelTransaction> findByUserSponsorIdAndLevel(Long userSponsorId, Long level);

	@Query(nativeQuery = true,  value="select sum(UT.AMOUNT) from USER_SPONSOR_LEVEL_TRANSACTION ULS INNER JOIN "+TableConstants.USER_FINANCIAL_WALLET_TRANSACTION+" UT ON ULS.USER_WALLET_TRANSACTION_ID=UT.ID where ULS.USER_SPONSOR_ID = ?1")
	Double totalLevelIncome(Long id);

}
