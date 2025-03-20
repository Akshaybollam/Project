package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class ScrollPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ExtentTest test;

	// Constructor
	public ScrollPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.js = (JavascriptExecutor) driver;
		this.test = test;
	}

	// Verify Home Page is Displayed
	public void verifyHomePageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Identifier));
		Assert.assertTrue(element.isDisplayed(), "Home page is NOT displayed!");
	}

	// Scroll Down to Bottom
	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// Verify SUBSCRIPTION Section is Visible
	public void verifySubscriptionIsVisible() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.subscriptionSection));
		Assert.assertTrue(element.isDisplayed(), "'SUBSCRIPTION' section is NOT visible!");
	}

	// Click on Scroll Up Arrow
	public void clickScrollUpArrow() {
		WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(Locators.scrollUpArrow));
		arrow.click();
	}

	// Verify Page is Scrolled Up
	public void verifyPageScrolledUp() {
		WebElement topElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.topText));
		Assert.assertTrue(topElement.isDisplayed(), "Page did NOT scroll up successfully!");
	}
}
