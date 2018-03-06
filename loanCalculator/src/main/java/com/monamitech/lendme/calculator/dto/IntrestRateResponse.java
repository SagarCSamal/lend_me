package com.monamitech.lendme.calculator.dto;

import java.io.Serializable;

public class IntrestRateResponse implements Serializable {

	private static final long serialVersionUID = 3539254215669107189L;
	/*
	 * int id; public double maxLoanValue; public int minimumLoanValue;
	 * 
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * public double getMaxLoanValue() { return maxLoanValue; }
	 * 
	 * public int getMinimumLoanValue() { return minimumLoanValue; }
	 * 
	 * public void setMaxLoanValue(double maxLoanValue) { this.maxLoanValue =
	 * maxLoanValue; }
	 * 
	 * public void setMinimumLoanValue(int minimumLoanValue) { this.minimumLoanValue
	 * = minimumLoanValue; }
	 * 
	 * @Override public String toString() { return "IntrestRateResponse [productId="
	 * + id + ", maxLoanValue=" + maxLoanValue + ", minimumLoanValue=" +
	 * minimumLoanValue + "]"; }
	 */

	/*
	 * private long productId; private int intrestRate; private double maxLoanValue;
	 * private int minimumLoanValue; private String productName; private int tenure;
	 * 
	 * public long getProductId() { return productId; }
	 * 
	 * public int getIntrestRate() { return intrestRate; }
	 * 
	 * public double getMaxLoanValue() { return maxLoanValue; }
	 * 
	 * public int getMinimumLoanValue() { return minimumLoanValue; }
	 * 
	 * public String getProductName() { return productName; }
	 * 
	 * public int getTenure() { return tenure; }
	 * 
	 * public void setProductId(long productId) { this.productId = productId; }
	 * 
	 * public void setIntrestRate(int intrestRate) { this.intrestRate = intrestRate;
	 * }
	 * 
	 * public void setMaxLoanValue(double maxLoanValue) { this.maxLoanValue =
	 * maxLoanValue; }
	 * 
	 * public void setMinimumLoanValue(int minimumLoanValue) { this.minimumLoanValue
	 * = minimumLoanValue; }
	 * 
	 * public void setProductName(String productName) { this.productName =
	 * productName; }
	 * 
	 * public void setTenure(int tenure) { this.tenure = tenure; }
	 * 
	 * @Override public String toString() { return "IntrestRateResponse [productId="
	 * + productId + ", intrestRate=" + intrestRate + ", maxLoanValue=" +
	 * maxLoanValue + ", minimumLoanValue=" + minimumLoanValue + ", productName=" +
	 * productName + ", tenure=" + tenure + "]"; }
	 */

	private long productid;
	private double maxLoanValue;
	private int minimumLoanValue;
	private String productname;

	public long getProductid() {
		return productid;
	}

	public double getMaxLoanValue() {
		return maxLoanValue;
	}

	public int getMinimumLoanValue() {
		return minimumLoanValue;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	public void setMaxLoanValue(double maxLoanValue) {
		this.maxLoanValue = maxLoanValue;
	}

	public void setMinimumLoanValue(int minimumLoanValue) {
		this.minimumLoanValue = minimumLoanValue;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Override
	public String toString() {
		return "IntrestRateResponse [productid=" + productid + ", maxLoanValue=" + maxLoanValue + ", minimumLoanValue="
				+ minimumLoanValue + ", productname=" + productname + "]";
	}

}
