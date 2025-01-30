package org.sponsor.access.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.access.entities.EOUserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRoleRepository  extends CustomRepository<EOUserRole, Long>{

	EOUserRole findByRoleName(String role);
	
	Optional<EOUserRole> findByPosition(int position);

	List<EOUserRole> findAllByRoleType(String type);

	@Query(nativeQuery = true, value="Select * from USER_ROLE UR where UR.POSITION in (?1)")
	List<EOUserRole> findByPositions(List<Integer> positions);

}
