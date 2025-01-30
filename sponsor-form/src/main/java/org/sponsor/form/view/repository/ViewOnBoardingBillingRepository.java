package org.sponsor.form.view.repository;
import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.view.entities.onboarding.EOViewOnBoardingBilling;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ViewOnBoardingBillingRepository extends CustomRepository<EOViewOnBoardingBilling, Long>{

}
