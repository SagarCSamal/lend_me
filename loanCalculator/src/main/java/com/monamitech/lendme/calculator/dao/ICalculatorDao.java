package com.monamitech.lendme.calculator.dao;

import java.util.List;

import com.monamitech.lendme.calculator.dto.CheckEmiratesID;
import com.monamitech.lendme.calculator.dto.EligibilityCriteriaResponse;
import com.monamitech.lendme.calculator.dto.IntrestRateResponse;
import com.monamitech.lendme.calculator.dto.LoanIntRequest;
import com.monamitech.lendme.calculator.dto.LoanIntResponse;
import com.monamitech.lendme.calculator.dto.Message;
import com.monamitech.lendme.calculator.dto.TenureCriteria;
import com.monamitech.lendme.calculator.request.MobileNumberValidation;
import com.monamitech.lendme.calculator.request.ValidateOtp;

public interface ICalculatorDao {

	List<IntrestRateResponse> getRate();

	public LoanIntResponse calculateLoan(LoanIntRequest loanIntrestRate);

	public boolean checkEmiratesId(CheckEmiratesID checkEmiratesId);

	List<EligibilityCriteriaResponse> getEligibilityCriteriaResponse();

	public boolean validTenure(LoanIntRequest loanIntRequest);

	List<TenureCriteria> getTenureCriteria();
	boolean validateInputLoanAmount(LoanIntRequest  loanIntRequest);
	public Message otpsend(MobileNumberValidation mobileNumberValidation,String otpCode);
	public Message validateOtp(ValidateOtp  validateOtp);
	void deleteotp(String statuscode);
}
