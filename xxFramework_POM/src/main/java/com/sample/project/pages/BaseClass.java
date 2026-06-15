package com.sample.project.pages;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.JavascriptExecutor;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;
	
	@BeforeSuite

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			// setup Chrome WebDriver
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			// setup Firefox WebDriver
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			// setup IE WebDriver
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		// Add implicit wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + result + "screenshot.png"));
	}

	/*
	 * This method is used to set up the test environment. It initializes the
	 * WebDriver and opens the Google Home Page.
	 */

	@BeforeTest
	public void setUp() {
		
		// Navigating to the Google Home Page.
		driver.get(prop.getProperty("url"));
		// Setting the implicit wait time.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void close() {
		// Quitting the WebDriver.
		driver.close();
	}


	@AfterSuite
	public void quit() {
		// Quitting the WebDriver.
		driver.quit();

	}	
	
	
}


