package com.dream.thoughts.springbootloggingdemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootLoggingDemoApplicationTests {

	final Logger logger = LoggerFactory.getLogger(SpringBootLoggingDemoApplicationTests.class);

	@Test
	void contextLoads() {
	}

	@Test
	void logtesting() {
		logger.trace("Testing Log TRACE");
		logger.debug("Testing log DEBUG");
		logger.warn("Testing log WARN");
		logger.error("Testing log ERROR");
		logger.info("Testing log INFO");
	}

}
