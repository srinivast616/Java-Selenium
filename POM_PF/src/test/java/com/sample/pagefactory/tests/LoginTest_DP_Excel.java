package com.sample.pagefactory.tests;

import com.sample.pagefactory.base.BaseTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sample.pagefactory.pages.LoginPage;
import com.sample.pagefactory.utils.ExcelUtils;

public class LoginTest_DP_Excel extends BaseTest {

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        driver.get("https://practice.expandtesting.com/login");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
		Reporter.log("Entered user name");
		lp.setPassword(password);
		Reporter.log("Entered password");
		lp.clickLogin();
		Reporter.log("Click on Login button");        
		String title = driver.getTitle();
		Assert.assertEquals(title, "The Internet");	
		Reporter.log("Page title verified successfully");
        test.pass("Login test passed with user: " + username);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return ExcelUtils.getData(System.getProperty("user.dir")+"/src/main/resources/Test_Data.xlsx", "Sheet1");
    }
}
