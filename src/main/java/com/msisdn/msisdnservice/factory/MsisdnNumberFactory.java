package com.msisdn.msisdnservice.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsisdnNumberFactory {

	@Autowired
	private SwedenMsisdnNumber swedenMsisdnNumber;

	@Autowired
	private FinlandMsisdnNumber finlandMsisdnNumber;

	public MsisdnNumber getFactory(String country) {

		switch (country) {
		case Constants.SWEDEN:
			return swedenMsisdnNumber;

		case Constants.FINLAND:
			return finlandMsisdnNumber;

		default:
			throw new IllegalArgumentException(country + " is not supported yet");
		}

	}
}
