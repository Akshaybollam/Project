package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// **Constructor**
	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test=test;
	}

	// **Methods**
	public void navigateToLoginPage() {
		driver.findElement(Locators.signupLogin).click();
	}

	public void verifyLoginPageIsVisible() {
		WebElement loginText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginHeader));
		Assert.assertTrue(loginText.isDisplayed(), "'Login to your account' is not visible!");
	}

	public void enterCredentials(String email, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.email)).sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(Locators.password)).sendKeys(password);
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton)).click();
	}

	public void verifyUserLoggedIn() {
		// WebElement loggedInText = driver.findElement(loggedInAs);
		// Assert.assertTrue(loggedInText.isDisplayed(), "'Logged in as Testuser' is not
		// visible!");
		// Assert.assertEquals(loggedInText.getText(), "Testuser", "Username does not
		// match!");
	}
}
