package com.sample.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	
	By loc_txt_name = By.id("username");
	By loc_txt_pwd = By.id("password");
	By loc_btn_submit = By.xpath("//button[@type='submit']");
	
	//Action methods
	
	public void setUserName(String user)
	{
		driver.findElement(loc_txt_name).sendKeys(user);
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(loc_txt_pwd).sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		driver.findElement(loc_btn_submit).click();;
	}
}
