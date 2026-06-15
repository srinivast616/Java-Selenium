package com.sample.pagefactory.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
 

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;    
 

    public static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
        }
        return extent;
    }

    public static void startTest(String testName) {
        test = extent.startTest(testName);
        
    }

    public static void endTest() {
        extent.endTest(test);
    }

    public static void logTestResult(String message) {
        test.log(com.relevantcodes.extentreports.LogStatus.INFO, message);
    }
}