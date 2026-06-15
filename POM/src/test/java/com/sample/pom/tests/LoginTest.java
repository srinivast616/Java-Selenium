package com.sample.pom.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sample.pom.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class LoginTest  {
	
	WebDriver driver;
	
	@BeforeClass
	void Setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/login");
	}	
	
	@Test
	void testLogin()
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName("tomsmith");
		lp.setPassword("SuperSecretPassword!");
		lp.clickLogin();
		String title = driver.getTitle();
		Assert.assertEquals(title, "The Internet");	
	}
	
	@AfterClass
	void Teardown()
	{
		driver.quit();
	}
    
}