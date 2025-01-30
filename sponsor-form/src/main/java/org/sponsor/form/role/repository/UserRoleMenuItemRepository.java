package org.sponsor.form.role.repository;
import static org.sponsor.form.constants.TableConstants.USER_ROLE_MENU_ITEM;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRoleMenuItemRepository  extends CustomRepository<EOUserRoleMenuItem, Long>{

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_MENU_ITEM+" where URE.USER_ROLE_NAME = :roleId and URE.MENU_ITEM_ID=:userEndpointId ")
	Optional<EOUserRoleMenuItem> findByRoleIdAndEndpointId(@Param("roleId")String roleId, @Param("userEndpointId") Long userEndpointId);

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_MENU_ITEM+" URE where URE.USER_ROLE_NAME+'_'+URE.MENU_ITEM_ID in (:roleEndpoints) ")
	List<EOUserRoleMenuItem> findByRoleEndpoints(@Param("roleEndpoints") List<String> roleEndpoints);

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_MENU_ITEM+" URE where URE.USER_ROLE_NAME =?1")
	List<EOUserRoleMenuItem>  findAllByRoleId(String roleId);

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_MENU_ITEM+" URE where URE.TYPE_ID =?1")
	List<EOUserRoleMenuItem>  findAllByType(String type);
}
