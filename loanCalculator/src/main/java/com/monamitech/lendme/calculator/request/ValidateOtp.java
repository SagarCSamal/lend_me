/**
 * 
 */
package com.monamitech.lendme.calculator.request;

import java.io.Serializable;

/**
 * @author Sagar C Samal
 *
 *         Jan 14, 2018
 */
public class ValidateOtp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6026511497166454609L;

	private String phoneNumber;
	private String otpCode;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getOtpCode() {
		return otpCode;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	@Override
	public String toString() {
		return "ValidateOtp [phoneNumber=" + phoneNumber + ", otpCode=" + otpCode + "]";
	}

}
