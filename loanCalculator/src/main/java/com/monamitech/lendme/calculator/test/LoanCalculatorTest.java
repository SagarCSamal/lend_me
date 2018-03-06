package com.monamitech.lendme.calculator.test;

public class LoanCalculatorTest {
	public static final String SERVER_URI = "http://localhost:2222/loanCalculator/rest/emp/dummy";

	/*public static void main(String args[]) {
		testCreateEmployee();
	}*/

	/*private static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		IntrestRateReq request = new IntrestRateReq();
		request.setAmount(1234);
		request.setLoanTenure(4);
		request.setProductId("sahgr");
		IntrestRateResponse response = restTemplate.postForObject(SERVER_URI, request, IntrestRateResponse.class);
		System.out.println(response);
	}
*/
}
