package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class RegisterBeforeCheckoutPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public RegisterBeforeCheckoutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Actions
	public void clickSignupLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.signin)).click();
	}

	public void enterSignupDetails(String name, String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.entername)).sendKeys(name);
		driver.findElement(Locators.entermail).sendKeys(email);
		driver.findElement(Locators.signupBtn).click();
	}

	public void enterAccountInformation(String password, String day, String month, String year) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.enterAccountinfo));
		driver.findElement(Locators.titlemr).click();
		driver.findElement(Locators.enterpassword).sendKeys(password);

		// Selecting values from dropdowns
		Select daySelect = new Select(driver.findElement(Locators.enterday));
		daySelect.selectByValue(day);

		Select monthSelect = new Select(driver.findElement(Locators.entermonth));
		monthSelect.selectByVisibleText(month);

		Select yearSelect = new Select(driver.findElement(Locators.enteryear));
		yearSelect.selectByValue(year);

		driver.findElement(Locators.newslettercheckbox).click();
		driver.findElement(Locators.optincheckbox).click();
	}

	public void enterAddressDetails(String fName, String lName, String comp, String addr1, String addr2, String country,
			String stateName, String cityName, String zip, String mobile) {
		driver.findElement(Locators.firstname).sendKeys(fName);
		driver.findElement(Locators.lastname).sendKeys(lName);
		driver.findElement(Locators.companydetails).sendKeys(comp);
		driver.findElement(Locators.addressone).sendKeys(addr1);
		driver.findElement(Locators.addresstwo).sendKeys(addr2);

		// Selecting country
		Select countrySelect = new Select(driver.findElement(Locators.entercountry));
		countrySelect.selectByVisibleText(country);

		driver.findElement(Locators.enterstate).sendKeys(stateName);
		driver.findElement(Locators.entercity).sendKeys(cityName);
		driver.findElement(Locators.enterzipcode).sendKeys(zip);
		driver.findElement(Locators.entermobileNumber).sendKeys(mobile);

		driver.findElement(Locators.createaccountButton).click();
	}

	public void verifyAccountCreated() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.accountCreatedMsg));
	}

	public void clickContinue() {
		driver.findElement(Locators.continuebutton).click();
	}

	public void verifyLoggedInUser() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loggedInUser));
	}

	public void addProductsToCart() {
		driver.findElement(Locators.products).click();
		driver.findElement(Locators.firstproduct).click();
		wait.until(ExpectedConditions.elementToBeClickable(Locators.addTocartButton)).click();
	}

	public void goToCart() {
		WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.cartButton));
		cartButton.click();
	}

	public void proceedToCheckout() {
		driver.findElement(Locators.proceedTocheckoutButton).click();
	}

	public void verifyAddressAndOrderReview() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.addresdetails));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.revieworders));
	}

	public void enterComment(String comment) {
		driver.findElement(Locators.commentArea).sendKeys(comment);
	}

	public void placeOrder() {
		driver.findElement(Locators.placeorderbutton).click();
	}

	public void enterPaymentDetails(String name, String cardNum, String cvcNum, String expMonth, String expYear) {
		driver.findElement(Locators.nameonCard).sendKeys(name);
		driver.findElement(Locators.cardnumbers).sendKeys(cardNum);
		driver.findElement(Locators.cvc).sendKeys(cvcNum);
		driver.findElement(Locators.expirationMonth).sendKeys(expMonth);
		driver.findElement(Locators.expirationYear).sendKeys(expYear);
	}

	public void confirmOrder() {
		driver.findElement(Locators.payAndconfirmButton).click();
	}

	public void verifySuccessMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.successmssg));
	}

	public void deleteAccount() {
		driver.findElement(Locators.deleteaccountButton).click();
	}

	public void verifyAccountDeleted() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.accountdeletedMessage));
	}
}
