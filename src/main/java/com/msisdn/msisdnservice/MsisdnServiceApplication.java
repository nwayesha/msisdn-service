package com.msisdn.msisdnservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msisdn.msisdnservice.service.MsisdnService;

@SpringBootApplication
public class MsisdnServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MsisdnServiceApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.msisdn.msisdnservice");
		context.refresh();

		MsisdnService msisdnService = context.getBean(MsisdnService.class);
		msisdnService.runProcess();

		context.close();
	}

}
