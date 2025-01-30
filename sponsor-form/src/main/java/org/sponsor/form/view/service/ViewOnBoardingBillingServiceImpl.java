package org.sponsor.form.view.service;

import java.util.List;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.form.view.entities.onboarding.EOViewOnBoardingBilling;
import org.sponsor.form.view.mapper.ViewOnBoardingBillingMapper;
import org.sponsor.form.view.model.onboadring.UIViewOnBoardingBilling;
import org.sponsor.form.view.repository.ViewOnBoardingBillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ViewOnBoardingBillingServiceImpl extends CrudServiceImpl<UIViewOnBoardingBilling, EOViewOnBoardingBilling, Long> implements ViewOnBoardingBillingService {

	@Autowired
	private ViewOnBoardingBillingRepository onBoardingBillingRepository;
	
	@Autowired
	private ViewOnBoardingBillingMapper onBoardingBillingMapper;
	
	@Override
	public JpaRepository<EOViewOnBoardingBilling, Long> getRepository() {
		return onBoardingBillingRepository;
	}

	@Override
	public GenericMapper<EOViewOnBoardingBilling, UIViewOnBoardingBilling> getMapper() {
		return onBoardingBillingMapper;
	}

	@Override
	public List<UIViewOnBoardingBilling> postFetch(List<EOViewOnBoardingBilling> findObjects) {
		List<UIViewOnBoardingBilling> boardingBillings = super.postFetch(findObjects);
		boardingBillings.sort((op1,op2)->op1.getOrderSequence().compareTo(op2.getOrderSequence()));
		return boardingBillings;
	}

}
