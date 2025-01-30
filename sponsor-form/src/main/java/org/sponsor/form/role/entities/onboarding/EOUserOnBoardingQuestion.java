package org.sponsor.form.role.entities.onboarding;

import java.util.List;

import org.sponsor.form.entities.EOEntityObject;
import org.sponsor.form.view.entities.onboarding.EOViewOnBoardingQuestion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "USER_ONBOARDING_QUESTION", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "USER_ACCOUNT_ID", "QUESTION_ID" }) })
public class EOUserOnBoardingQuestion extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "USER_ACCOUNT_ID", nullable = false)
	private Long userAccountId;

	@JoinColumn(name = "QUESTION_ID", nullable = false)
	@ManyToOne
	private EOViewOnBoardingQuestion question;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<EOUserOnBoardingAnswer> answers;

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public EOViewOnBoardingQuestion getQuestion() {
		return question;
	}

	public void setQuestion(EOViewOnBoardingQuestion question) {
		this.question = question;
	}

	public List<EOUserOnBoardingAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<EOUserOnBoardingAnswer> answers) {
		this.answers = answers;
	}

}
