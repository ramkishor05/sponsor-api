package org.sponsor.account.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOUserSponsorBoostTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSponsorBoostTransactionRepository  extends CustomRepository<EOUserSponsorBoostTransaction, Long>{

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_BOOST_TRANSACTION US where US.USER_SPONSOR_ID = :userSponsorId")
	Optional<EOUserSponsorBoostTransaction> findByUseruSponsorId(Long userSponsorId);

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_BOOST_TRANSACTION US where US.USER_SPONSOR_ID =?1 and US.LINK_SPONSOR_ID=?2")
	Optional<EOUserSponsorBoostTransaction> findByUserSponsorIdAndSponsorLinkId(Long userSponsorId, Long linkSponsorId);

	@Query(nativeQuery = true,  value="select USBT.* from USER_SPONSOR_BOOST_TRANSACTION USBT INNER JOIN USER_SPONSOR US ON USBT.USER_SPONSOR_ID =US.ID WHERE US.SPONSOR_ID=?1")
	List<EOUserSponsorBoostTransaction> findAllBySponsorId(Long sponsorId);

	@Query(nativeQuery = true,  value="select USBT.* from USER_SPONSOR_BOOST_TRANSACTION USBT INNER JOIN USER_SPONSOR US ON USBT.USER_SPONSOR_ID =US.ID WHERE US.USER_ACCOUNT_ID=?1")
	List<EOUserSponsorBoostTransaction> findAllByAccountId(Long accountId);

	boolean existsByUserSponsorIdAndStatus(Long userSponsorId, String status);
	
}
