package com.dream.thoughts.springbootloggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingDemoApplication {

	public static void main(String[] args) {

		final Logger logger = LoggerFactory.getLogger(SpringBootLoggingDemoApplication.class);

		SpringApplication.run(SpringBootLoggingDemoApplication.class, args);
		logger.debug("--Application Started--");
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
	}

}
