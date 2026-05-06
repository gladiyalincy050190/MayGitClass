package org.stepdefinition;

import org.base.BaseClass;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinition {
	
	@Given ("user should open the application")
	public void user_should_open_the_application() {
		System.out.println("Opened the application");
	}
	
	
	@When("user should enter the userName and password")
	public void user_should_enter_the_userName_and_password() {

		System.out.println("Entered username and password");
	}

	@Then("varifying the home page")
	public void verifying_the_home_page() {

		System.out.println("Home page verified");
	}

}
