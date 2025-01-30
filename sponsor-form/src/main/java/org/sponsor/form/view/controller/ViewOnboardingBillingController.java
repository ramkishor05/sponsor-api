package org.sponsor.form.view.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.onboarding.EOViewOnBoardingBilling;
import org.sponsor.form.view.model.onboadring.UIViewOnBoardingBilling;
import org.sponsor.form.view.service.ViewOnBoardingBillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/onboarding/billing")
@CrossOrigin("*")
public class ViewOnboardingBillingController implements CrudController<UIViewOnBoardingBilling, EOViewOnBoardingBilling, Long> {

	@Autowired
	private ViewOnBoardingBillingService onBoardingBillingService; 
	
	@Override
	public CrudService<UIViewOnBoardingBilling, EOViewOnBoardingBilling, Long> getService() {
		return onBoardingBillingService;
	}
}
