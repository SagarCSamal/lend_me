package com.monamitech.lendme.calculator.dto;

import java.util.List;

public class ProductCatalog {
	public Message message;

	List<IntrestRateResponse> intrestRateResponse;
	/*public List<TenureCriteria> tenureData;

	public List<TenureCriteria> getTenureData() {
		return tenureData;
	}

	public void setTenureData(List<TenureCriteria> tenureData) {
		this.tenureData = tenureData;
	}

	public Message getMessage() {
		return message;
	}

	public List<IntrestRateResponse> getIntrestRateResponse() {
		return intrestRateResponse;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public void setIntrestRateResponse(List<IntrestRateResponse> intrestRateResponse) {
		this.intrestRateResponse = intrestRateResponse;
	}

	public ProductCatalog(Message message, List<IntrestRateResponse> intrestRateResponse,List<TenureCriteria> tenureData) {
		this.message = message;
		this.intrestRateResponse = intrestRateResponse;
		this.tenureData = tenureData;
	}*/

	public Message getMessage() {
		return message;
	}

	public List<IntrestRateResponse> getIntrestRateResponse() {
		return intrestRateResponse;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public void setIntrestRateResponse(List<IntrestRateResponse> intrestRateResponse) {
		this.intrestRateResponse = intrestRateResponse;
	}
	public ProductCatalog(Message message, List<IntrestRateResponse> intrestRateResponse) {
		this.message = message;
		this.intrestRateResponse = intrestRateResponse;
	}

	@Override
	public String toString() {
		return "ProductCatalog [message=" + message + ", intrestRateResponse=" + intrestRateResponse + "]";
	}
	
}
