package org.step2;

import org.base.BaseClass;
import org.pojologin.PojoFbLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefintion02 extends BaseClass {

	@When("User Should be enter Invalid email and Invalid Password")
	public void user_Should_be_enter_Invalid_email_and_Invalid_Password() {
		PojoFbLogin p = new PojoFbLogin();
		textFill(p.getEmail(), "Selenium123@gmail.com");
		textFill(p.getPassword(), "sel@123");
	}
	@When("User Should be enter {string} and {string}")
	public void user_Should_be_enter_and(String user, String pass) {
		PojoFbLogin p = new PojoFbLogin();
		textFill(p.getEmail(), user);
		textFill(p.getPassword(), pass);
		attributeData(p.getEmail());
	}
	
	@Given("User Should be launch the browser through ChromeBrowser")
	public void user_Should_be_launch_the_browser_through_ChromeBrowser() {
	   launchBrowser();
	   loadUrl("https://www.facebook.com");
	   
	}

	@When("User Should be enter Valid email and Invalid Password")
	public void user_Should_be_enter_Valid_email_and_Invalid_Password() {
	   PojoFbLogin p = new PojoFbLogin();
	   textFill(p.getEmail(), "Java123@gmail.com");
	   textFill(p.getPassword(), "Java@123");
	}

	@When("User Should be click the login button")
	public void user_Should_be_click_the_login_button() {
		PojoFbLogin p = new PojoFbLogin();
		buttonClick(p.getLogin());
	}

	@When("User check the Title and print the Title")
	public void user_check_the_Title_and_print_the_Title() {
	titleFetch();
	}

	@Then("User Should be in Invalid Credential Page")
	public void user_Should_be_in_Invalid_Credential_Page() {
	    System.out.println("User Should be in Invalid Credential Page");
	}
}
