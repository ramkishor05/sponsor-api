package org.sponsor.form.role.repository;

import java.util.List;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.role.entities.onboarding.EOUserOnBoardingBilling;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserOnBoardingBillingRepository  extends CustomRepository<EOUserOnBoardingBilling, Long>{

	/**
	 * @param userAccountId
	 * @return
	 */
	List<EOUserOnBoardingBilling> findAllByUserAccountId(Long userAccountId);

}
