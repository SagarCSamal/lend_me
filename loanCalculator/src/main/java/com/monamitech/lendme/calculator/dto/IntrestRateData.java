/**
 * 
 */
package com.monamitech.lendme.calculator.dto;

/**
 * @author Sagar C Samal
 *
 *         Nov 29, 2017
 */
public class IntrestRateData {

	private Integer id;

	private int intrestRate;

	private double maxAmount;

	private int minAmount;

	private int tenure;

	private long actulkeyId;

	public Integer getId() {
		return id;
	}

	public int getIntrestRate() {
		return intrestRate;
	}

	public double getMaxAmount() {
		return maxAmount;
	}

	public int getMinAmount() {
		return minAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public long getActulkeyId() {
		return actulkeyId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIntrestRate(int intrestRate) {
		this.intrestRate = intrestRate;
	}

	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public void setActulkeyId(long actulkeyId) {
		this.actulkeyId = actulkeyId;
	}

	@Override
	public String toString() {
		return "IntrestRateData [id=" + id + ", intrestRate=" + intrestRate + ", maxAmount=" + maxAmount
				+ ", minAmount=" + minAmount + ", tenure=" + tenure + ", actulkeyId=" + actulkeyId + "]";
	}

}
