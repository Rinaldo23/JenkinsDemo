package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccountPage;
import com.mystore.pageobjects.SignUpPage;

//Test Case 1: Register User
//1. Launch browser
//2. Navigate to url 'https://magento.softwaretestingboard.com/'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Create an Account' button
//5. Verify 'New User Signup!' is visible
//6. Enter name and email address
//7. Click 'Signup' button
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//9. Fill details: Title, Name, Email, Password, Date of birth
//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//13. Click 'Create Account button'
//14. Verify that 'ACCOUNT CREATED!' is visible
//15. Click 'Continue' button
//16. Verify that 'Logged in as username' is visible
//17. Navigate to HomePage.

//Test Case 2: Register User with existing email
//1. Launch browser
//2. Navigate to url 'https://magento.softwaretestingboard.com/'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'New User Signup!' is visible
//6. Enter name and already registered email address
//7. Click 'Signup' button
//8. Verify error 'Email Address already exist!' is visible

public class RegisterTest extends BaseClass {
	WebDriver driver = getDriver();

	private IndexPage indexPage;
	private SignUpPage signupPage;
	private MyAccountPage myAccountPage;
	Action action = new Action();

	@BeforeMethod
	public void launchAppTest() {
		launchApp();
	}

	@Test
	public void RegisterNewUser() throws IOException {
		action.implicitWait(driver, 5);
		Assert.assertEquals(action.getHttpResponseCode(prop.getProperty("url")), 200);
		indexPage = new IndexPage();
		signupPage = indexPage.NavigateToSignUpPage();
		Assert.assertEquals(action.getCurrentURL(driver), prop.getProperty("url") + "customer/account/create/");
		int randomNumber = action.generateRandomNumber(1, 1000);
		myAccountPage = signupPage.createNewCustomerAccount("rinaldo" + randomNumber, "test",
				"rinaldo" + randomNumber + "@test.com", "rinaldo@12345", "rinaldo@12345");
		Assert.assertEquals(myAccountPage.ValidateAccountCreation(), true);
		indexPage.VerifyLogin();
		indexPage.NavigateToHomePage();
	}

	@Test
	public void RegisterWithExistingUser() throws IOException {
		action.implicitWait(driver, 5);
		Assert.assertEquals(action.getHttpResponseCode(prop.getProperty("url")), 200);
		indexPage = new IndexPage();
		signupPage = indexPage.NavigateToSignUpPage();
		Assert.assertEquals(action.getCurrentURL(driver), prop.getProperty("url") + "customer/account/create/");
		myAccountPage = signupPage.createNewCustomerAccount("rinaldo", "test", "rinaldo@test.com", "rinaldo@12345",
				"rinaldo@12345");
		Assert.assertEquals(myAccountPage.ValidateAccountCreationFailed(), true);
	}
}
