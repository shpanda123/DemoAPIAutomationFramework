package com.api.listners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListners implements ITestListener {
	
	private static final Logger logger = LogManager.getLogger(TestListners.class);

	public void onTestStart(ITestResult result) {
		logger.info("Test Suite Started");
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Failed"+result.getMethod().getMethodName());
		logger.error("Description"+result.getMethod().getDescription());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Skipped"+result.getMethod().getMethodName());
		logger.info("Description"+result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Passed"+result.getMethod().getMethodName());
		logger.info("Description"+result.getMethod().getDescription());
	}
}
