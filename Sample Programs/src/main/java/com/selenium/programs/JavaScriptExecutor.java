package com.selenium.programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptExecutor {
	
	public static void main(String[] args)
	
	{
	
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("window.scrollBy(0,100)");
	executor.executeScript("window.scrollTo(0,document.body.scrollHeight");
	

   }
}
