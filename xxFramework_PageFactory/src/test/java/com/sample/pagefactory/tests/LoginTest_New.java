package com.sample.pagefactory.tests;

import com.sample.pagefactory.base.BaseClass_New;
import com.sample.pagefactory.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest_New extends BaseClass_New {

    @Test
    public void testLogin() {    	
        
        // Create a page object and pass the WebDriver from the BaseClass_New
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        // Add assertions or validations here
        String title = loginPage.getPageTitle();
        assert title.equals("Secure Area");

        // Optionally, log the URL and environment
        System.out.println("Testing on URL: " + getBaseUrl());
        System.out.println("Environment: " + getEnvironment());
    }
}
