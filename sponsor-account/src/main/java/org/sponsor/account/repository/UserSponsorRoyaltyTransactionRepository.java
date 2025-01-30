package org.sponsor.account.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOUserSponsorRoyaltyTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSponsorRoyaltyTransactionRepository  extends CustomRepository<EOUserSponsorRoyaltyTransaction, Long>{

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_ROYALTY_TRANSACTION US where US.USER_SPONSOR_ID = ?1")
	Optional<EOUserSponsorRoyaltyTransaction> findByUseruSponsorId(Long userSponsorId);

	@Query(nativeQuery = true,  value="select US.* from USER_SPONSOR_ROYALTY_TRANSACTION US where US.USER_SPONSOR_ID = ?1 and US.LEVEL = ?2")
	Optional<EOUserSponsorRoyaltyTransaction> findByUserSponsorIdAndRoyalty(Long userSponsorId, Long level);

	@Query(nativeQuery = true,  value="select sum(UT.AMOUNT) from USER_SPONSOR_ROYALTY_TRANSACTION ULS INNER JOIN USER_WALLET_TRANSACTION UT ON ULS.USER_WALLET_TRANSACTION_ID=UT.ID where ULS.USER_SPONSOR_ID = ?1")
	Double totalRoyaltyIncome(Long id);

	@Query(nativeQuery = true,  value="select US.* from USER_SPONSOR_ROYALTY_TRANSACTION US where US.USER_SPONSOR_ID = ?1 and US.YEAR = ?2 and US.month = ?3")
	Optional<EOUserSponsorRoyaltyTransaction> findOneByUserSponsorIdAndYearAndMonth(Long id, Integer year, Integer month);

	@Query(nativeQuery = true,  value="select USRT.* from USER_SPONSOR_ROYALTY_TRANSACTION USRT INNER JOIN USER_SPONSOR US ON USRT.USER_SPONSOR_ID =US.ID WHERE US.SPONSOR_ID=?1")
	List<EOUserSponsorRoyaltyTransaction> findAllBySponsorId(Long sponsorId);

	@Query(nativeQuery = true,  value="select USRT.* from USER_SPONSOR_ROYALTY_TRANSACTION USRT INNER JOIN USER_SPONSOR US ON USRT.USER_SPONSOR_ID =US.ID WHERE US.USER_ACCOUNT_ID=?1")
	List<EOUserSponsorRoyaltyTransaction> findAllByAccountId(Long accountId);
}
