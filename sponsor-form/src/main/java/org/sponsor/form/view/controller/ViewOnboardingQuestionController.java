package org.sponsor.form.view.controller;

import org.brijframework.integration.spring.rest.crud.controller.CrudController;
import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.form.view.entities.onboarding.EOViewOnBoardingQuestion;
import org.sponsor.form.view.model.onboadring.UIViewOnBoardingQuestion;
import org.sponsor.form.view.service.ViewOnBoardingQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global/onboarding/question")
@CrossOrigin("*")
public class ViewOnboardingQuestionController implements CrudController<UIViewOnBoardingQuestion, EOViewOnBoardingQuestion, Long> {

	@Autowired
	private ViewOnBoardingQuestionService onBoardingQuestionService; 
	
	@Override
	public CrudService<UIViewOnBoardingQuestion, EOViewOnBoardingQuestion, Long> getService() {
		return onBoardingQuestionService;
	}
}
