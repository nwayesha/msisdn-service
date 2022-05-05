package com.msisdn.msisdnservice.service;

import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msisdn.msisdnservice.configuration.ConfigProperties;
import com.msisdn.msisdnservice.model.MsisdnModel;

@Component
public class MsisdnService {
	final static Logger logger = LoggerFactory.getLogger(MsisdnService.class);

	@Autowired
	private FileReaderService fileReaderService;

	@Autowired
	private ConfigProperties configProp;

	@Autowired
	private FileWriterService fileWriterService;

	public void runProcess() {
		long startTime = System.nanoTime();
		logger.info("Start MsisdnDemo ..");

		final String inputFilePath = configProp.getConfigValue("input.file.path");
		final TreeSet<MsisdnModel> sortedSet = fileReaderService.readPhoneNumberFromFile(inputFilePath);

		final String outputFilePath = configProp.getConfigValue("output.file.path");
		fileWriterService.writeMsisdnNumberToFile(sortedSet, outputFilePath);

		logger.info("End MsisdnDemo ..");
		logger.info("Total execution time in milliseconds: " + ((System.nanoTime() - startTime) / 1000000) + " ms");
	}

}
