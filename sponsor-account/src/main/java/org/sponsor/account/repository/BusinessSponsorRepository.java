package org.sponsor.account.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOBusinessSponsor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BusinessSponsorRepository  extends CustomRepository<EOBusinessSponsor, Long>{

	@Query(nativeQuery = true,  value="select * from BUSSINESS_SPONSOR US where US.USER_ACCOUNT_ID = :userAccountId")
	Optional<EOBusinessSponsor> findByUserAccountId(Long userAccountId);

	@Query(nativeQuery = true,  value="select max(US.SPONSOR_ID) from BUSSINESS_SPONSOR US")
	Long nextSponsorId();

	@Query(nativeQuery = true,  value="select * from BUSSINESS_SPONSOR US where US.SPONSOR_ID=?1")
	EOBusinessSponsor findOneBySponsorId(Long sponsorId);

	long countByRecordStateIn(List<String> statusIds);

	@Query(nativeQuery = true,  value="select * from BUSSINESS_SPONSOR US where US.USER_ACCOUNT_ID = :userAccountId")
	EOBusinessSponsor findOneByUserId(Long userAccountId);
	
}
