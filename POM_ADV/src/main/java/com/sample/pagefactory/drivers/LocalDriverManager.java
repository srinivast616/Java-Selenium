package com.sample.pagefactory.drivers;

import com.sample.pagefactory.base.AbstractDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalDriverManager extends AbstractDriverManager {
    private String browser;
    private String mode;

    public LocalDriverManager(String browser, String mode) {
        this.browser = browser;
        this.mode = mode;
    }

    public WebDriver createDriver() {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (mode.equalsIgnoreCase("headless")) {
                options.addArguments("--headless");
            }
            return new ChromeDriver(options);
        }
        throw new RuntimeException("Unsupported browser");
    }
}
