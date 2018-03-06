package com.monamitech.lendme.calculator.constant;

public class StatuCode {
	public static final int SUCCESS = 1;
	public static final int FAILURE_WITH_RESPONSE = 2;
	public static final int FAILURE_WITH_NO_RESPONSE = 3;
	public static final int WARN = 4;
	public static final int FAIL = 0;
	public static final int INVALID_OTP = 9;
	public static final int VALID_OTP = 7;

	public static final String SUCCESS_MESSAGE = "Sucess";
	public static final String SUCCESS_OTP = "Otp Sent Sucessfully";
	public static final String  OTP_VALIDATE_SUCESS = "Otp Validate Sucessfully";
	public static final String  IN_OTP_VALIDATE= "Invalid otp";
	public static final String Un_SUCCESS_OTP = "Otp Cant Sent Sucessfully";
	public static final String DATA_MESSAGE = "No offer is available";
	public static final int NO_DATA=5;
	public static final String NO_QUESTION_AVAILABLE = "No Question and Answer is available";
	public static final int NO_TENURE_FIND_CODE=7;
	public static final int MAX_LOAN_AMOUNT_CODE=8;
	public static final String NO_TENURE_FIND_DESC_MESSAGE="No Tenure Found in Our Loan System";
	public static final String NO_LOAN_AMOUNT_FOUND_DESC_MESSAGE="Loan Amount is higher than product Amount,So please enter lower amount";

	public static final String SENDING_SMS_TO_CONSUMER = "sending";
	public static final String SENDING_SMS_TO_CONSUMER_SUCESS = "105";
	public static final String SENDING_SMS_TO_CONSUMER_FAIL = "106";
	public static final String desc_un_SUCCESS_MESSAGE = "fail";
}
