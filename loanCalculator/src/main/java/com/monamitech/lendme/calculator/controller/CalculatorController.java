package com.monamitech.lendme.calculator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.monamitech.lendme.calculator.constant.StatuCode;
import com.monamitech.lendme.calculator.dao.CalculatorDaoImpl;
import com.monamitech.lendme.calculator.dto.CheckEmiratesID;
import com.monamitech.lendme.calculator.dto.EligibilityCriteriaResponse;
import com.monamitech.lendme.calculator.dto.IntrestRateResponse;
import com.monamitech.lendme.calculator.dto.LoanIntRequest;
import com.monamitech.lendme.calculator.dto.LoanIntResponse;
import com.monamitech.lendme.calculator.dto.Message;
import com.monamitech.lendme.calculator.dto.ProductCatalog;
import com.monamitech.lendme.calculator.dto.ResponseCriteria;
import com.monamitech.lendme.calculator.dto.TenureCriteria;
import com.monamitech.lendme.calculator.model.LoanIntrestRateCalculation;
import com.monamitech.lendme.calculator.request.MobileNumberValidation;
import com.monamitech.lendme.calculator.request.ValidateOtp;
import com.monamitech.lendme.calculator.service.ICalculatorService;
import com.monamitech.lendme.calculator.utility.SmsEndpointTool;

@RestController
public class CalculatorController {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
	@Autowired
	ICalculatorService service;

	@SuppressWarnings("null")
	@RequestMapping(value = UrlMapping.GET_AMOUNT, method = RequestMethod.GET)
	public ResponseEntity<ProductCatalog> getIntrestRate() {
		logger.info("Start getIntrestRate.  method" + service);
		Message messageResponse = null;
		ProductCatalog catalog = null;
		List<IntrestRateResponse> Product = service.getIntrestRate();

		List<TenureCriteria> tenureCriteria = service.getTenureCriteria();
		if (null != Product && null != tenureCriteria) {
			messageResponse = new Message(StatuCode.SUCCESS, StatuCode.SUCCESS_MESSAGE);
			// catalog = new ProductCatalog(messageResponse, Product, tenureCriteria);
			catalog = new ProductCatalog(messageResponse, Product);
		} else if (Product.isEmpty() && tenureCriteria.isEmpty()) {
			messageResponse = new Message(StatuCode.WARN, StatuCode.DATA_MESSAGE);
			// catalog = new ProductCatalog(messageResponse, Product, tenureCriteria);
			catalog = new ProductCatalog(messageResponse, Product);
		}
		return new ResponseEntity<ProductCatalog>(catalog, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = UrlMapping.GET_TOTAL_AMOUNT, method = RequestMethod.POST)
	public ResponseEntity getLoanAmount(@RequestBody LoanIntRequest loanIntReq) {
		logger.info("GetLoanAmount method start ... with request data" + loanIntReq);
		// LoanIntResponse loanIntResponse = service.calculateLoan(loanIntReq);
		LoanIntResponse loanIntResponse = null;
		LoanIntrestRateCalculation loanResponse = null;
		Message message;
		if (service.validateInputLoanAmount(loanIntReq)) {
			if (service.validTenure(loanIntReq)) {
				loanIntResponse = service.calculateLoan(loanIntReq);
				if (null != loanIntResponse) {
					loanResponse = new LoanIntrestRateCalculation();
					message = new Message(StatuCode.SUCCESS, StatuCode.SUCCESS_MESSAGE);
					loanResponse.setMessage(message);
					loanResponse.setResponse(loanIntResponse);
				}
				if (null == loanIntResponse) {
					loanResponse = new LoanIntrestRateCalculation();
					message = new Message(StatuCode.WARN, StatuCode.DATA_MESSAGE);
					loanResponse.setMessage(message);
					loanResponse.setResponse(loanIntResponse);
				}
			} else {

				message = new Message(StatuCode.NO_TENURE_FIND_CODE, StatuCode.NO_TENURE_FIND_DESC_MESSAGE);
				LoanIntResponse loanIntResponse1 = new LoanIntResponse();
				loanResponse = new LoanIntrestRateCalculation();
				loanResponse.setMessage(message);
				loanResponse.setResponse(loanIntResponse1);

			}
		} else {

			message = new Message(StatuCode.MAX_LOAN_AMOUNT_CODE, StatuCode.NO_LOAN_AMOUNT_FOUND_DESC_MESSAGE);
			LoanIntResponse loanIntResponse1 = new LoanIntResponse();
			loanResponse = new LoanIntrestRateCalculation();
			loanResponse.setMessage(message);
			loanResponse.setResponse(loanIntResponse1);

		}

		return new ResponseEntity(loanResponse, HttpStatus.OK);
	}

	public ResponseEntity validateEmiratesID(@RequestBody CheckEmiratesID emiratesID) {

		return null;

	}

	@SuppressWarnings("null")
	@RequestMapping(value = UrlMapping.GET_ELIGIBILITY_CRITERIA, method = RequestMethod.GET)
	public ResponseEntity getEligibilityCriteria() {

		List<EligibilityCriteriaResponse> eligibilityCriteriaResponse = service.getEligibilityCriteriaResponse();
		Message messageResponse = new Message();
		ResponseCriteria responseCriteria = new ResponseCriteria();

		if (null == eligibilityCriteriaResponse) {
			messageResponse.setStatus(StatuCode.NO_DATA);
			messageResponse.setMessage(StatuCode.NO_QUESTION_AVAILABLE);
			responseCriteria.setMessageReponse(messageResponse);
			responseCriteria.setEligibilityCriteriaResponse(eligibilityCriteriaResponse);

		} else {

			messageResponse.setStatus(StatuCode.SUCCESS);
			messageResponse.setMessage(StatuCode.SUCCESS_MESSAGE);
			responseCriteria.setMessageReponse(messageResponse);
			responseCriteria.setEligibilityCriteriaResponse(eligibilityCriteriaResponse);

		}

		return new ResponseEntity(responseCriteria, HttpStatus.OK);

	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = UrlMapping.SEND_SMS_CRITERIA, method = RequestMethod.POST)
	public ResponseEntity sendSms(@RequestBody MobileNumberValidation mobileNumberValidation) {


		Message messageResponse = new Message();
		
		try {

			SmsEndpointTool sendSms = SmsEndpointTool.getInstance();
			String smsresponse = sendSms.sendMessageToMobileApp(mobileNumberValidation.getPhoneNumber());
			if (StatuCode.SENDING_SMS_TO_CONSUMER_SUCESS.equals(smsresponse)) {
				messageResponse.setStatus(StatuCode.SUCCESS);

				messageResponse.setMessage(StatuCode.SUCCESS_MESSAGE);

			}

		} catch (Exception e) {

			messageResponse.setStatus(StatuCode.FAIL);

			messageResponse.setMessage(StatuCode.desc_un_SUCCESS_MESSAGE);

		} finally {
			return new ResponseEntity(messageResponse, HttpStatus.OK);
		}


	}
	@SuppressWarnings("null")
	@RequestMapping(value = UrlMapping.SEND_SMS_SUCESSFULL, method = RequestMethod.POST)
	public ResponseEntity send(@RequestBody MobileNumberValidation mobileNumberValidation) {


		Message messageResponse = new Message();
		
		try {

			SmsEndpointTool sendSms = SmsEndpointTool.getInstance();
			String smsresponse = sendSms.send(mobileNumberValidation.getPhoneNumber());
			if (StatuCode.SENDING_SMS_TO_CONSUMER_SUCESS.equals(smsresponse)) {
				messageResponse.setStatus(StatuCode.SUCCESS);

				messageResponse.setMessage(StatuCode.SUCCESS_MESSAGE);

			}

		} catch (Exception e) {

			messageResponse.setStatus(StatuCode.FAIL);

			messageResponse.setMessage(StatuCode.desc_un_SUCCESS_MESSAGE);

		} finally {
			return new ResponseEntity(messageResponse, HttpStatus.OK);
		}
	}
	@SuppressWarnings("null")
	@RequestMapping(value = UrlMapping.SEND_OTP, method = RequestMethod.POST)
	public ResponseEntity sendOTP(@RequestBody MobileNumberValidation mobileNumberValidation) {

			return new ResponseEntity(service.otpsend(mobileNumberValidation), HttpStatus.OK);
		}
	@SuppressWarnings("null")
	@RequestMapping(value = UrlMapping.OTP_VALIDATE, method = RequestMethod.POST)
	public ResponseEntity validateOTP(@RequestBody ValidateOtp validateOtp) {

			return new ResponseEntity(service.validateOtp(validateOtp), HttpStatus.OK);
		}

}
