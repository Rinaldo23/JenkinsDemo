package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class MyAccountPage extends BaseClass {
	
	WebDriver driver = getDriver();
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	Action action = new Action();

	// Locators

	@FindBy(xpath = "//b[normalize-space()='Account Created!']")
	private WebElement accountCreationText;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement accountCreatedConfimationText;
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement accountCreationFailedText;

	// Methods

	public boolean verifyAccountCreation() {
		return false;
	}

	public HomePage ClickOnContinue() {
		boolean res = verifyAccountCreation();

		if (res) {
			action.click(driver, continueBtn);
		} else {
			// TODO
		}

		return new HomePage();
	}
	
	public boolean ValidateAccountCreation() {
		action.explicitWait(driver, accountCreatedConfimationText, 10);
		if(action.isDisplayed(driver, accountCreatedConfimationText)) {
			return accountCreatedConfimationText.getText().contains("Thank you for registering with Main Website Store.");
		}
		
		return false;
	}
	
	public boolean ValidateAccountCreationFailed() {
		action.explicitWait(driver, accountCreationFailedText, 10);
		if(action.isDisplayed(driver, accountCreationFailedText)) {
			return accountCreationFailedText.getText().contains("There is already an account with this email address.");
		}
		
		return false;
	}

}
