package com.sample.pagefactory.utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started: " + context.getName());        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getTestName());
        // Add code here to take a screenshot, log details, etc.
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getTestName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test run finished." + context.getName());
    }
}