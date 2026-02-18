package org.pojologin;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoFbSignup extends BaseClass{

	public PojoFbSignup() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="firstname")
	private WebElement FirstName;
	
	@FindBy(name="lastname")
	private WebElement SurName;
	
	@FindBy(name="reg_email__")
	private WebElement PhoneNo;
	
	@FindBy(id="password_step_input")
	private WebElement Password;
	
	@FindBy(id="day")
	private WebElement Day;
	
	@FindBy(id="month")
	private WebElement month;
	
	

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getSurName() {
		return SurName;
	}

	public WebElement getPhoneNo() {
		return PhoneNo;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getDay() {
		return Day;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getGender() {
		return gender;
	}
	@FindBy(id="year")
	private WebElement year;
	
	@FindBy(xpath="(//input[@id='sex'])[2]")
	private WebElement gender;
	
	@FindBy(xpath="(//button[text()='Sign up'])[1]")
	private WebElement Signup;
	
	public WebElement getSignup() {
		return Signup;
	}
	
}
