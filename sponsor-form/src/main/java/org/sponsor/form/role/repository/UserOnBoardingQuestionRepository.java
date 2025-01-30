package org.sponsor.form.role.repository;

import java.util.List;

import org.brijframework.integration.spring.rest.repository.CustomRepository;
import org.sponsor.form.role.entities.onboarding.EOUserOnBoardingQuestion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserOnBoardingQuestionRepository  extends CustomRepository<EOUserOnBoardingQuestion, Long>{


	/**
	 * @param userAccountId
	 * @return
	 */
	List<EOUserOnBoardingQuestion> findAllByUserAccountId(Long userAccountId);

	EOUserOnBoardingQuestion findOneByUserAccountIdAndQuestionId(Long userAccountId, Long questionId);

}
