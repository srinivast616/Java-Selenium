package com.sample.pagefactory.tests;

import com.sample.pagefactory.base.BaseClass_Old;
import com.sample.pagefactory.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class LoginTest_Old extends BaseClass_Old {

    @Test
    public void testLogin() {
        // Log information in ExtentReports
        test.log(com.relevantcodes.extentreports.LogStatus.INFO, "Test started on Login Page");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("user1");
        loginPage.enterPassword("pass1");
        loginPage.clickLoginButton();

        // Take screenshot on failure (you can customize the condition for success/failure)
        if (isLoginSuccessful()) {
            test.log(com.relevantcodes.extentreports.LogStatus.PASS, "Login successful");
        } else {
            test.log(com.relevantcodes.extentreports.LogStatus.FAIL, "Login failed");
            captureScreenshot(driver, "LoginTest_Failure");
        }

        // Add assertions or validations here
        String title = loginPage.getPageTitle();
        assert title.equals("Expected Page Title");
    }

    // Check if login is successful
    private boolean isLoginSuccessful() {
        // Implement a method to verify successful login (e.g., check for a logout button or user profile)
        return true;
    }

    // Capture screenshot on failure
    private void captureScreenshot(WebDriver driver, String screenshotName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/" + screenshotName + ".png"));
            test.log(com.relevantcodes.extentreports.LogStatus.INFO, "Screenshot taken: " + screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}