package com.monamitech.lendme.calculator.model;

import com.monamitech.lendme.calculator.dto.LoanIntResponse;
import com.monamitech.lendme.calculator.dto.Message;

public class LoanIntrestRateCalculation {
	Message message;
	LoanIntResponse response;
	

	public LoanIntResponse getResponse() {
		return response;
	}

	public Message getMessage() {
		return message;
	}

	public void setResponse(LoanIntResponse response) {
		this.response = response;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LoanIntrestRateCalculation [response=" + response + ", message=" + message + "]";
	}

}
