package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class LogoutPage {

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public LogoutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	// Methods for Actions
	public void verifyHomePageTitle() {
		wait.until(ExpectedConditions.titleIs("Automation Exercise"));
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home Page Title does not match!");
	}

	public void clickSignupLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.signuporlogin)).click();
	}

	public boolean verifyLoginPageIsVisible() {
		boolean result = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.log)).isDisplayed();
			Reports.generateReport(driver, test, Status.PASS, "Login is visible");
		} catch (Exception e) {
			result = false;
			Reports.generateReport(driver, test, Status.FAIL, "Login is not visible");
		}
		return result;
		// Assert.assertTrue(loginHeaderElement.isDisplayed(), "'Login to your account'
		// is not visible!");
	}

	public void enterCredentials(String email, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.emailid)).sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(Locators.pass)).sendKeys(password);
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.loginbtn)).click();
	}

	public void verifyUserIsLoggedIn(String expectedUsername) {
		WebElement loggedInAsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loggedInas));
		Assert.assertTrue(loggedInAsElement.isDisplayed(), "'Logged in as username' is not visible!");
		Assert.assertEquals(loggedInAsElement.getText(), expectedUsername, "Username does not match!");
	}

	public void clickLogoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.logoutButton)).click();
	}

	public boolean verifyUserIsNavigatedToLoginPage() {
		boolean result=true;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginAgainHeader));
		Reports.generateReport(driver, test, Status.PASS, "navigated to home page");
		}
		catch(Exception e){
			result=false;
			Reports.generateReport(driver, test, Status.FAIL, "Navigation fail");
		}
		return result;
		// Assert.assertTrue(loginAgainHeaderElement.isDisplayed(), "User is not
		// navigated back to the login page!");
	}
}
