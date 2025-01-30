package org.sponsor.form.view.service;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.sponsor.form.view.entities.onboarding.EOViewOnBoardingQuestion;
import org.sponsor.form.view.mapper.ViewOnBoardingQuestionMapper;
import org.sponsor.form.view.model.onboadring.UIViewOnBoardingQuestion;
import org.sponsor.form.view.repository.ViewOnBoardingQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ViewOnBoardingQuestionServiceImpl extends CrudServiceImpl<UIViewOnBoardingQuestion, EOViewOnBoardingQuestion, Long> implements ViewOnBoardingQuestionService {

	@Autowired
	private ViewOnBoardingQuestionRepository onBoardingQuestionRepository;
	
	@Autowired
	private ViewOnBoardingQuestionMapper onBoardingQuestionMapper;
	
	@Override
	public JpaRepository<EOViewOnBoardingQuestion, Long> getRepository() {
		return onBoardingQuestionRepository;
	}

	@Override
	public GenericMapper<EOViewOnBoardingQuestion, UIViewOnBoardingQuestion> getMapper() {
		return onBoardingQuestionMapper;
	}

}
