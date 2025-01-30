package org.sponsor.access.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.access.entities.EOUserSponsorActivity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSponsorActivityRepository extends CustomRepository<EOUserSponsorActivity, Long>{

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR_ACTIVITY UP where UP.USER_SPONSOR_ID = :userSponsorId")
	Optional<List<EOUserSponsorActivity>> findByUserSponsorId(Long userSponsorId);

}
