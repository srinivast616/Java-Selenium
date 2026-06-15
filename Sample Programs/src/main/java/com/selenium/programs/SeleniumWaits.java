package com.selenium.programs;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

	public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	
	WebElement element = driver.findElement(By.xpath("\\button[contains(text(),'Submit']"));
	
	WebDriverWait explicit_wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	explicit_wait.until(ExpectedConditions.elementToBeClickable(element));
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	FluentWait<WebDriver> fluent_wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(2))
			.withTimeout(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
	
	
	
	
	}
}
