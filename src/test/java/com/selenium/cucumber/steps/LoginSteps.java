package com.selenium.cucumber.steps;

import java.util.Map;

import com.selenium.annotation.LazyAutowired;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.WelcomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	@LazyAutowired
	LoginPage loginPage;
	
	@LazyAutowired
	HomePage homePage;
	
	@LazyAutowired
	WelcomePage welcomePage;
	
    @Given("I launch the Login page")
    public void iAmOnTheLoginPage() {
    	homePage.goToHomePage();
    	
    	loginPage.goToLoginPage();
    }

    @When("I enter invalid {string} and {string} to login")
    public void iTryToLoginWithInvalidId(String email, String password) {
    	loginPage.login(email, password);
    }
    
    @When("I enter credential to login")
    public void iTryToLoginWithValidId(DataTable dataTable) {
    	for(Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
    		loginPage.login(data.get("emailId"), data.get("password"));
    	}
    }
    
    @Then("I verify invalid {string} text displayed")
    public void iVerifyInvalidLoginMessage(String expectedText) {
    	loginPage.iVerifyInvalidLoginMessage(expectedText);
    }
    
    @Then("I verify valid {string} text displayed on welcome page")
    public void iVerifyValidLoginMessage(String expectedText) {
    	loginPage.iVerifyValidLoginMessage(expectedText);
    }
}
