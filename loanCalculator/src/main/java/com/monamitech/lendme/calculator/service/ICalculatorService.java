package com.monamitech.lendme.calculator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monamitech.lendme.calculator.dto.EligibilityCriteriaResponse;
import com.monamitech.lendme.calculator.dto.IntrestRateResponse;
import com.monamitech.lendme.calculator.dto.LoanIntRequest;
import com.monamitech.lendme.calculator.dto.LoanIntResponse;
import com.monamitech.lendme.calculator.dto.Message;
import com.monamitech.lendme.calculator.dto.TenureCriteria;
import com.monamitech.lendme.calculator.request.MobileNumberValidation;
import com.monamitech.lendme.calculator.request.ValidateOtp;

@Service
public interface ICalculatorService {

	List<IntrestRateResponse> getIntrestRate();

	public LoanIntResponse calculateLoan(LoanIntRequest loanIntrestRate);
	List<EligibilityCriteriaResponse> getEligibilityCriteriaResponse();
	
	public boolean  validTenure(LoanIntRequest  loanIntRequest);
	List<TenureCriteria> getTenureCriteria();
	boolean validateInputLoanAmount(LoanIntRequest  loanIntRequest);
	Message otpsend(MobileNumberValidation mobileNumberValidation);
	Message validateOtp(ValidateOtp  otp);
}
