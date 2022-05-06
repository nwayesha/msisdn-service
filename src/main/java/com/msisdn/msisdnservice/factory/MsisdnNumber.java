package com.msisdn.msisdnservice.factory;

public interface MsisdnNumber {
	String getCountryCode();

	String formatNumber(String number);

}
