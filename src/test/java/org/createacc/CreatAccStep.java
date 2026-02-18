package org.createacc;

import org.base.BaseClass;
import org.pojologin.PojoFbSignup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreatAccStep extends BaseClass{

	@Given("User Should be launch the browser through ChromeBrowser")
	public void user_Should_be_launch_the_browser_through_ChromeBrowser() {
	    launchBrowser();
	    loadUrl("https://www.facebook.com/r.php?entry_point=login");
	}

	@When("User Should be enter all the details in textboxes")
	public void user_Should_be_enter_all_the_details_in_textboxes() {
	    PojoFbSignup p = new PojoFbSignup();
	    textFill(p.getFirstName(), "Abdul");
	    textFill(p.getSurName(), "Azeem");
	    textFill(p.getPhoneNo(), "7676385336");
	    textFill(p.getPassword(), "Java@123");
	    
	}

	@When("User Select the dropdown value")
	public void user_Select_the_dropdown_value() {
		PojoFbSignup p = new PojoFbSignup();
		visibleSelect(p.getDay(), "25");
		visibleSelect(p.getMonth(), "Mar");
		visibleSelect(p.getYear(), "2004");
		buttonClick(p.getGender());
	}

	@When("User click the Submit button")
	public void user_click_the_Submit_button() {
		PojoFbSignup p = new PojoFbSignup();
		buttonClick(p.getSignup());
	}


}
