package com.sample.pagefactory.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.sample.pagefactory.utils.ConfigReader;
import com.sample.pagefactory.utils.ExtentManager;
import com.sample.pagefactory.utils.ScreenshotUtils;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
	
	protected static WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
	protected static RemoteWebDriver rdriver;
	
//	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();	
//	public static WebDriver getDriver() {
//        return driver.get(ConfigReder.get("url"));
//        BaseTest.getDriver().get(ConfigReader.get("url"));/    }	
	
	@Parameters({"browser"})
    @BeforeTest
    public void setup(@Optional("chrome") String browser, Method method) {
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());

        boolean isHeadless = Boolean.parseBoolean(ConfigReader.get("headless"));
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) {
                options.addArguments("--headless=new", "--window-size=1920,1080");
            }
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) {
                options.addArguments("-headless");
            }
            driver = new FirefoxDriver(options);
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
    }
	
	@BeforeMethod
	public void launchURL()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(ConfigReader.get("url"));
	}

	@AfterSuite
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
			test.fail("Test failed", ScreenshotUtils.addScreenshotToReport(screenshotPath));
		}
		if (driver != null) {
			driver.quit();
		}
		extent.flush();
	}
}
