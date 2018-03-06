/**
 * 
 */
package com.monamitech.lendme.calculator.dto;

/**
 * @author Sagar C Samal
 *
 *         Dec 5, 2017
 */
public class LoanCalculator {

	private int intrestRateID;
	private int intrestRate;
	private double minimumamount;
	private double maxAmount;
	private int tenure;
	private int productid;

	public int getIntrestRateID() {
		return intrestRateID;
	}

	public int getIntrestRate() {
		return intrestRate;
	}

	public double getMinimumamount() {
		return minimumamount;
	}

	public double getMaxAmount() {
		return maxAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public int getProductid() {
		return productid;
	}

	public void setIntrestRateID(int intrestRateID) {
		this.intrestRateID = intrestRateID;
	}

	public void setIntrestRate(int intrestRate) {
		this.intrestRate = intrestRate;
	}

	public void setMinimumamount(double minimumamount) {
		this.minimumamount = minimumamount;
	}

	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "LoanCalculator [intrestRateID=" + intrestRateID + ", intrestRate=" + intrestRate + ", minimumamount="
				+ minimumamount + ", maxAmount=" + maxAmount + ", tenure=" + tenure + ", productid=" + productid + "]";
	}

}
