package org.sponsor.account.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.constants.TableConstants;
import org.sponsor.account.entities.EOUserSponsorProductTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSponsorProductTransactionRepository  extends CustomRepository<EOUserSponsorProductTransaction, Long>{

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_PRODUCT_TRANSACTION US where US.USER_SPONSOR_ID = :userSponsorId")
	Optional<List<EOUserSponsorProductTransaction>> findByUseruSponsorId(Long userSponsorId);

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_PRODUCT_TRANSACTION US where US.USER_SPONSOR_ID =?1")
	Optional<EOUserSponsorProductTransaction> findByUserSponsorId(Long userSponsorId);

	@Query(nativeQuery = true,  value="select sum(UT.AMOUNT) from USER_SPONSOR_PRODUCT_TRANSACTION UST INNER JOIN "+TableConstants.USER_FINANCIAL_WALLET_TRANSACTION+" UT ON UST.USER_WALLET_TRANSACTION_ID=UT.ID where UST.USER_SPONSOR_ID = ?1")
	Double totalSponsorIncome(Long id);

}
