package com.sample.pagefactory.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators	
		
	@FindBy(xpath="//input[@id='username']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement btn_login;	
	
	
	//Action methods
	
	public void setUserName(String user)
	{
		txt_username.sendKeys(user);
	}
	
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btn_login.click();;
	}
	
}
