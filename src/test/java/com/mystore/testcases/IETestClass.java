package com.mystore.testcases;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IETestClass {

    private ThreadLocal<WebDriver> ieDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        // Set up InternetExplorerDriver using WebDriverManager
        WebDriverManager.iedriver().setup();
        ieDriver.set(new InternetExplorerDriver());
    }

    @Test
    public void openMicrosoft() {
        ieDriver.get().get("https://www.microsoft.com");
        // Additional test steps
    }

    @Test
    public void openLinkedIn() {
        ieDriver.get().get("https://www.linkedin.com");
        // Additional test steps
    }
    
}