/**
 * 
 */
package com.monamitech.lendme.calculator.dto;

/**
 * @author Sagar C Samal
 *
 *         Dec 6, 2017
 */
public class TenureCriteria {

	private int tenure;
	private int productid;

	public int getTenure() {
		return tenure;
	}

	public int getProductid() {
		return productid;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "TenureCriteria [tenure=" + tenure + ", productid=" + productid + "]";
	}

}
