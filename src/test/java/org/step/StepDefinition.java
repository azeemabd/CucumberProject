package org.step;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	WebDriver driver;
	
	@Given("User Should be launch the browser through ChromeBrowser")
	public void user_Should_be_launch_the_browser_through_ChromeBrowser() {
	   driver = new ChromeDriver();
	   driver.get("https://www.facebook.com");
	   driver.manage().window().maximize();
	   
	}

	@When("User Should be enter Valid email and Invalid Password")
	public void user_Should_be_enter_Valid_email_and_Invalid_Password() {
	    driver.findElement(By.id("email")).sendKeys("Java123@gmail.com");
	    driver.findElement(By.id("pass")).sendKeys("Java@123");
	}

	@When("User Should be click the login button")
	public void user_Should_be_click_the_login_button() {
	    driver.findElement(By.name("login")).click();
	}

	@When("User check the Title and print the Title")
	public void user_check_the_Title_and_print_the_Title() {
	   
	String t = driver.getTitle();
	System.out.println("Title Fetch :"+t);
	}

	@Then("User Should be in Invalid Credential Page")
	public void user_Should_be_in_Invalid_Credential_Page() {
	    System.out.println("User Should be in Invalid Credential Page");
	}
}
