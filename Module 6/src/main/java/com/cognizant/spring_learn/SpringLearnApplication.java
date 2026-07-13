package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Inside main method");
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
	}

	private static void displayDate() {
		LOGGER.info("START");
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
			SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
			Date date = format.parse("31/12/2018");
			LOGGER.debug(date.toString());
		} catch (Exception e) {
			LOGGER.error("Error displaying date", e);
		}
		LOGGER.info("END");
	}

}
