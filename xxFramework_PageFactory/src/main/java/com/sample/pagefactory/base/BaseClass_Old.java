package com.sample.pagefactory.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass_Old {

    protected WebDriver driver;
    private String baseUrl = "https://www.example.com"; // Base URL for the application under test

    // Create an ExtentReports instance
    public static ExtentReports extent;
    public static ExtentTest test;

    // This method will be called before every test method execution
    @BeforeMethod
    @Parameters("browser")  // Parameter from the testng.xml file to choose the browser
    public void setUp(String browser) {
        driver = getDriver(browser);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Initialize ExtentReports
        extent = new ExtentReports("test-output/ExtentReport.html", true);
        test = extent.startTest("Login Test");
    }

    // This method returns the appropriate WebDriver instance based on the browser parameter
    public WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
            return new EdgeDriver();
        }
        return null;
    }

    // This method will be called after every test method execution
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser
        }

        // End the test and write the results to the report
        extent.endTest(test);
        extent.flush();  // Write the report to disk
    }

    // Getter method for WebDriver to be used in test classes
    public WebDriver getDriver() {
        return driver;
    }
}