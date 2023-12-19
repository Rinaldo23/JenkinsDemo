package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	WebDriver driver = getDriver();
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	Action action = new Action();

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//button[@id='send2']")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]")
	private WebElement forgetPasswordLink;

	@FindBy(css = "//a[@class='action create primary']//span[contains(text(),'Create an Account')]")
	private WebElement createAccBtn;
	
	@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement verifyInvalidLoginText;

	public IndexPage Login(String email, String password) {
		action.type(emailTextbox, email);
		action.type(passwordTextBox, password);
		action.click(driver, loginBtn);
		action.implicitWait(driver, 10);
		return new IndexPage();
	}

	
	public SignUpPage RegisterUser(String name, String email) throws InterruptedException {
		action.click(driver, createAccBtn);
		return new SignUpPage();
	}
	
	public boolean verifyInvalidLogin() {
		action.explicitWait(driver, verifyInvalidLoginText, 10);
		return verifyInvalidLoginText.getText().contains("account sign-in was incorrect");
	}

}
