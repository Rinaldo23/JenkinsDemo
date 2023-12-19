package com.mystore.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;

public class TestListener implements ITestListener{
	private static int count = 0;
	private final static int maxTry = 2;

	public void onTestFailure(ITestResult iTestResult) {
	    System.out.println("I am in onTestFailure method " + iTestResult.getName() + " failed");
	    if (count < maxTry) {
	        count++;
	        TestNG tng = new TestNG();
	        tng.setDefaultTestName("RETRY TEST");
	        Class[] classes1 = {iTestResult.getTestClass().getRealClass()};
	        tng.setTestClasses(classes1);
	        tng.addListener(new TestListener());
	        tng.run();
	    }
	}

}
