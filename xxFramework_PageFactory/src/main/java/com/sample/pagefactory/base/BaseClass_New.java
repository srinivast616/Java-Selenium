package com.sample.pagefactory.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sample.pagefactory.utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class BaseClass_New {

	protected WebDriver driver;
	private String baseUrl;
	private String browser;
	private String environment;
	
	// Create an ExtentReports instance
    public static ExtentReports extent;
    public static ExtentTest test;

	// This method will be called before every test method execution
	@BeforeMethod
	@Parameters("browser") // Parameter from the testng.xml file to choose the browser
	public void setUp(String browser) {
		this.browser = ConfigReader.getBrowser(); // Fetch browser from config.properties
		this.baseUrl = ConfigReader.getAppUrl(); // Fetch app URL from config.properties
		this.environment = ConfigReader.getEnvironment(); // Fetch environment from config.properties

		// Log the environment and browser being used
		System.out.println("Running tests on: " + environment);
		System.out.println("Using browser: " + browser);

		driver = getDriver(this.browser); // Initialize the WebDriver
		driver.get(baseUrl); // Navigate to the application URL
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
			driver.quit(); // Close the browser
		}
	}

	// Getter method for WebDriver to be used in test classes and page classes
	// Getter method for WebDriver to be used in test classes and page classes
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
