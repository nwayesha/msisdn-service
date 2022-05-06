package com.msisdn.msisdnservice.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SwedenMsisdnNumber implements MsisdnNumber {
	final static Logger logger = LoggerFactory.getLogger(SwedenMsisdnNumber.class);

	@Override
	public String validationNumber(String number) {
		String msisdn = number.contains(Constants.DASH) ? number.replace(Constants.DASH, Constants.EMPTY_STR) : number;

		if (msisdn.startsWith(Constants.SWEDEN_COUNTRY_CODE_1)) {
			msisdn = msisdn.substring(4, msisdn.length());

		} else if (msisdn.startsWith(Constants.ZERO)) {
			msisdn = msisdn.substring(1, msisdn.length());

		} else if (msisdn.startsWith(Constants.PLUSE)) {
			msisdn = msisdn.substring(3, msisdn.length());
		}

		if (msisdn.length() < (Constants.SWEDEN_MIN_PHONE_LENGTH - Constants.SWEDEN_COUNTRY_CODE_LENGTH)
				|| msisdn
						.length() > (Constants.SWEDEN_MAX_PHONE_LENGTH - Constants.SWEDEN_COUNTRY_CODE_LENGTH)) {

			logger.info("invalid number > " + msisdn);
			msisdn = "";
		}
		return msisdn;
	}

	@Override
	public String getCountryCode() {		
		return Constants.SWEDEN_COUNTRY_CODE_2;
	}
}
