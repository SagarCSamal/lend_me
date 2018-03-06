/**
 * 
 */
package com.monamitech.lendme.calculator.dto;

import java.util.List;

/**
 * @author Sagar C Samal
 *
 *         Dec 6, 2017
 */
public class ResponseCriteria {
	Message messageReponse;

	List<EligibilityCriteriaResponse> eligibilityCriteriaResponse;

	public Message getMessageReponse() {
		return messageReponse;
	}

	public List<EligibilityCriteriaResponse> getEligibilityCriteriaResponse() {
		return eligibilityCriteriaResponse;
	}

	public void setMessageReponse(Message messageReponse) {
		this.messageReponse = messageReponse;
	}

	public void setEligibilityCriteriaResponse(List<EligibilityCriteriaResponse> eligibilityCriteriaResponse) {
		this.eligibilityCriteriaResponse = eligibilityCriteriaResponse;
	}

	@Override
	public String toString() {
		return "ResponseCreteria [messageReponse=" + messageReponse + ", eligibilityCriteriaResponse="
				+ eligibilityCriteriaResponse + "]";
	}

}
