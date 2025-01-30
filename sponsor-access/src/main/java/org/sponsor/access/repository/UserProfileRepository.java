package org.sponsor.access.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.access.entities.EOUserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserProfileRepository extends CustomRepository<EOUserProfile, Long>{

	@Query(nativeQuery = true,  value="select * from USER_PROFILE UP where UP.USER_ACCOUNT_ID = :userAccountId")
	Optional<EOUserProfile> findByUserAccountId(Long userAccountId);

}
