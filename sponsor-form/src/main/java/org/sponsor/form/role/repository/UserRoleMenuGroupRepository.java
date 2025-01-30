package org.sponsor.form.role.repository;

import static org.sponsor.form.constants.TableConstants.USER_ROLE_MENU_GROUP;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRoleMenuGroupRepository  extends CustomRepository<EOUserRoleMenuGroup, Long>{

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_MENU_GROUP+" URE where URE.USER_ROLE_NAME =?1")
	List<EOUserRoleMenuGroup>  findAllByRoleId(String userRoleName);

	@Query(nativeQuery = true,  value="select * from "+USER_ROLE_MENU_GROUP+" URE where URE.USER_ROLE_NAME = :userRoleName and URE.MENU_GROUP_ID=:userEndpointId ")
	Optional<EOUserRoleMenuGroup> findByRoleIdAndGroupId(@Param("userRoleName")String userRoleName, @Param("userEndpointId") Long userEndpointId);


}
