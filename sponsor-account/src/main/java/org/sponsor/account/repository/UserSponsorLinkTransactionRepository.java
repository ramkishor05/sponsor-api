package org.sponsor.account.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOUserSponsorLinkTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSponsorLinkTransactionRepository  extends CustomRepository<EOUserSponsorLinkTransaction, Long>{

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_LINK_TRANSACTION US where US.USER_SPONSOR_ID = :userSponsorId")
	Optional<List<EOUserSponsorLinkTransaction>> findByUserSponsorId(Long userSponsorId);

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_LINK_TRANSACTION US where US.USER_SPONSOR_ID =?1 and US.LINK_SPONSOR_ID=?2 and US.LEVEL=?3 ")
	Optional<EOUserSponsorLinkTransaction> findByUserSponsorIdAndSponsorLinkId(Long userSponsorId, Long linkSponsorId, Long level);

}
