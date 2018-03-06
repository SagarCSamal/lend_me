package com.monamitech.lendme.calculator.utility;

import com.monamitech.lendme.calculator.dto.IntrestRateResponse;
import com.monamitech.lendme.calculator.dto.LoanIntRequest;
import com.monamitech.lendme.calculator.dto.LoanIntResponse;
import com.monamitech.lendme.calculator.model.LoanIntrestRateCalculation;

public class LoanCalculator {

	public static LoanIntrestRateCalculation getToatlAmont(LoanIntResponse response) {

		LoanIntrestRateCalculation IntrestRateCalculation = new LoanIntrestRateCalculation();

		return IntrestRateCalculation;

	}

	public static long getAmontPerEmi(IntrestRateResponse response,LoanIntRequest loanIntrestRate) {
		return 0;
		//long amount = getLoanAmount(response,loanIntrestRate) / response.getTenure();

		//return amount;

	}

	public static long getLoanAmount(IntrestRateResponse response,LoanIntRequest loanIntrestRate) {
		return 0;

		//sdouble intrestAmount = (double) response.getIntrestRate() / 100;
		//double totalintrestAmount = (intrestAmount *loanIntrestRate.getLoanAmount()) +loanIntrestRate.getLoanAmount();
		//long value = (long) totalintrestAmount;

		//return value;

	}
}
