package com.msisdn.msisdnservice.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msisdn.msisdnservice.configuration.ConfigProperties;
import com.msisdn.msisdnservice.factory.MsisdnNumberFactory;
import com.msisdn.msisdnservice.model.MsisdnModel;

@Service
public class FileReaderService {

	final static Logger logger = LoggerFactory.getLogger(FileReaderService.class);

	/** this is default value for BufferedReader buffer */
	final int BUFFER_SIZE = 8192;

	@Autowired
	private MsisdnNumberFactory msisdnNumberFactory;

	@Autowired
	private ConfigProperties configProp;

	/**
	 * 
	 * @param filepath
	 * @return
	 */
	public TreeSet<MsisdnModel> readPhoneNumberFromFile(final String filepath) {
		final TreeSet<MsisdnModel> sortedTreeSet = new TreeSet<>();
		final String country = configProp.getConfigValue("enable.country.name");

		String line = "";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filepath)), BUFFER_SIZE)) {
			while ((line = bufferedReader.readLine()) != null) {
				// logger.info(line);

				final String formattedPhoneNumber = msisdnNumberFactory.getFactory(country).formatNumber(line);				
				// logger.info("line > " + line + " number > " +formattedPhoneNumber);

				if (!formattedPhoneNumber.isEmpty()) {
					final MsisdnModel model = new MsisdnModel();
					model.setPhoneNumber(Long.parseLong(formattedPhoneNumber));
					model.setCount(1);
					sortedTreeSet.add(model);
				}
			}
		} catch (IOException e) {
			logger.error("FileReaderUtils==> readFile(): " + line, e);
		}

		return sortedTreeSet;
	}

}
