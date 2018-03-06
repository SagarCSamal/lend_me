package com.monamitech.lendme.calculator.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.monamitech.lendme.calculator.constant.StatuCode;
import com.monamitech.lendme.calculator.dto.CheckEmiratesID;
import com.monamitech.lendme.calculator.dto.EligibilityCriteriaResponse;
import com.monamitech.lendme.calculator.dto.IntrestRateResponse;
import com.monamitech.lendme.calculator.dto.LoanCalculator;
import com.monamitech.lendme.calculator.dto.LoanIntRequest;
import com.monamitech.lendme.calculator.dto.LoanIntResponse;
import com.monamitech.lendme.calculator.dto.Message;
import com.monamitech.lendme.calculator.dto.OtpValidation;
import com.monamitech.lendme.calculator.dto.TenureCriteria;
import com.monamitech.lendme.calculator.request.MobileNumberValidation;
import com.monamitech.lendme.calculator.request.ValidateOtp;
import com.monamitech.lendme.calculator.service.OtpMapper;
import com.monamitech.lendme.calculator.utility.SmsEndpointTool;

public class CalculatorDaoImpl implements ICalculatorDao {
	private static final Logger logger = LoggerFactory.getLogger(CalculatorDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<IntrestRateResponse> getRate() {
		String sql = "select * from monamitechdb.testProduct";
		logger.info("jdbcTemplate" + jdbcTemplate);
		List<IntrestRateResponse> intrestRate = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<IntrestRateResponse>(IntrestRateResponse.class));

		return intrestRate;

	}

	@Override
	public LoanIntResponse calculateLoan(LoanIntRequest loanIntrestRate) {

		String sql1 = "select * from monamitechdb.testProduct WHERE productid=? ";
		// String sql = "Select * from lend_me_db.testproductintrestrate where productid
		// =? and tenure =? and ? between 'minimumamount' and 'maxAmount'";
		// String sql="SELECT * FROM testproductintrestrate WHERE productid =? AND
		// tenure = ? AND(? between 'minimumamount' AND 'maxAmount')";
		String sql = "SELECT * FROM monamitechdb.testproductintrestrate WHERE productid =? AND tenure = ? AND(?>= `minimumamount` AND ?<= `maxAmount` )";
		LoanCalculator loanIntResponse = (LoanCalculator) jdbcTemplate.queryForObject(sql,
				new Object[] { loanIntrestRate.getProductId(), loanIntrestRate.getTenure(),
						loanIntrestRate.getLoanAmount(), loanIntrestRate.getLoanAmount() },
				new BeanPropertyRowMapper<LoanCalculator>(LoanCalculator.class));	

		IntrestRateResponse loanIntResponse2 = jdbcTemplate.queryForObject(sql1,
				new Object[] { loanIntrestRate.getProductId() },
				new BeanPropertyRowMapper<IntrestRateResponse>(IntrestRateResponse.class));

		double intrest1 = loanIntResponse.getIntrestRate();

		double loanIntrestAmount = (intrest1 / 100) * loanIntrestRate.getLoanAmount();
		// double loanIntrestAmount = intrest1* loanIntrestRate.getLoanAmount();

		double totalLoanAmountwithIntRest1 = loanIntrestAmount + loanIntrestRate.getLoanAmount() + .00;

		double loanEmiPerMonth1 = totalLoanAmountwithIntRest1 / loanIntrestRate.getTenure();

		double loanEmiPerMonth = (double) Math.round(loanEmiPerMonth1 * 100) / 100;
		DecimalFormat df = new DecimalFormat("###.##");
		double totalLoanAmountwithIntRest = (double) Math.round(totalLoanAmountwithIntRest1 * 100) / 100;
		LoanIntResponse loanIntRestResponse = new LoanIntResponse();
		loanIntRestResponse.setProduct(loanIntResponse2.getProductname());
		String srt = String.valueOf(loanIntrestRate.getLoanAmount());
		double bd1 = loanIntrestRate.getLoanAmount();
		double ffgds = bd1 + 0.00;
		int decimalPlaces = 2;
		BigDecimal bd = new BigDecimal(loanIntrestRate.getLoanAmount());

		// setScale is immutable
		bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
		double r = bd.doubleValue();

		loanIntRestResponse.setLoanAmount(loanIntrestRate.getLoanAmount());
		loanIntRestResponse.setEmiAmountPermonth(loanEmiPerMonth);
		loanIntRestResponse.setTotalLoanAmount(Double.parseDouble(df.format(totalLoanAmountwithIntRest)));
		loanIntRestResponse.setIntrestRate(loanIntResponse.getIntrestRate());
		loanIntRestResponse.setTenure(loanIntrestRate.getTenure());

		return loanIntRestResponse;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monamitech.lendme.calculator.dao.ICalculatorDao#checkEmiratesId(com.
	 * monamitech.lendme.calculator.dto.CheckEmiratesID)
	 */
	@Override
	public boolean checkEmiratesId(CheckEmiratesID checkEmiratesId) {
		String sql = "SELECT * FROM MonamiTechDBs.LoanIntrestRest WHERE id=?";

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monamitech.lendme.calculator.dao.ICalculatorDao#
	 * getEligibilityCriteriaResponse()
	 */
	@Override
	public List<EligibilityCriteriaResponse> getEligibilityCriteriaResponse() {
		String sql = "select * from  monamitechdb.eligibilityCriteria";

		logger.info("jdbcTemplate" + jdbcTemplate);
		List<EligibilityCriteriaResponse> eligibilityCriteriaResponse = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<EligibilityCriteriaResponse>(EligibilityCriteriaResponse.class));

		return eligibilityCriteriaResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monamitech.lendme.calculator.dao.ICalculatorDao#validTenure(int)
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean validTenure(LoanIntRequest loanIntRequest) {

		boolean flag = false;

		String sql = "SELECT * FROM monamitechdb.testproductintrestrate WHERE productid =? AND tenure = ? AND(?>= `minimumamount` AND ?<= `maxAmount` )";
		try {
			LoanCalculator loanIntResponse = (LoanCalculator) jdbcTemplate.queryForObject(sql,
					new Object[] { loanIntRequest.getProductId(), loanIntRequest.getTenure(),
							loanIntRequest.getLoanAmount(), loanIntRequest.getLoanAmount() },
					new BeanPropertyRowMapper<LoanCalculator>(LoanCalculator.class));

			if (null != loanIntResponse) {
				flag = true;
			}
		} catch (Exception e) {
			logger.error("nodata found");
			return flag;
		} finally {
			return flag;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monamitech.lendme.calculator.dao.ICalculatorDao#getTenureCriteria()
	 */
	@Override
	public List<TenureCriteria> getTenureCriteria() {
		String sql = "SELECT tenure,productid FROM monamitechdb.testproductintrestrate";
		List<TenureCriteria> tenureCriteria = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<TenureCriteria>(TenureCriteria.class));
		return tenureCriteria;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.monamitech.lendme.calculator.dao.ICalculatorDao#validateInputLoanAmount(
	 * com.monamitech.lendme.calculator.dto.LoanIntRequest)
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean validateInputLoanAmount(LoanIntRequest loanIntRequest) {

		boolean flag = false;

		String sql1 = "select * from monamitechdb.testProduct WHERE maxLoanValue>=? AND productid =? ";
		try {
			IntrestRateResponse loanIntResponse2 = jdbcTemplate.queryForObject(sql1,
					new Object[] { loanIntRequest.getLoanAmount(), loanIntRequest.productId },
					new BeanPropertyRowMapper<IntrestRateResponse>(IntrestRateResponse.class));

			flag = true;
		} catch (Exception e) {

			logger.error("nodata found");
			return flag;
		} finally {
			return flag;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.monamitech.lendme.calculator.dao.ICalculatorDao#otpsend(com.monamitech.
	 * lendme.calculator.request.MobileNumberValidation)
	 */
	@SuppressWarnings("finally")
	@Override
	public Message otpsend(final MobileNumberValidation mobileNumberValidation, String otpCode) {
		Message messageResponse = new Message();
		String sql = "INSERT INTO otptable(mobilenumber,sentOtpNumber,otpstatus,otpcreatetimeing,otpTimeStamp,otpUpdateTimeStamp ) "+ "VALUES (?, ?, ?, ?,?,?)";
		String sql_update = "UPDATE otptable SET sentOtpNumber=?, otpcreatetimeing=?,"+ "otpUpdateTimeStamp=? WHERE mobilenumber=?";
		final String status = "pending";

		String sql_otp_exist ="select * from otptable WHERE mobilenumber=? AND otpstatus =? ";
		//String sql_otp_exist ="select * from otptable WHERE mobilenumber=?";
		
		
		List <OtpValidation> otpisexist = jdbcTemplate.query(sql_otp_exist,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				 preparedStatement.setString(1,mobileNumberValidation.getPhoneNumber());
		            preparedStatement.setString(2,status);
				
			}
		},  new OtpMapper());
		Date date = new Date();
		try {
			if (!otpisexist.isEmpty()) {
				
			jdbcTemplate.update(sql_update,new Object[]{otpCode,date.getMinutes() *60000, new Date(),mobileNumberValidation.getPhoneNumber()});
			

		}
		else {
			jdbcTemplate.update(sql, new Object[] { mobileNumberValidation.phoneNumber,otpCode,"pending", date.getMinutes() * 60000, new Date(), new Date() });
			
		}
			
			SmsEndpointTool sendSms = SmsEndpointTool.getInstance();
			String smsresponse = sendSms.sendOtp(mobileNumberValidation.getPhoneNumber(), otpCode);
			if (StatuCode.SENDING_SMS_TO_CONSUMER_SUCESS.equals(smsresponse)) {
				messageResponse.setStatus(StatuCode.SUCCESS);
				messageResponse.setMessage(StatuCode.SUCCESS_OTP);

			}

		} catch (Exception e) {

			messageResponse.setStatus(StatuCode.FAIL);

			messageResponse.setMessage(StatuCode.Un_SUCCESS_OTP);

		} finally {
			return messageResponse;
		}
	}

	/* (non-Javadoc)
	 * @see com.monamitech.lendme.calculator.dao.ICalculatorDao#deleteotp()
	 */
	@Override
	public void deleteotp(String statuscode) {
		String sql = "delete from otptable where otpstatus = ?";
        jdbcTemplate.update(sql,new Object[]{statuscode});
		
	}

	/* (non-Javadoc)
	 * @see com.monamitech.lendme.calculator.dao.ICalculatorDao#validateOtp(com.monamitech.lendme.calculator.request.ValidateOtp)
	 */
	@Override
	public Message validateOtp(final ValidateOtp validateOtp) {
		Message messageResponse = new Message();
		final String status = "pending";

		String sql_otp_exist ="select * from otptable WHERE mobilenumber=? AND otpstatus =? AND sentOtpNumber=?";
		String sql_otp_validate = "UPDATE otptable SET otpstatus=? WHERE mobilenumber=?";
		final String sucess_status = "validate";
		
		
		List <OtpValidation> otpisexist = jdbcTemplate.query(sql_otp_exist,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				 preparedStatement.setString(1,validateOtp.getPhoneNumber());
		            preparedStatement.setString(2,status);
		            preparedStatement.setString(3,validateOtp.getOtpCode());
				
			}
		},  new OtpMapper());
		//int count=new Date().getMinutes()*60000-Integer.parseInt(otpisexist.get(0).getOtpcreatetimeing());
		if(!otpisexist.isEmpty()) {
			jdbcTemplate.update(sql_otp_validate,new Object[]{sucess_status,validateOtp.getPhoneNumber()});
			messageResponse.setStatus(StatuCode.VALID_OTP);
			messageResponse.setMessage(StatuCode.OTP_VALIDATE_SUCESS);
			
		}
		else {
			messageResponse.setStatus(StatuCode.INVALID_OTP);
			messageResponse.setMessage(StatuCode.IN_OTP_VALIDATE);
			
		}
		
		return messageResponse;
	}

}
