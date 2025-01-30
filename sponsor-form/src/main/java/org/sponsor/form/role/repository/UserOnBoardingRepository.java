package org.sponsor.form.role.repository;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.role.entities.menus.EOUserRoleMenuItem;
import org.sponsor.form.role.entities.onboarding.EOUserOnBoardingMenu;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserOnBoardingRepository  extends CustomRepository<EOUserOnBoardingMenu, Long>{

	void deleteByRoleMenuItem(EOUserRoleMenuItem eoRoleMenuItem);

}
