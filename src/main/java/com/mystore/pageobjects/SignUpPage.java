package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SignUpPage extends BaseClass {
	
	WebDriver driver = getDriver();
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	Action action = new Action();

	// Locators
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstNameTextBox;

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastNameTextBox;

	@FindBy(xpath = "//input[@id='email_address']")
	private WebElement emailTextBox;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='password-confirmation']")
	private WebElement confirmPasswordTextBox;

	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	private WebElement signInButton;
	
	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	private WebElement signupTextMsg;

	// Methods

	public void EnterPersonalInfo(String firstName, String lastName) {
		action.type(firstNameTextBox, firstName);
		action.type(lastNameTextBox, lastName);
	}

	public void EnterSignInInfo(String email, String password, String confirmPassword) {
		action.type(emailTextBox, email);
		action.type(passwordTextBox, password);
		action.type(confirmPasswordTextBox, confirmPassword);
	}
	
	public MyAccountPage createNewCustomerAccount(String firstName, String lastName,String email, String password, String confirmPassword) {
		action.implicitWait(driver, 10);
		EnterPersonalInfo(firstName, lastName);
		EnterSignInInfo(email, password, confirmPassword);
		action.click(driver, signInButton);
		return new MyAccountPage();
	}

}
