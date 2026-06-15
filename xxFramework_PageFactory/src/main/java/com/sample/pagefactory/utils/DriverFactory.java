package com.sample.pagefactory.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
            driver = new EdgeDriver();
        }
        
        return driver;
    }
}
