package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class SignUpPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public SignUpPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}

	public boolean validateHomePageTitle() {
		String currentUrl = driver.getCurrentUrl();
		boolean actualResult;
		if (currentUrl.equals("https://automationexercise.com/")) {
			actualResult = true;
			Reports.generateReport(driver, test, Status.PASS, "url validated");
		} else {
			actualResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "url not validated");
		}
		return actualResult;

	}

	//  Methods for Actions
	public void clickSignupLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.signupLoginLink)).click();
	}

	public boolean isSignupTextVisible() {
		boolean result = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.newUserSignupText)).isDisplayed();
			Reports.generateReport(driver, test, Status.PASS, "signuptext is visible");
		} catch (Exception e) {
			result = false;
			Reports.generateReport(driver, test, Status.FAIL, "signuptext is not visible");
		}
		return result;
	}

	public void enterUserDetails(String name, String email) {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.nameField)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(Locators.emailField)).sendKeys(email);
	}

	public boolean clickSignupButton() {// use boolean and try catch
		wait.until(ExpectedConditions.elementToBeClickable(Locators.signupButton)).click();
		boolean actResult = true;

		try {
			// explicit wait for Products text
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[2]")));
			Reports.generateReport(driver, test, Status.PASS, "signin is Successful");
		} catch (TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "signin is failure");

		}

		return actResult;

	}

	public boolean isAccountInfoVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.enterAccountInfo)).isDisplayed();

	}

	public void fillAccountDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.titleMr)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Locators.passwordField)).sendKeys("password");
		new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.dayDropdown))).selectByValue("5");
		new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.monthDropdown)))
				.selectByVisibleText("January");
		new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.yearDropdown))).selectByValue("1990");
	}

	public void selectPreferences() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.newsletterCheckbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Locators.optinCheckbox)).click();
	}

	public void fillAddress() {

		wait.until(ExpectedConditions.elementToBeClickable(Locators.firstName)).sendKeys("John");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.lastName)).sendKeys("Doe");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.company)).sendKeys("Company Ltd");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.address1)).sendKeys("123 Street");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.address2)).sendKeys("Apt 4B");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.countryDropdown)).sendKeys("United States");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.state)).sendKeys("California");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.city)).sendKeys("Los Angeles");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.zipcode)).sendKeys("90001");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.mobileNumber)).sendKeys("1234567890");
	}

	public void createAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.createAccountButton)).click();
	}

	public boolean isAccountCreatedVisible() { // take variable and try catch
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.accountCreatedText)).isDisplayed();
	}

	public void clickContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.continueButton)).click();
	}

	public boolean isLoggedInVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loggedInAs)).isDisplayed();
	}

	public void deleteAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.deleteAccountButton)).click();
	}

	public boolean isAccountDeletedVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.accountDeletedText)).isDisplayed();
	}
}
