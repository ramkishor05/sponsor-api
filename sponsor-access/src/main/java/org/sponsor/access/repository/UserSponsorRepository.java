package org.sponsor.access.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.access.entities.EOUserSponsor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSponsorRepository extends CustomRepository<EOUserSponsor, Long>{

	@Query(nativeQuery = true,  value="select * from USER_SPONSOR UP where UP.USER_ACCOUNT_ID = :userAccountId")
	Optional<EOUserSponsor> findByUserAccountId(Long userAccountId);

	boolean existsByUtrNumber(String utrNumber);

}
