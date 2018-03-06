/**
 * 
 */
package com.monamitech.lendme.calculator.dto;

import java.sql.Timestamp;

/**
 * @author Sagar C Samal
 *
 *         Jan 12, 2018
 */
public class OtpValidation {
	String mobilenumber;
	String sentOtpNumber;
	String otpstatus;
	String otpcreatetimeing;
	Timestamp otpTimeStamp;
	Timestamp otpUpdateTimeStamp;

	public String getMobilenumber() {
		return mobilenumber;
	}

	public String getSentOtpNumber() {
		return sentOtpNumber;
	}

	public String getOtpstatus() {
		return otpstatus;
	}

	public String getOtpcreatetimeing() {
		return otpcreatetimeing;
	}

	public Timestamp getOtpTimeStamp() {
		return otpTimeStamp;
	}

	public Timestamp getOtpUpdateTimeStamp() {
		return otpUpdateTimeStamp;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public void setSentOtpNumber(String sentOtpNumber) {
		this.sentOtpNumber = sentOtpNumber;
	}

	public void setOtpstatus(String otpstatus) {
		this.otpstatus = otpstatus;
	}

	public void setOtpcreatetimeing(String otpcreatetimeing) {
		this.otpcreatetimeing = otpcreatetimeing;
	}

	public void setOtpTimeStamp(Timestamp otpTimeStamp) {
		this.otpTimeStamp = otpTimeStamp;
	}

	public void setOtpUpdateTimeStamp(Timestamp otpUpdateTimeStamp) {
		this.otpUpdateTimeStamp = otpUpdateTimeStamp;
	}

	@Override
	public String toString() {
		return "OtpValidation [mobilenumber=" + mobilenumber + ", sentOtpNumber=" + sentOtpNumber + ", otpstatus="
				+ otpstatus + ", otpcreatetimeing=" + otpcreatetimeing + ", otpTimeStamp=" + otpTimeStamp
				+ ", otpUpdateTimeStamp=" + otpUpdateTimeStamp + "]";
	}

}
