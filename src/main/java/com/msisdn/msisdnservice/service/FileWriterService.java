package com.msisdn.msisdnservice.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.msisdn.msisdnservice.model.MsisdnModel;

@Service
public class FileWriterService {

	final static Logger logger = LoggerFactory.getLogger(FileWriterService.class);
	private static final String COUNTRY_CODE = "+46";

	/**
	 * 
	 * @param sortedSet
	 * @param outputpath
	 */
	public void writeMsisdnNumberToFile(final TreeSet<MsisdnModel> sortedSet, final String outputpath) {
		try {
			File file = new File(outputpath);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
			}

			try (FileWriter writer = new FileWriter(file); 
					BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

				logger.info("sortedSet.size(): " + sortedSet.size());
				for (MsisdnModel model : sortedSet) {
					bufferedWriter.write(COUNTRY_CODE + model.getPhoneNumber() + ";" + model.getCount());
					bufferedWriter.newLine();
				}
			}
		} catch (Exception e) {
			logger.error("FileWriterUtils==> writeFile()", e);
		}
	}

}
