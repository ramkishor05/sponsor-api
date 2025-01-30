package org.sponsor.access.repository;

import java.util.List;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.access.entities.EOUserAccountService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserAccountServiceRepository  extends CustomRepository<EOUserAccountService, Long>{

	List<EOUserAccountService> findByUserAccountId(Long userAccountId);

}
