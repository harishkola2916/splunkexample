/**
 * 
 */
package com.example.splunkdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splunk.logging.SplunkCimLogEvent;

/**
 * @author haree
 *
 */
@RestController
public class SplunkController {

	Logger logger = LogManager.getLogger("splunk.secure.logger");

	@RequestMapping("/welcome")
	public String firstPage() {

		logger.info(new SplunkCimLogEvent("Failed Login",
				"ssh: failurefsfdsdfsdfsdfsf-d") {
			{
				addField("name", "value");

				// addThrowableWithStacktrace(ex);

				setAuthUser("flashleo");
			}
		});
		helperMethod();
		logger.info("This is a test event for Logback test");
		logger.error("This is a test error for Logback test");
		return "Hello Welcom String";
	}

	public void helperMethod() {
		logger.info("This is a test event for helper method");
		logger.error("This is a test error for helper method");
	}

}
