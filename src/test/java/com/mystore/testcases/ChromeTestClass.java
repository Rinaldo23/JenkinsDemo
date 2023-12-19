// ChromeTestClass.java
package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTestClass {

    private static ThreadLocal<WebDriver> chromeDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        chromeDriver.set(new ChromeDriver());
    }

    @Test
    public void goToAmazon() {
        chromeDriver.get().get("https://www.amazon.com");
        chromeDriver.get().manage().window().maximize();
        // Additional test steps
    }

    @Test
    public void goToFacebook() {
        chromeDriver.get().get("https://www.facebook.com");
        chromeDriver.get().manage().window().maximize();
        // Additional test steps
    }
    
}