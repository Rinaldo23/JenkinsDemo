package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShoppingCartPage extends BaseClass {
	
	WebDriver driver = getDriver();
	public ShoppingCartPage( ) {
		PageFactory.initElements(driver, this);
	}
	
	Action action = new Action();
	
	//Locators
	
	@FindBy(xpath="//span[@class='base']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//table[@id='shopping-cart-table'] //tbody[@class=\"cart item\"]")
	private WebElement cartItemsList;
	
	@FindBy(xpath=".cart.item .item .product-item-name a")
	private WebElement productNameList;
	
	@FindBy(xpath="//td[@data-th=\"Price\"]/span/span/span")
	private WebElement priceList;
	
	@FindBy(xpath="//td[@data-th=\"Qty\"]/div/div/label/input")
	private WebElement quantityList; //get value attribute
	
	@FindBy(xpath="//tr[@class='totals sub']//td[@class='amount']/span")
	private WebElement subTotal; // get Text
	
	@FindBy(xpath="//tr[@class='totals']//td[@class='amount']/span/span")
	private WebElement discount;
	
	@FindBy(xpath="//tr[@class='grand totals']//td[@class='amount']/strong/span")
	private WebElement orderTotal;
	
	@FindBy(xpath="//button[@data-role='proceed-to-checkout']")
	private WebElement proceedToCheckOut;
	
	
	//Methods
	
	public CheckOutPage ProceedToCheckout() {
		action.explicitWait(driver, proceedToCheckOut, 10);
		action.click(driver, proceedToCheckOut);
		return new CheckOutPage();
	}
	
	
	
	
}
