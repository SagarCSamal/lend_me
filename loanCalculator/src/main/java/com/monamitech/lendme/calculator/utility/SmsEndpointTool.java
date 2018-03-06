/**
 * 
 */
package com.monamitech.lendme.calculator.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monamitech.lendme.calculator.constant.*;
import com.monamitech.lendme.calculator.dao.CalculatorDaoImpl;
import com.monamitech.lendme.calculator.dao.ICalculatorDao;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * @author Sagar C Samal
 *
 *         Dec 12, 2017
 */
public class SmsEndpointTool {
	ICalculatorDao calculatorDao;

	private static SmsEndpointTool instance;
	private static String accountsUrl;

	private SmsEndpointTool() {
	}

	public static SmsEndpointTool getInstance() {

		if (instance == null)

			instance = new SmsEndpointTool();

		return instance;

	}

	@SuppressWarnings("finally")
	public String sendOtp(String mobileNumber,String otpCode) {
		String status = null;
		try {
			String adminAccountSid = "AC71f624c01eb06484a2479d1292e667dd";

			String adminAuthToken = "e69a0bc3087ca76126804092e74410c2";

			String url = "https://cloud.restcomm.com/restcomm/";

			// String from = "+91" + mobileNumber;

			// String to = "+91" + mobileNumber;

			String from = "+919555429700";

			String to = "+" + mobileNumber;
			String body = "Otp Code " + otpCode;
			String url1 = new SmsEndpointTool().getAccountsUrl(url, adminAccountSid, true);
			JsonObject callResult = SmsEndpointTool.getInstance().createSms(url1, adminAccountSid, adminAuthToken, from,
					to, body, null);

			if (!StatuCode.SENDING_SMS_TO_CONSUMER.equalsIgnoreCase(callResult.get("status").toString())) {
				status = StatuCode.SENDING_SMS_TO_CONSUMER_SUCESS;

			}

		} catch (Exception e) {
			status = StatuCode.SENDING_SMS_TO_CONSUMER_FAIL;

		} finally {
			return status;

		}

	}

	@SuppressWarnings("finally")
	public String sendMessageToMobileApp(String mobileNumber) {
		String status = null;
		try {
			String adminAccountSid = "AC71f624c01eb06484a2479d1292e667dd";

			String adminAuthToken = "e69a0bc3087ca76126804092e74410c2";

			String url = "https://cloud.restcomm.com/restcomm/";

			// String from = "+91" + mobileNumber;

			// String to = "+91" + mobileNumber;

			String from = "+919555429700";

			String to = "+" + mobileNumber;
			String body = "Congratulations your loan request has been approved .We thank you for giving us an opportunity to serve you and please wait our loan team will send complete details of your loan in specefied email id,thank you ";
			String url1 = new SmsEndpointTool().getAccountsUrl(url, adminAccountSid, true);
			JsonObject callResult = SmsEndpointTool.getInstance().createSms(url1, adminAccountSid, adminAuthToken, from,
					to, body, null);

			if (!StatuCode.SENDING_SMS_TO_CONSUMER.equalsIgnoreCase(callResult.get("status").toString())) {

				status = StatuCode.SENDING_SMS_TO_CONSUMER_SUCESS;

			}

		} catch (Exception e) {
			status = StatuCode.SENDING_SMS_TO_CONSUMER_FAIL;

		} finally {
			return status;

		}

	}

	@SuppressWarnings("finally")
	public String send(String mobileNumber) {
		String status = null;
		try {
			String adminAccountSid = "AC71f624c01eb06484a2479d1292e667dd";

			String adminAuthToken = "e69a0bc3087ca76126804092e74410c2";

			String url = "https://cloud.restcomm.com/restcomm/";

			// String from = "+91" + mobileNumber;

			// String to = "+91" + mobileNumber;

			String from = "+919555429700";

			String to = "+" + mobileNumber;
			String body = "Registered Successfully ";
			String url1 = new SmsEndpointTool().getAccountsUrl(url, adminAccountSid, true);
			JsonObject callResult = SmsEndpointTool.getInstance().createSms(url1, adminAccountSid, adminAuthToken, from,
					to, body, null);

			if (!StatuCode.SENDING_SMS_TO_CONSUMER.equalsIgnoreCase(callResult.get("status").toString())) {

				status = StatuCode.SENDING_SMS_TO_CONSUMER_SUCESS;

			}

		} catch (Exception e) {
			status = StatuCode.SENDING_SMS_TO_CONSUMER_FAIL;

		} finally {
			return status;

		}

	}

	private String getAccountsUrl(String deploymentUrl, String username, Boolean json) {

		if (accountsUrl == null) {

			if (deploymentUrl.endsWith("/")) {

				deploymentUrl = deploymentUrl.substring(0, deploymentUrl.length() - 1);

			}

			accountsUrl = deploymentUrl + "/2012-04-24/Accounts/" + username + "/SMS/Messages"
					+ ((json) ? ".json" : "");

		}
		return accountsUrl;

	}

	public JsonObject createSms(String deploymentUrl, String username, String authToken, String from, String to,
			String body, HashMap<String, String> additionalHeaders) {

		Client jerseyClient = Client.create();

		jerseyClient.addFilter(new HTTPBasicAuthFilter(username, authToken));

		String url = getAccountsUrl(deploymentUrl, username, true);

		WebResource webResource = jerseyClient.resource(url);

		String encoding = "GSM";

		MultivaluedMap<String, String> params = new MultivaluedMapImpl();

		params.add("From", from);

		params.add("To", to);

		params.add("Encoding", encoding);

		params.add("Body", body);

		if (additionalHeaders != null && !additionalHeaders.isEmpty()) {

			Iterator<String> iter = additionalHeaders.keySet().iterator();

			while (iter.hasNext()) {

				String headerName = iter.next();

				params.add(headerName, additionalHeaders.get(headerName));

			}

		}

		// webResource = webResource.queryParams(params);

		String response = webResource.accept(MediaType.APPLICATION_JSON).post(String.class, params);

		JsonParser parser = new JsonParser();

		JsonObject jsonObject = parser.parse(response).getAsJsonObject();

		return jsonObject;

	}

}
