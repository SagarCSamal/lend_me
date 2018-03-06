/**
 * 
 */
package com.monamitech.lendme.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monamitech.lendme.calculator.dao.ICalculatorDao;

/**
 * @author Sagar C Samal
 *
 *         Jan 14, 2018
 */
@Component("otpdelete")
public class OtpDeleteScheduler {
	@Autowired
	ICalculatorDao calculatorDao;
	final String sucess_status = "validate";
	
	public void otpdelete() {
		calculatorDao.deleteotp(sucess_status);
		
	}

}
