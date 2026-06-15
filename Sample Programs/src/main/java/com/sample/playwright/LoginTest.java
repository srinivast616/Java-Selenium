package com.sample.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://practicetestautomation.com/practice-test-login/");
           
            // Using CSS
            
//            page.fill("#username", "yourUsername");
//            page.fill("#password", "yourPassword");
//            page.click("#loginBtn");
            
            // Using XPath 
            
            page.locator("//input[@id='username']").fill("student");
            page.locator("//input[@id='password']").fill("Password123");
            page.locator("//button[@id='submit']").click();

            System.out.println("Title after login: " + page.title());
            browser.close();
        }
    }

}

