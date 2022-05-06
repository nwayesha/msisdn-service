package com.msisdn.msisdnservice.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FinlandMsisdnNumber implements MsisdnNumber {
	final static Logger logger = LoggerFactory.getLogger(FinlandMsisdnNumber.class);

	@Override
	public String formatNumber(String number) {
		String msidnNumber = number.contains(Constants.DASH) ? number.replace(Constants.DASH, Constants.EMPTY_STR) : number;

		if (msidnNumber.startsWith(Constants.FINLAND_COUNTRY_CODE_1)) {
			msidnNumber = msidnNumber.substring(4, msidnNumber.length());

		} else if (msidnNumber.startsWith(Constants.ZERO)) {
			msidnNumber = msidnNumber.substring(1, msidnNumber.length());

		} else if (msidnNumber.startsWith(Constants.PLUSE)) {
			msidnNumber = msidnNumber.substring(3, msidnNumber.length());
		}
		return msidnNumber;

	}

	@Override
	public String getCountryCode() {		
		return Constants.FINLAND_COUNTRY_CODE_2;
	}
}
