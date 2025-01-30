package org.sponsor.form.role.repository;
import static org.sponsor.form.constants.TableConstants.USER_ROLE_PAGE_ITEM;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.role.entities.pages.EOUserRolePageItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRolePageItemRepository  extends CustomRepository<EOUserRolePageItem, Long>{

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_PAGE_ITEM+" where URE.ROLE_ID = :roleId and URE.PAGE_ITEM_ID=:userEndpointId ")
	Optional<EOUserRolePageItem> findByRoleIdAndEndpointId(@Param("roleId")Long roleId, @Param("userEndpointId") Long userEndpointId);

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_PAGE_ITEM+" URE where URE.ROLE_ID+'_'+URE.PAGE_ITEM_ID in (:roleEndpoints) ")
	List<EOUserRolePageItem> findByRoleEndpoints(@Param("roleEndpoints") List<String> roleEndpoints);

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_PAGE_ITEM+" URE where URE.ROLE_ID =?1")
	List<EOUserRolePageItem>  findAllByRoleId(Long roleId);

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_PAGE_ITEM+" URE where URE.TYPE_ID =?1")
	List<EOUserRolePageItem>  findAllByType(String roleId);
}
