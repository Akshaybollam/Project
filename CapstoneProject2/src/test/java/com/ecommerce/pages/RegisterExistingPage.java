package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class RegisterExistingPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public RegisterExistingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Actions
	public void navigateToSignupPage() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.signupLoginButton)).click();
	}

	public boolean isNewUserSignupVisible() {
		boolean result =true;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.newusersignuptext)).isDisplayed();
		Reports.generateReport(driver, test, Status.PASS, "New user signup visible");
		}
		catch(Exception e) {
			result=false;
			Reports.generateReport(driver, test, Status.FAIL, "NewUser signup is not visible");
		}
		return result;
	}

	public void enterNameAndEmail(String name, String email) {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.namefield)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(Locators.mail)).sendKeys(email);
	}

	public void clickSignupButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.signupbutton)).click();
	}

	public boolean isEmailErrorVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailError)).isDisplayed();
	}
}
