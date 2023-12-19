package com.mystore.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.base.BaseClass;

public class EventListner extends BaseClass implements ITestListener {
	
	WebDriver driver = getDriver();
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		htmlReporter = new ExtentSparkReporter("Report.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("Rinaldo Demo");
		htmlReporter.config().setReportName("First Name : Pankaj");
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		// Convert WebDriver object to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture screenshot as File
		File source = ts.getScreenshotAs(OutputType.FILE);

		// Define destination for the screenshot
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + screenshotName + ".png";
		File target = new File(destination);

		// Copy file to the destination
		FileUtils.copyFile(source, target);
	}

	@Override
	public void onTestStart(ITestResult result) {
		configureReport();
		System.out.println("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed test" + result.getName(), ExtentColor.RED));
		try {
			captureScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath("F:\\Selenium\\EcomAutomationProject\\MyStore\\ScreenShot\\" + result.getName() + ".png", result.getName());
//		test = reports.createTest(result.getStatus());
		System.out.println("Test Failed: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finished: " + context.getName());
		reports.flush();
	}
}
