package com.sample.project.tests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sample.project.pages.BaseClass;
import com.sample.project.pages.GoogleSearchPage_PF;
import com.sample.project.pages.GoogleSearchPage_POM;

public class GoogleSearch {
	
	WebDriver driver;
	
	GoogleSearchPage_PF gs = new GoogleSearchPage_PF(driver);
	/*
	 * This class contains the test methods for Google Home Page.
	 */

	
	/*
	 * This method contains the actual test steps. It creates an object of
	 * GoogleHomePage class and calls its respective methods.
	 */
	
	@BeforeClass
    public void setup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver = new ChromeDriver(options);
		
        driver.get("https://google.com");

        // Initialize Page Object
//        GoogleSearchPage_PF gs = new GoogleSearchPage_PF(driver);
    }

	
	
	@Test(priority = 0)
	public void googleSearch() {
		// Creating an object of GoogleHomePage class.
//		GoogleSearchPage_POM gs = new GoogleSearchPage_POM(driver);
//		GoogleSearchPage_PF gs = PageFactory.initElements(driver, GoogleSearchPage_PF.class);
//		LoginPageNew login_page=PageFactory.initElements(driver, LoginPageNew.class)

//	    gs.title();
		gs.search();
		gs.submit();
	}
	
	 @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }	

}
