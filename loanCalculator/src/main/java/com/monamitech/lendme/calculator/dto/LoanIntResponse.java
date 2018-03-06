package com.monamitech.lendme.calculator.dto;

public class LoanIntResponse {
	public String product;
	public double loanAmount;
	public int intrestRate;
	public double emiAmountPermonth;
	public double totalLoanAmount;
	public int tenure;

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getProduct() {
		return product;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public int getIntrestRate() {
		return intrestRate;
	}

	public double getTotalLoanAmount() {
		return totalLoanAmount;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public void setIntrestRate(int intrestRate) {
		this.intrestRate = intrestRate;
	}

	public void setTotalLoanAmount(double totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}

	public double getEmiAmountPermonth() {
		return emiAmountPermonth;
	}

	public void setEmiAmountPermonth(double emiAmountPermonth) {
		this.emiAmountPermonth = emiAmountPermonth;
	}

	@Override
	public String toString() {
		return "LoanIntResponse [product=" + product + ", loanAmount=" + loanAmount + ", intrestRate=" + intrestRate
				+ ", emiAmountPermonth=" + emiAmountPermonth + ", totalLoanAmount=" + totalLoanAmount + ", tenure="
				+ tenure + "]";
	}

}
