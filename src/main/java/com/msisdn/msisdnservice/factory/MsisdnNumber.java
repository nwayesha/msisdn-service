package com.msisdn.msisdnservice.factory;

public interface MsisdnNumber {
	String getCountryCode();

	String validationNumber(String number);

}
