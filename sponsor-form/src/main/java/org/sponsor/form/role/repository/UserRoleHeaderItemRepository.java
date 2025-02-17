package org.sponsor.form.role.repository;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.role.entities.headers.EOUserRoleHeaderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRoleHeaderItemRepository  extends CustomRepository<EOUserRoleHeaderItem, Long>{

	@Query(nativeQuery = true,  value="select * from USER_ROLE_HEADER_ITEM URE where URE.ROLE_ID = :roleId and URE.HEADER_ITEM_ID=:headerId ")
	Optional<EOUserRoleHeaderItem> findByRoleIdAndEndpointId(@Param("roleId")Long roleId, @Param("headerId") Long headerId);

	@Query(nativeQuery = true,  value="select * from USER_ROLE_HEADER_ITEM URE where URE.ROLE_ID+'_'+URE.HEADER_ITEM_ID in (:roleheaders) ")
	List<EOUserRoleHeaderItem> findByRoleEndpoints(@Param("roleheaders") List<String> roleheaders);

	@Query(nativeQuery = true,  value="select * from USER_ROLE_HEADER_ITEM URE where URE.ROLE_ID =?1")
	List<EOUserRoleHeaderItem>  findAllByRoleId(Long roleId);

	@Query(nativeQuery = true,  value="select * from USER_ROLE_HEADER_ITEM URE where URE.TYPE_ID =?1")
	List<EOUserRoleHeaderItem>  findAllByType(String roleId);
}
