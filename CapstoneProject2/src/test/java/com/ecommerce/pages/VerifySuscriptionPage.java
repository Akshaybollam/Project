package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;
import com.ecommerce.utility.WebDriverUtils;

public class VerifySuscriptionPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public VerifySuscriptionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	// Method to verify if Home Page is loaded
	public boolean isHomePageDisplayed() {
		WebElement automationText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.homeverify));
		return automationText.isDisplayed();
	}

	// Scroll to Footer
	public void scrollToFooter() {
		WebDriverUtils.scrollToBottom(driver);

	}

	// Verify Subscription Text
	public boolean isSubscriptionTextDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.subscriptiontext)).isDisplayed();
	}

	// Enter email and click subscribe
	public void enterEmailAndSubscribe(String email) {
		WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(Locators.ema));
		emailField.sendKeys(email);
		driver.findElement(Locators.subscribeBtn).click();
	}

	// Verify success message
	public boolean isSubscriptionSuccessMessageDisplayed() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.successmsg)).isDisplayed();
		} catch (TimeoutException e) {
			System.out.println("Subscription success message did not appear within the wait time.");
			return false;
		}
	}
}
