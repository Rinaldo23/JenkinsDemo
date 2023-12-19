package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

//header
public class IndexPage extends BaseClass {
	
	WebDriver driver = getDriver();
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	Action action = new Action();

	// Locators

	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	private WebElement logoImg;

	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//button[@title='Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//a[@class='action showcart']")
	private WebElement cartBtn;

	@FindBy(xpath = "//span[normalize-space()='Women']")
	private WebElement womenBtn;

	@FindBy(xpath = "//span[normalize-space()='Men']")
	private WebElement menBtn;
	
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
	private WebElement signUpBtn;
	
	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	private WebElement signOutOptionsDD;
	
	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	private WebElement signOutBtn;
	
	
	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']")
	public WebElement verifyLoginText;
			
			

	// Methods
	public ProductsPage NavigateToMensPage() {
		action.explicitWait(driver, menBtn, 10);
		action.click(driver, menBtn);
		return new ProductsPage();
	}

	public ProductsPage NavigateToWomensPage() {
		action.click(driver, womenBtn);
		return new ProductsPage();
	}

	public HomePage NavigateToHomePage() {
		action.click(driver, logoImg);
		return new HomePage();
	}
	
	public LoginPage NavigateToSignInPage() {
		action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public SignUpPage NavigateToSignUpPage() {
		action.click(driver, signUpBtn);
		return new SignUpPage();
	}
	
	public HomePage LogOut() {
		action.click(driver, signOutOptionsDD);
		action.click(driver, signOutBtn);
		return new HomePage();
	}

	public ProductsPage SearchProducts(String product) {
		action.type(searchTextBox, product);
		action.click(driver, searchBtn);
		return new ProductsPage();
	}
	
	public boolean VerifyLogin() {
		return !action.isDisplayed(driver, signInBtn);	
	}

}
