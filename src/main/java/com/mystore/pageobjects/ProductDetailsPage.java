package com.mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ProductDetailsPage extends BaseClass {
	
	WebDriver driver = getDriver();
	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	Action action = new Action();

	// Locators
	@FindBy(xpath = "//span[@class='base']")
	private WebElement productTitle;

	@FindBy(css = ".size .swatch-option")
	private List<WebElement> sizeList;

	@FindBy(css = ".color .swatch-option")
	private List<WebElement> colorList;

	@FindBy(xpath = "//input[@id='qty']")
	private WebElement quantityTextBox;

	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//div[@class='message-success success message']")
	private WebElement productAddedMsg;

	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	private WebElement shoppingCartBtn;

	// Methods
	public ShoppingCartPage AddProductToCart() throws InterruptedException {
		SelectSize();
		SelectColor();
		AddQty();
		AddToCart();
		return NavigateToShoppingCart();
		
	}

	public void SelectSize() throws InterruptedException {
		Thread.sleep(5000);
		int randomNumber = action.generateRandomNumber(1, sizeList.size()-1);
		action.click(driver, sizeList.get(randomNumber));
	}

	public void SelectColor() {
		int randomNumber = action.generateRandomNumber(1, colorList.size()-1);
		action.click(driver, colorList.get(randomNumber));
	}

	public void AddQty() {
		int randomNumber = action.generateRandomNumber(1, 10);
		action.type(quantityTextBox, Integer.toString(randomNumber));
	}

	public void AddToCart() {
		action.click(driver, addToCartBtn);

		// verify product added successfully
		action.isDisplayed(driver, productAddedMsg);
	}

	public ShoppingCartPage NavigateToShoppingCart() {
		if (action.isDisplayed(driver, shoppingCartBtn)) {
			action.click(driver, shoppingCartBtn);
		}
		return new ShoppingCartPage();
	}
}
