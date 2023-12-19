package com.mystore.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ProductsPage extends BaseClass {
	
	WebDriver driver = getDriver();
	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}

	Action action = new Action();

	// Locators
	@FindBy(xpath = "//a[contains(text(),'Tops')]")
	private WebElement topsBtn;

	@FindBy(xpath = "//a[contains(text(),'Bottoms')]")
	private WebElement bottomBtn;

	// Methods
	//#narrow-by-list2 .items li:nth-child(1)
	public void NavigateToTopSection() {
		action.explicitWait(driver, topsBtn, 10);
		if(action.isDisplayed(driver, topsBtn)) {
			action.click(driver, topsBtn);
		}
	}

	public void NavigateToBottomSection() {
		action.click(driver, bottomBtn);
	}

	public ProductDetailsPage viewProduct() {
		NavigateToTopSection();
		List<WebElement> products = action.findElementsByXpath(driver, "//li[@class='item product product-item']");
		System.out.println("Products size  : "+products.size());
		int randomNumber = action.generateRandomNumber(1, products.size()); //
		//while (action.getCurrentURL(driver).contains("product_details")) {
			for (int i = 0; i <= products.size(); i++) {
				if (i == randomNumber) {
					action.scrollByVisibilityOfElement(driver, products.get(i));
					action.click(driver, products.get(i));
				}
			}
		//}
		return new ProductDetailsPage();
	}
}
