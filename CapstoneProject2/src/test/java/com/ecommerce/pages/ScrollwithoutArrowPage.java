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

public class ScrollwithoutArrowPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ExtentTest test;

	// Constructor
	public ScrollwithoutArrowPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.js = (JavascriptExecutor) driver;
	}

	// Verify Home Page is Displayed
	public void verifyHomePageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.homePageverify));
		Assert.assertTrue(element.isDisplayed(), "Home page is NOT displayed!");
	}

	// Scroll Down to Bottom
	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// Verify SUBSCRIPTION Section is Visible
	public void verifySubscriptionIsVisible() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.subscription));
		Assert.assertTrue(element.isDisplayed(), "'SUBSCRIPTION' section is NOT visible!");
	}

	// Scroll Up to Top Without Arrow Button
	public void scrollToTop() {
		js.executeScript("window.scrollTo(0, 0)");
	}

	// Verify Page is Scrolled Up
	public void verifyPageScrolledUp() {
		WebElement topElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.toptext));
		Assert.assertTrue(topElement.isDisplayed(), "Page did NOT scroll up successfully!");
	}
}
