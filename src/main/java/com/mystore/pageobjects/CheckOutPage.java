package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CheckOutPage extends BaseClass {
	
	WebDriver driver = getDriver();
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	Action action = new Action();

	// Locators

	@FindBy(xpath = "//input[@id='YMSAM2K']")
	private WebElement firstNameTextBox;

	@FindBy(xpath = "//input[@id='V58563K']")
	private WebElement lastNameTextBox;

	@FindBy(xpath = "//input[@id='G367TLH']")
	private WebElement comapanyTextBox;

	@FindBy(xpath = "//input[@id='RWDWDN4']")
	private WebElement streetNameTextBox;

	@FindBy(xpath = "//input[@id='W7LVJPP']")
	private WebElement cityTextBox;

	@FindBy(xpath = "//select[@id='I3PDG2G']")
	private WebElement selectStateDD;

	@FindBy(xpath = "//input[@id='MDC1M3A']")
	private WebElement zipCodeTextBox;

	@FindBy(xpath = "//select[@id='XAAVI3M']")
	private WebElement selectCountryDD;

	@FindBy(xpath = "//input[@id='TENH3TU']")
	private WebElement phoneTextBox;

	@FindBy(xpath = "//input[@name='ko_unique_2']")
	private WebElement shippingMethodOne;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	private WebElement nextBtn;

	@FindBy(xpath = "//button[@title='Place Order']")
	private WebElement placeOrderBtn;

	// Methods

	public void EnterShippingInfo(String firstName, String lastName, String company, String street, String city,
			String zip, String phone) {
		if (action.isDisplayed(driver, firstNameTextBox)) {
			action.type(firstNameTextBox, firstName);
			action.type(lastNameTextBox, lastName);
			action.type(comapanyTextBox, company);
			action.type(streetNameTextBox, street);
			action.type(cityTextBox, city);

			action.selectByIndex(selectStateDD, GetDropDownOptionCount(selectStateDD));

			action.type(zipCodeTextBox, zip);

			action.selectByIndex(selectCountryDD, GetDropDownOptionCount(selectCountryDD));

			action.type(phoneTextBox, phone);
		}

		action.click(driver, shippingMethodOne);
		action.click(driver, nextBtn);
	}

	public SuccessPage PlaceOrder() {
		action.explicitWait(driver, placeOrderBtn, 10);
		if(action.isDisplayed(driver, placeOrderBtn)) {
			//action.click(driver, placeOrderBtn);
			action.JSClick(driver, placeOrderBtn);
		}else {
			System.out.println("Not Visble btmm");
		}
		
		return new SuccessPage();
	}

	public int GetDropDownOptionCount(WebElement element) {
		Select dropdown = new Select(selectStateDD);
		int optionsCount = dropdown.getOptions().size();
		int randomNumber = action.generateRandomNumber(1, optionsCount);
		return randomNumber;
	}

}
