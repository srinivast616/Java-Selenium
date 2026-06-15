package com.sample.pagefactory.reports;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHTMLReporter;
import com.sample.pagefactory.interfaces.ReportManager;

public class ExtentReportManager implements ReportManager {
	private static ExtentReports extent;
	private static ExtentTest suiteLogger;

	public static ExtentReports getInstance() {
		if (extent == null) {
//        ExtentHtmlReporter html = new ExtentHtmlReporter("reports/report.html");
			ExtentReporter htmlReporter = new ExtentReporter("test-output/extent-report.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.attachReporter(htmlReporter);
		}
		return extent;
	}

	
	public static void initSuiteLogger(String suiteName) {
		suiteLogger = getInstance().createTest("[SUITE INIT] " + suiteName);
	}
	
	@Override
	public void logPass(String msg) {
		suiteLogger.pass(msg);
	}

	@Override
	public void logFail(String msg) {
		suiteLogger.fail(msg);
	}
	
	@Override
	public void flush() {
		extent.flush();
	}
	
	@Override
	public void attachScreenshot(String path) {
		suiteLogger.addScreenCaptureFromPath(path);
	}
}
