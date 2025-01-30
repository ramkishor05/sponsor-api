package org.sponsor.form.role.repository;

import java.util.List;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.role.entities.onboarding.EOUserOnBoardingAnswer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserOnBoardingAnswerRepository  extends CustomRepository<EOUserOnBoardingAnswer, Long>{

	void deleteAllByQuestionId(Long userQuestionId);
	
	List<EOUserOnBoardingAnswer> findAllByQuestionId(Long userQuestionId);

}
