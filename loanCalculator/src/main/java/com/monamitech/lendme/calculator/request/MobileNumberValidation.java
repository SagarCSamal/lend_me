/**
 * 
 */
package com.monamitech.lendme.calculator.request;

import java.io.Serializable;

/**
 * @author Sagar C Samal
 *
 * Dec 27, 2017
 */
public class MobileNumberValidation  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3775228130485134410L;
	
	public String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "MobileNumberValidation [phoneNumber=" + phoneNumber + "]";
	}
	

}
