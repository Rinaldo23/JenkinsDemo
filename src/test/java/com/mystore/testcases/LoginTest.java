package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.DatabaseConnectUtility;
import com.mystore.utility.ExcelUtility;
import com.mystore.utility.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Test Case 1: Login User with correct email and password
//1. Launch browser
//2. Navigate to url 'https://magento.softwaretestingboard.com/'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'Login to your account' is visible
//6. Enter correct email address and password
//7. Click 'login' button
//8. Verify that 'Logged in as username' is visible

//Test Case 2: Login User with incorrect email and password
//1. Launch browser
//2. Navigate to url 'https://magento.softwaretestingboard.com/'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'Login to your account' is visible
//6. Enter incorrect email address and password
//7. Click 'login' button
//8. Verify error 'Your email or password is incorrect!' is visible

public class LoginTest extends BaseClass {

	private IndexPage indexPage;
	private LoginPage loginPage;
	Action action = new Action();
	
	WebDriver driver = getDriver(); 

	@BeforeMethod
	public void launchAppTest() {
		launchApp();
	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return ExcelUtility.readExcelData("Sheet1"); // Replace "Sheet1" with your sheet name
	}

	@Test(dataProvider = "loginData")
	public void loginTestWithValidCreds(String username, String password) throws IOException {
		Log.startTestCase("Started loginTestWithValidCreds");
//		action.implicitWait(driver, 5);
		
		System.out.println("Username: " + username + ", Password: " + password);
		Log.info("Validating URL");
		Assert.assertEquals(action.getHttpResponseCode(prop.getProperty("url")), 200);
		indexPage = new IndexPage();
		loginPage = indexPage.NavigateToSignInPage();
		loginPage.Login(username, password);
		Assert.assertEquals(indexPage.VerifyLogin(), false);
		Log.endTestCase("Ended loginTestWithValidCreds");
	}
	


//	@Test
//	public void loginTestWithInValidCreds() throws IOException {
//		action.implicitWait(driver, 5);
//		Assert.assertEquals(action.getHttpResponseCode("https://magento.softwaretestingboard.com/"), 200);
//		indexPage = new IndexPage();
//		loginPage = indexPage.NavigateToSignInPage();
//		loginPage.Login(prop.getProperty("email"), prop.getProperty("password") + "s");
//		Assert.assertEquals(loginPage.verifyInvalidLogin(), true);
//	}

	// Database
//	@Test(dataProvider = "userData")
//	public void testLogin(String username, String password) throws IOException {
//		action.implicitWait(driver, 5);
//		System.out.println("Username: " + username + ", Password: " + password);
//		Assert.assertEquals(action.getHttpResponseCode(prop.getProperty("url")), 200);
//		indexPage = new IndexPage();
//		loginPage = indexPage.NavigateToSignInPage();
//		loginPage.Login(username, password);
//		Assert.assertEquals(indexPage.VerifyLogin(), true);
//	}

//	@DataProvider(name = "userData")
//	public Object[][] getUserData() {
//		List<Object[]> userData = new ArrayList<>();
//
//		try (Connection connection = DatabaseConnectUtility.connect()) {
//			String query = "SELECT username, password FROM users";
//			try (PreparedStatement preparedStatement = connection.prepareStatement(query);
//					ResultSet resultSet = preparedStatement.executeQuery()) {
//
//				while (resultSet.next()) {
//					String username = resultSet.getString("username");
//					String password = resultSet.getString("password");
//					userData.add(new Object[] { username, password });
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		Object[][] dataArray = new Object[userData.size()][2];
//		for (int i = 0; i < userData.size(); i++) {
//			dataArray[i] = userData.get(i);
//		}
//
//		return dataArray;
//	}

}
