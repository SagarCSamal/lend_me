package com.monamitech.lendme.calculator.dto;

public class LoanCal {
	public int rate;
	public int percentage;

	public int getRate() {
		return rate;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "LoanCal [rate=" + rate + ", percentage=" + percentage + "]";
	}

}
