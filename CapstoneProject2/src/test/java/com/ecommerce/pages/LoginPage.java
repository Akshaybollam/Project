package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	public void navigateToLoginPage() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.signuporlogin)).click();
	}

	public void verifyLoginHeader() {
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.login)).isDisplayed(),
				"'Login to your account' is not visible!");
	}

	public void enterIncorrectCredentials(String email, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.emailfield)).sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(Locators.passwordfield)).sendKeys(password);
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.loginbutton)).click();
	}

	public void verifyErrorMessage() {
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.errorMessage));
		Assert.assertTrue(error.isDisplayed(), "'Your email or password is incorrect!' error is not visible!");
		Assert.assertEquals(error.getText(), "Your email or password is incorrect!", "Error message does not match!");
	}
}
