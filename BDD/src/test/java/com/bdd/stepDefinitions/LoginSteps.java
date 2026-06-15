package com.bdd.stepDefinitions;

import org.testng.Assert;

import com.bdd.pages.LoginPage;
import com.bdd.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps 
{
LoginPage loginPage;

@Given("User is on login page")

public void user_on_login_page() {
    DriverFactory.getDriver().get("https://practicetestautomation.com/practice-test-login/");
    loginPage = new LoginPage(DriverFactory.getDriver());
}

@When("User logs in with {string} and {string}")

public void user_logs_in(String user, String pass) {
    loginPage.login(user, pass);
}

@Then("User should be redirected to home page")
 
public void verify_login() {
    Assert.assertTrue(DriverFactory.getDriver().getTitle().contains("Home"));
}
}

