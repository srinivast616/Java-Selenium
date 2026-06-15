package com.sample.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // Import WebDriver to interact with the browser.
import org.openqa.selenium.WebElement; // Import WebElement to locate elements.
import org.openqa.selenium.support.FindBy; // Import FindBy to locate elements.
import org.openqa.selenium.support.How; // Import How to specify the locator strategy.
import org.openqa.selenium.support.PageFactory; // Import PageFactory to initialize elements.

/**
 * This class represents the Google Home Page.
 */
public class GoogleSearchPage_POM {

	WebDriver driver;

	public GoogleSearchPage_POM(WebDriver driver) {

		this.driver = driver;
	}

	By searchbox = By.xpath("//input[@name='q']");
	By search_button = By.xpath("//input[@name='btnk'][1]");
	By facebook_link = By.xpath("//a//h3[text()='Facebook - Log In or Sign Up']");

	public void searchgoogle(String searchinput) {
		try {
			driver.findElement(searchbox).sendKeys(searchinput);
			Thread.sleep(1000);
			driver.findElement(search_button).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Exception caught" +e.getMessage());
		}

	}

}
