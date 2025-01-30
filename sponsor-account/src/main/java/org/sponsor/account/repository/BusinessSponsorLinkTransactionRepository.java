package org.sponsor.account.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOBusinessSponsorLinkTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BusinessSponsorLinkTransactionRepository extends CustomRepository<EOBusinessSponsorLinkTransaction, Long>{

	@Query(nativeQuery = true,  value="select * from BUSSINESS_SPONSOR_LINK_TRANSACTION US where US.BUSSINESS_SPONSOR_ID = :userSponsorId")
	Optional<EOBusinessSponsorLinkTransaction> findByUseruSponsorId(Long userSponsorId);

	@Query(nativeQuery = true,  value="select * from BUSSINESS_SPONSOR_LINK_TRANSACTION US where US.BUSSINESS_SPONSOR_ID =?1 and US.LINK_SPONSOR_ID=?2")
	Optional<EOBusinessSponsorLinkTransaction> findByUserSponsorIdAndSponsorLinkId(Long userSponsorId, Long linkSponsorId);

}
