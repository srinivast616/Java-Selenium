package com.sample.pagefactory.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sample.pagefactory.utils.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;
    private String baseUrl; 
    private String browser;
	private String environment;
	private String finalUrl;

    // Create an ExtentReports instance
    public static ExtentReports extent;
    public static ExtentTest test;

    // This method will be called before every test method execution
    @BeforeMethod
//    @Parameters("browser")  // Parameter from the testng.xml file to choose the browser
  
//   public void setUp(@Optional String browser) {
    public void setUp() {
    	
    	this.browser = ConfigReader.getBrowser(); // Fetch browser from config.properties
		this.baseUrl = ConfigReader.getAppUrl(); // Fetch app URL from config.properties
		this.environment = ConfigReader.getEnvironment(); // Fetch environment from config.properties

		// Log the environment and browser being used
		System.out.println("Running tests on: " + environment);
		System.out.println("Using browser: " + browser);
    	
        driver = getDriver(this.browser);
        
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Initialize ExtentReports
        extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
        test = extent.startTest("Login Test");
    }

    // This method returns the appropriate WebDriver instance based on the browser parameter
    public WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
//            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/main/resources/edgedriver.exe");
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
    
 // Getter method for Base URL (optional if you need to use it directly)
 	public String getBaseUrl() {
 		return baseUrl;
 	}

 	// Getter method for Environment (optional if you need to use it directly)
 	public String getEnvironment() {
 		return environment;
 	}
}