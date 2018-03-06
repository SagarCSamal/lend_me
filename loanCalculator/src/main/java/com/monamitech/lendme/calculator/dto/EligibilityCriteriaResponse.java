/**
 * 
 */
package com.monamitech.lendme.calculator.dto;

/**
 * @author Sagar C Samal
 *
 *         Dec 6, 2017
 */
public class EligibilityCriteriaResponse {

	public String question;
	public String answer;

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "EligibilityCriteriaResponse [question=" + question + ", answer=" + answer + "]";
	}

}
