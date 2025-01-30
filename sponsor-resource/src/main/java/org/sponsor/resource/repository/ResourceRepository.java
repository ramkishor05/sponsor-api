package org.sponsor.resource.repository;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.resource.entities.EOResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ResourceRepository extends CustomRepository<EOResource, Long>{
	
}
