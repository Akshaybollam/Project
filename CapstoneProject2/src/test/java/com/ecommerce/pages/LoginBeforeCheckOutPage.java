package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class LoginBeforeCheckOutPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public LoginBeforeCheckOutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Methods with Explicit Waits

	public void clickSignupLogin() {
		WebElement signupLogin = wait.until(ExpectedConditions.elementToBeClickable(Locators.signuploginButton));
		signupLogin.click();
	}

	public void login(String email, String password) {
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailinput));
		emailField.clear();
		emailField.sendKeys(email);

		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
		passwordField.clear();
		passwordField.sendKeys(password);

		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.loginbton));
		loginBtn.click();
	}

	public boolean isUserLoggedIn() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loggedinas)).isDisplayed();
	}

	public void clickproducts() {
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.clickproducts));
		product.click();
	}

	public void clickonproduct() {
		WebElement clickproduct = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.viewproduct));
		clickproduct.click();
	}

	public void clickCartButton() {
		WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.Addtocart));
		cartBtn.click();
	}

	public void clickviewcart() {
		WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.viewcarttext));
		cart.click();

	}

	public boolean verifycartisdisplayed() {
		boolean result = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartverify));
			Reports.generateReport(driver, test, Status.PASS, "cart page is verified");
		} catch (Exception e) {
			result = false;
			Reports.generateReport(driver, test, Status.FAIL, "cart page is not verified");
		}
		return result;
	}

	public void clickProceedToCheckout() {
		WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.proceedToCheckoutButton));
		checkoutBtn.click();
	}

	public boolean isCheckoutPageDisplayed() {
		WebElement addressDetailsVisible = wait
				.until(ExpectedConditions.visibilityOfElementLocated(Locators.addressdetails));
		WebElement reviewOrderVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.revieworder));
		return addressDetailsVisible.isDisplayed() && reviewOrderVisible.isDisplayed();
	}

	public void enterComment(String comment) {
		WebElement commentBox = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.commenttextArea));
		commentBox.clear();
		commentBox.sendKeys(comment);
	}

	public void clickPlaceOrder() {
		WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.placeorderButton));
		placeOrderBtn.click();
	}

	public void enterPaymentDetails(String name, String card, String cvc, String month, String year) {
		WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.nameOncard));
		nameField.clear();
		nameField.sendKeys(name);

		WebElement cardField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cardnumber));
		cardField.clear();
		cardField.sendKeys(card);

		WebElement cvcField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cvvnumber));
		cvcField.clear();
		cvcField.sendKeys(cvc);

		WebElement monthField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.expirymonth));
		monthField.clear();
		monthField.sendKeys(month);

		WebElement yearField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.expiryyear));
		yearField.clear();
		yearField.sendKeys(year);
	}

	public void clickPayAndConfirm() {
		WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.payAndConfirmButton));
		confirmBtn.click();
	}

	public boolean isOrderConfirmed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.successmssage)).isDisplayed();
	}

	public void downloadInvoice() {
		driver.findElement(Locators.invoicedownload).click();
	}

}
