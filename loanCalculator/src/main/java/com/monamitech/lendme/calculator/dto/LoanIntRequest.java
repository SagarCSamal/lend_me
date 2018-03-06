package com.monamitech.lendme.calculator.dto;

public class LoanIntRequest {

	public long productId;
	public double loanAmount;
	public int tenure;

	public long getProductId() {
		return productId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "LoanIntRequest [productId=" + productId + ", loanAmount=" + loanAmount + ", tenure=" + tenure + "]";
	}

}
