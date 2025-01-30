package org.sponsor.access.repository;

import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.access.entities.EOUserToken;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserTokenRepository  extends CustomRepository<EOUserToken, Long>{

	Optional<EOUserToken> findBySource(String token);
	
	Optional<EOUserToken> findByTarget(String token);

}
