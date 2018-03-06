/**
 * 
 */
package com.monamitech.lendme.calculator.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.monamitech.lendme.calculator.dto.OtpValidation;

/**
 * @author Sagar C Samal
 *
 *         Jan 14, 2018
 */
public class OtpMapper implements RowMapper<OtpValidation> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public OtpValidation mapRow(ResultSet rs, int rowNum) throws SQLException {
		OtpValidation otp = new OtpValidation();
		otp.setMobilenumber(rs.getString("mobilenumber"));
		otp.setOtpcreatetimeing(rs.getString("sentOtpNumber"));
		otp.setOtpstatus(rs.getString("otpstatus"));
		otp.setOtpcreatetimeing(rs.getString("otpcreatetimeing"));
		otp.setOtpTimeStamp(rs.getTimestamp("otpTimeStamp"));
		otp.setOtpUpdateTimeStamp(rs.getTimestamp("otpUpdateTimeStamp"));
		return otp;
	}

}
