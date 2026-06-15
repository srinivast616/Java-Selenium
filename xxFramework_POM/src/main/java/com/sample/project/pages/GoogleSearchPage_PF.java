package com.sample.project.pages;

import org.openqa.selenium.WebDriver;  // Import WebDriver to interact with the browser.
import org.openqa.selenium.WebElement;  // Import WebElement to locate elements.
import org.openqa.selenium.support.FindBy;  // Import FindBy to locate elements.
import org.openqa.selenium.support.How;  // Import How to specify the locator strategy.
import org.openqa.selenium.support.PageFactory;  // Import PageFactory to initialize elements.


/**
* This class represents the Google Home Page.
*/
public class GoogleSearchPage_PF {


   // WebDriver reference variable.
 public WebDriver driver;


   /**
    * Constructor for the GoogleHomePage class.
    * @param driver The WebDriver instance.   */


   // Locate the search box element using the NAME locator strategy.
   @FindBy(how = How.NAME, using = "q")
   WebElement searchBox;
  
   // Locate the submit button element using the NAME locator strategy.
   @FindBy(how = How.NAME, using = "btnK")
   WebElement submit;
   
   public GoogleSearchPage_PF(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }


   /**
    * Method to handle search box inputs.
    */
   public void search()
   {
       searchBox.sendKeys("TestGrid");
   }


   /**
    * Method to perform submit operation.
    */
   public void submit()
   {
       // Click the submit button.
       submit.click();
   }
}
