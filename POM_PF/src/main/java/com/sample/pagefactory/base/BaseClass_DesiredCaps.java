//package com.sample.pagefactory.base;
//
//	import org.openqa.selenium.WebDriver;
//	import org.openqa.selenium.chrome.ChromeDriver;
//	import org.openqa.selenium.chrome.ChromeOptions;
//	import org.openqa.selenium.MutableCapabilities;
//	import org.openqa.selenium.firefox.FirefoxDriver;
//	import org.openqa.selenium.firefox.FirefoxOptions;
//	import org.testng.annotations.*;
//	import com.sample.pagefactory.utils.ConfigReader;
//
//	import java.lang.reflect.Method;
//
//	public class BaseClass_DesiredCaps {
//	    protected WebDriver driver;
//
//	    @Parameters("browser")
//	    @BeforeMethod
//	    public void setup(@Optional("chrome") String browser, Method method) {
//	        boolean isHeadless = Boolean.parseBoolean(ConfigReader.get("headless"));
//
//	        switch (browser.toLowerCase()) {
//	            case "chrome":
//	                ChromeOptions chromeOptions = new ChromeOptions();
//	                if (isHeadless) chromeOptions.addArguments("--headless=new");
//	                chromeOptions.setCapability("browserName", "chrome"); // DesiredCapability logic
//	                driver = new ChromeDriver(chromeOptions);
//	                break;
//
//	            case "firefox":
//	                FirefoxOptions firefoxOptions = new FirefoxOptions();
//	                if (isHeadless) firefoxOptions.addArguments("-headless");
//	                firefoxOptions.setCapability("browserName", "firefox");
//	                driver = new FirefoxDriver(firefoxOptions);
//	                break;
//
//	            default:
//	                throw new RuntimeException("Unsupported browser: " + browser);
//	        }
//
//	        driver.manage().window().maximize();
//	    }
//
//	    @AfterMethod
//	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }
//	}
//
//
