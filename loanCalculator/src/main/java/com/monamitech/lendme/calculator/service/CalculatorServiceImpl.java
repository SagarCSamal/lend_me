package com.monamitech.lendme.calculator.service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monamitech.lendme.calculator.dao.ICalculatorDao;
import com.monamitech.lendme.calculator.dto.EligibilityCriteriaResponse;
import com.monamitech.lendme.calculator.dto.IntrestRateResponse;
import com.monamitech.lendme.calculator.dto.LoanIntRequest;
import com.monamitech.lendme.calculator.dto.LoanIntResponse;
import com.monamitech.lendme.calculator.dto.Message;
import com.monamitech.lendme.calculator.dto.TenureCriteria;
import com.monamitech.lendme.calculator.request.MobileNumberValidation;
import com.monamitech.lendme.calculator.request.ValidateOtp;

@Component
public class CalculatorServiceImpl implements ICalculatorService {
	private static final Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);
	@Autowired
	ICalculatorDao calculatorDao;

	@Override
	public List<IntrestRateResponse> getIntrestRate() {

		List<IntrestRateResponse> response = calculatorDao.getRate();
		logger.info("getIntrestRate() method of CalculatorServiceImpl starting...with " + "Response:  " + response);
		return response;
	}

	@Override
	public LoanIntResponse calculateLoan(LoanIntRequest loanIntrestRate) {

		LoanIntResponse loanResponse = calculatorDao.calculateLoan(loanIntrestRate);
		logger.info("calculateLoan method of CalculatorServiceImpl starting...with " + "Request: " + loanIntrestRate
				+ "Response:  " + loanResponse);
		return loanResponse;
	}

	public List<EligibilityCriteriaResponse> getEligibilityCriteriaResponse() {
		logger.info("getEligibilityCriteriaResponse method of CalculatorServiceImpl starting...");

		return calculatorDao.getEligibilityCriteriaResponse();

	}

	@Override
	public boolean validTenure(LoanIntRequest loanIntRequest) {
		boolean flag = false;
		if (calculatorDao.validTenure(loanIntRequest)) {
			flag = true;
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.monamitech.lendme.calculator.service.ICalculatorService#getTenureCriteria
	 * ()
	 */
	@Override
	public List<TenureCriteria> getTenureCriteria() {

		return calculatorDao.getTenureCriteria();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monamitech.lendme.calculator.service.ICalculatorService#
	 * validateInputLoanAmount(com.monamitech.lendme.calculator.dto.LoanIntRequest)
	 */
	@Override
	public boolean validateInputLoanAmount(LoanIntRequest loanIntRequest) {

		return calculatorDao.validateInputLoanAmount(loanIntRequest);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monamitech.lendme.calculator.service.ICalculatorService#otpsend(com.
	 * monamitech.lendme.calculator.request.MobileNumberValidation)
	 */
	@Override
	public Message otpsend(MobileNumberValidation mobileNumberValidation) {
		Message messageResponse = new Message();
		int randomNum = ThreadLocalRandom.current().nextInt(5, 10 + 1);
		Random rand = new Random();
		String otpcode = String.format("%04d", rand.nextInt(10000));
		return calculatorDao.otpsend(mobileNumberValidation, otpcode);

	}

	/* (non-Javadoc)
	 * @see com.monamitech.lendme.calculator.service.ICalculatorService#validateOtp(com.monamitech.lendme.calculator.request.ValidateOtp)
	 */
	@Override
	public Message validateOtp(ValidateOtp otp) {
	
		return calculatorDao.validateOtp(otp);
	}

}
