package com.bdd.hooks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.bdd.utils.DriverFactory;
import com.bdd.utils.ScreenshotUtil;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

//@Hooks
public class Hooks {
    ExtentReports extent = new ExtentReports();
    ExtentTest test;

    @Before
    public void launchBrowser() {
        DriverFactory.initDriver();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String path = ScreenshotUtil.captureScreenshot(scenario.getName());
            scenario.attach(Files.readAllBytes(Paths.get(path)), "image/png", "screenshot");
        }
    }

    @After
    public void quitBrowser() {
//        DriverFactory.getDriver().quit();
        DriverFactory.quitDriver();
    }
}
