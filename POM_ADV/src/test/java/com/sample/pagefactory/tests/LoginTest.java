package com.sample.pagefactory.tests;

import com.sample.pagefactory.base.BaseTest;
import com.sample.pagefactory.pages.LoginPage;
import com.sample.pagefactory.utils.ConfigReader;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class LoginTest extends BaseTest { 
	
//	WebDriver driver;	
//	@BeforeClass
//	void Setup()
//	{	
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get(ConfigReader.get("url"));
//	}	
	
	
	@Test
	void testLogin() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(ConfigReader.get("username"));
		Reporter.log("Entered user name");
		lp.setPassword(ConfigReader.get("password"));
		Reporter.log("Entered password");
		lp.clickLogin();
		Reporter.log("Clicked on Login button");	
		String title = driver.getTitle();
		Assert.assertEquals(title, "Secure Page page for Automation Testing Practice");	
		Reporter.log("Title displayed successfully");
	}
	
	@AfterClass
	void Teardown()
	{
		driver.quit();
	}
    
}