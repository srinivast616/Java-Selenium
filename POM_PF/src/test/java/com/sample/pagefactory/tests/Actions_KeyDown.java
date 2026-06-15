package com.sample.pagefactory.tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import com.sample.pagefactory.base.BaseTest;

public class Actions_KeyDown extends BaseTest {	
	
	public static void main(String[] args) {
		
	Actions ac = new Actions(driver);
	ac.keyDown(Keys.CONTROL);
	ac.sendKeys("o");
	ac.sendKeys("k");
	
	
	
	}

}
