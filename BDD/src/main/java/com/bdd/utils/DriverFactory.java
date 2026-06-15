package com.bdd.utils;

import java.net.URI;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	public static WebDriver driver;

	public static void initDriver() {

		if (driver != null) {
			return; // avoid re-initialization
		}

		String browser = System.getenv("BROWSER");

		if ("remote".equalsIgnoreCase(browser)) {
			try { // try block can be for both if and else blocks

//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setBrowserName("chrome");
//        	  driver = new RemoteWebDriver(new URL("http://chrome:4444/wd/hub"), caps);

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				options.setCapability("someCapability", true); // optional custom capabilities

				URL gridUrl = URI.create("http://chrome:4444/wd/hub").toURL();
				driver = new RemoteWebDriver(gridUrl, options);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			
			driver = new ChromeDriver(); // fallback for local
		}
		
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			initDriver();
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			getDriver().quit();
			driver = null;
		}
	}
}