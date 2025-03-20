package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class CartSubscriptionPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public CartSubscriptionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Verify Home Page is Visible
	public void verifyHomePageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.homePage));
		Assert.assertTrue(element.isDisplayed(), "Home page is NOT displayed!");
	}

	// Click 'Cart' Button
	public void clickOnCart() {
		WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(Locators.cartButton));
		Assert.assertTrue(cart.isDisplayed(), "Cart button is NOT visible!");
		cart.click();
	}

	// Scroll Down to Footer
	public void scrollToFooter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// Verify 'SUBSCRIPTION' Text is Visible
	public boolean verifySubscriptionText() {
    	boolean result=true;
    	try {
         wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.subscriptionText));
         Reports.generateReport(driver, test, Status.PASS, "subscription text is visible");
    	}
       // Assert.assertTrue(element.isDisplayed(), "'SUBSCRIPTION' text is NOT visible!");
    	catch(Exception e) {
    		result=false;
    		Reports.generateReport(driver, test, Status.FAIL, "Subscription text is not visible");
    	}
    	return result;
    }

	// Enter Email and Subscribe
	public void enterEmailAndSubscribe(String email) {
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailInput));
		emailField.clear();
		emailField.sendKeys(email);

		WebElement subscribeBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.subscribeButton));
		subscribeBtn.click();
	}

	// Verify Subscription Success Message
	public void verifySubscriptionSuccess() {
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.successmsg));
		Assert.assertTrue(successMsg.isDisplayed(), "Success message is NOT visible!");
	}
}
