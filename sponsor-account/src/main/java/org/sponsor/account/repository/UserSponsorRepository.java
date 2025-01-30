package org.sponsor.account.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.account.entities.EOUserSponsor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSponsorRepository  extends CustomRepository<EOUserSponsor, Long>{

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR US where US.USER_ACCOUNT_ID = :userAccountId")
	Optional<EOUserSponsor> findByUserAccountId(Long userAccountId);

	@Query(nativeQuery = true,  value="select max(US.SPONSOR_ID) from USER_SPONSOR US")
	Long nextSponsorId();

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR US where US.SPONSOR_ID=?1")
	EOUserSponsor findOneBySponsorId(Long sponsorId);

	@Query(nativeQuery = true,  value="select count(US.SPONSOR_ID) from USER_SPONSOR US where US.SPONSOR_LEADER_ID=?1 and US.LEVEL=?2")
	Long countSponsors(Long sponsorId, Long level);
	
	@Query(nativeQuery = true,  value="select count(US.SPONSOR_ID) from USER_SPONSOR US where US.SPONSOR_LEADER_ID=?1")
	Long countSponsors(Long sponsorId);

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR US where US.SPONSOR_LEADER_ID=?1")
	List<EOUserSponsor> getChildSponsors(Long id);

	long countByRecordStateIn(List<String> statusIds);

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR US where US.USER_ACCOUNT_ID = :userAccountId")
	EOUserSponsor findOneByUserId(Long userAccountId);

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR US where US.LEVEL >= :level")
	List<EOUserSponsor> findAllByLevel(Integer level);

	boolean existsByUtrNumber(String utrNumber);
	
}
