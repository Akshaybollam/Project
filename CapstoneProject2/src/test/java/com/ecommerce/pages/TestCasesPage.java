package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class TestCasesPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public TestCasesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	// Verify home page title
	public String getHomePageTitle() {
		wait.until(ExpectedConditions.titleContains("Automation Exercise"));
		return driver.getTitle();

	}

	// Click on 'Test Cases' button
	public void clickTestCases() {
		WebElement testCases = wait.until(ExpectedConditions.elementToBeClickable(Locators.testCasesButton));
		testCases.click();
	}
}
