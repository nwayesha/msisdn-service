package com.msisdn.msisdnservice.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.msisdn.msisdnservice.model.MsisdnModel;

@Service
public class FileReaderService {

	final static Logger logger = LoggerFactory.getLogger(FileReaderService.class);
	final private String ZERO = "0";
	final private String PLUSE = "+";
	final private String COUNTRY_CODE_1 = "0046";
	final private String DASH = "-";
	final private String EMPTY_STR = "";
	final private int SWEDEN_MIN_PHONE_NUMBER_LENGTH = 7;
	final private int SWEDEN_MAX_PHONE_NUMBER_LENGTH = 13;
	final private int SWEDEN_COUNTRY_CODE_LENGTH = 3;

	/** this is default value for BufferedReader buffer */
	final int INPUT_BUFFER_SIZE = 8192;

	/**
	 * 
	 * @param filepath
	 * @return
	 */
	public TreeSet<MsisdnModel> readPhoneNumberFromFile(final String filepath) {
		final TreeSet<MsisdnModel> sortedSet = new TreeSet<>();

		String line = "";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filepath)),
				INPUT_BUFFER_SIZE)) {
			while ((line = bufferedReader.readLine()) != null) {
				// logger.info(line);

				final String formattedPhoneNumber = validateAndFormat(line);
				// logger.info("line > " + line + " number > " +formattedPhoneNumber);

				if (!formattedPhoneNumber.isEmpty()) {
					final MsisdnModel model = new MsisdnModel();
					model.setPhoneNumber(Long.parseLong(formattedPhoneNumber));
					model.setCount(1);
					sortedSet.add(model);
				}
			}
		} catch (IOException e) {
			logger.error("FileReaderUtils==> readFile(): " + line, e);
		}

		return sortedSet;
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	private String validateAndFormat(final String number) {
		String msidnNumber = number.contains("-") ? number.replace(DASH, EMPTY_STR) : number;

		if (msidnNumber.startsWith(COUNTRY_CODE_1)) {
			msidnNumber = msidnNumber.substring(3, msidnNumber.length());

		} else if (msidnNumber.startsWith(ZERO)) {
			msidnNumber = msidnNumber.substring(1, msidnNumber.length());

		} else if (msidnNumber.startsWith(PLUSE)) {
			msidnNumber = msidnNumber.substring(3, msidnNumber.length());
		}

		if (msidnNumber.length() < (SWEDEN_MIN_PHONE_NUMBER_LENGTH - SWEDEN_COUNTRY_CODE_LENGTH)
				|| msidnNumber.length() > (SWEDEN_MAX_PHONE_NUMBER_LENGTH - SWEDEN_COUNTRY_CODE_LENGTH)) {

			logger.info("invalid number > " + msidnNumber + " length:" + msidnNumber.length());
			msidnNumber = "";
		}
		return msidnNumber;
	}

}
