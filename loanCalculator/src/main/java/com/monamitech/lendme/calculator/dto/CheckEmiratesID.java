package com.monamitech.lendme.calculator.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sagar C Samal
 *
 *         Nov 19, 2017
 */
public class CheckEmiratesID {
	private static final Logger logger = LoggerFactory.getLogger(CheckEmiratesID.class);
	private String emiratesId;

	public CheckEmiratesID() {
		super();

	}

	public CheckEmiratesID(String emiratesId) {
		super();
		this.emiratesId = emiratesId;
	}

	public String getEmiratesId() {
		return emiratesId;
	}

	public void setEmiratesId(String emiratesId) {
		this.emiratesId = emiratesId;
	}

	@Override
	public String toString() {
		return "CheckEmiratesID [emiratesId=" + emiratesId + "]";
	}

}
