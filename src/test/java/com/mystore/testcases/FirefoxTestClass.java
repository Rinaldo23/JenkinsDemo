package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxTestClass {

    private static ThreadLocal<WebDriver> firefoxDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        // Set up FirefoxDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        firefoxDriver.set(new FirefoxDriver());
    }

    @Test
    public void openInstagram() {
        firefoxDriver.get().get("https://www.instagram.com");
        firefoxDriver.get().manage().window().maximize();
        // Additional test steps
    }

    @Test
    public void openTwitter() {
        firefoxDriver.get().get("https://www.twitter.com");
        firefoxDriver.get().manage().window().maximize();
        // Additional test steps
    }

}