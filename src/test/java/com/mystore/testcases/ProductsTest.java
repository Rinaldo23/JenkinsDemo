package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.CheckOutPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.ProductDetailsPage;
import com.mystore.pageobjects.ProductsPage;
import com.mystore.pageobjects.ShoppingCartPage;
import com.mystore.pageobjects.SuccessPage;

//Test Case 1: Search Product
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Products' button
//5. Verify user is navigated to ALL PRODUCTS page successfully
//6. Enter product name in search input and click search button
//7. Verify 'SEARCHED PRODUCTS' is visible
//8. Verify all the products related to search are visible

public class ProductsTest extends BaseClass {
	
	WebDriver driver = getDriver();

	private IndexPage indexPage;
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private ProductDetailsPage productDetailsPage;
	private ShoppingCartPage shoppingCartPage;
	private CheckOutPage checkOutPage;
	private SuccessPage successPage;
	Action action = new Action();

	@BeforeMethod
	public void launchAppTest() {
		launchApp();
	}

	@Test
	public void RegisterNewUser() throws IOException, InterruptedException {
		action.implicitWait(driver, 5);
		Assert.assertEquals(action.getHttpResponseCode(prop.getProperty("url")), 200);
		indexPage = new IndexPage();
		loginPage = indexPage.NavigateToSignInPage();
		loginPage.Login(prop.getProperty("email"), prop.getProperty("password"));
		// Assert.assertEquals(indexPage.VerifyLogin(), true);
		indexPage.NavigateToHomePage();
		productsPage = indexPage.NavigateToWomensPage();
		productDetailsPage = productsPage.viewProduct();
		Thread.sleep(10000);
		//
		shoppingCartPage = productDetailsPage.AddProductToCart();
		checkOutPage = shoppingCartPage.ProceedToCheckout();
		checkOutPage.EnterShippingInfo("Pankaj", "Suryavanshi", "TCS", "Street1", "Kalyan", "421306", "7738633673");
		Thread.sleep(5000);
		successPage = checkOutPage.PlaceOrder();
		Thread.sleep(5000);
		String orderNum = successPage.VerifyPurchaseMessage();
		System.out.println("Order Number  : " + orderNum);
	}

}
