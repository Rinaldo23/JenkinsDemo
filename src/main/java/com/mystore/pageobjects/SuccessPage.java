package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SuccessPage extends BaseClass{
	
	WebDriver driver = getDriver();
	public SuccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	Action action = new Action();
	
	//Locators 
	
	@FindBy(xpath="//span[@class='base']")
	private WebElement successMessage;
	
	@FindBy(xpath="//strong[normalize-space()='000031529']")
	private WebElement orderNumber;
	
	@FindBy(xpath="//span[normalize-space()='Continue Shopping']")
	private WebElement continueShopping;
	
	
	//Methods
	
	public String VerifyPurchaseMessage() {
		action.explicitWait(driver, successMessage, 10);
		String actualMsg = "Thank you for your purchase!";
		String orderNum="";
		if(successMessage.getText().contains(actualMsg)){
			orderNum = orderNumber.getText();
			action.click(driver, continueShopping);
		};
		
		return orderNum;
	}
	
}
