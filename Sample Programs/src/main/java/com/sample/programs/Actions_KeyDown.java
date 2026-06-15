package com.sample.programs;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actions_KeyDown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		Actions ac = new Actions(driver);
		ac.keyDown(Keys.CONTROL);
		ac.sendKeys("o");
		ac.sendKeys("k");

	}

}
