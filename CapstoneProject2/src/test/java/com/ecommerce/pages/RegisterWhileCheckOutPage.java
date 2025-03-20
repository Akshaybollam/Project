package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class RegisterWhileCheckOutPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public RegisterWhileCheckOutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Verify Home Page is Displayed
	public void verifyHomePageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.pageIdentifier));
		Assert.assertTrue(element.isDisplayed(), "Home page is not displayed!");
	}

	public void clickproducthome() {
		WebElement clickproduct = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.clickproduct));

	}

	public void addProductsToCart() {
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productItem));

		// Hover over the product
//		Actions actions = new Actions(driver);
//		actions.moveToElement(product).perform();
		product.click();

		// Wait for Add to Cart button to appear and click it
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(Locators.addToCartButtons));
		addToCart.click();
	}

	// Click 'Cart' Button (After Hovering)
	public void clickCartButton() {
		WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartbn));
		cartIcon.click();
//		// Hover over the product before clicking the cart (if required)
//		Actions actions = new Actions(driver);
//		actions.moveToElement(cartIcon).perform();
//
//		// Click the cart button once it's clickable
//		wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
	}

	// Verify Cart Page is Displayed
	public void verifyCartPageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartHeader));
		Assert.assertTrue(element.isDisplayed(), "Cart page is not displayed!");
	}

	// Click 'Proceed To Checkout'
	public void clickProceedToCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.proceedToCheckout)).click();
	}

	// Click 'Register / Login' Button
	public void clickRegisterLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.registerLoginButton)).click();
	}

	public void fillSignupDetails(String name, String email, String password, String firstName, String lastName,
			String address, String country, String state, String city, String zipcode, String mobileNumber) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.registername)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.registeremail)).sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(Locators.signupbn)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.registerpassword)).sendKeys(password);
		new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.day))).selectByValue("5");
		new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.month))).selectByVisibleText("January");
		new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.year))).selectByValue("1990");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstNameField)).sendKeys(firstName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.lastNameField)).sendKeys(lastName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.addressField)).sendKeys(address);
		new Select(wait.until(ExpectedConditions.elementToBeClickable(Locators.countryField)))
				.selectByVisibleText("India");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.stateField)).sendKeys(state);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cityField)).sendKeys(city);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.zipcodeField)).sendKeys(zipcode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobileNumberField)).sendKeys(mobileNumber);

		wait.until(ExpectedConditions.elementToBeClickable(Locators.createAccountBtn)).click();
	}

	// Verify 'ACCOUNT CREATED!' and Click 'Continue' Button
	public void verifyAccountCreatedAndContinue() {
		WebElement accountCreated = wait
				.until(ExpectedConditions.visibilityOfElementLocated(Locators.accountCreatedMessage));
		Assert.assertTrue(accountCreated.isDisplayed(), "Account creation message not displayed!");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.continueBtn)).click();
	}

	// Verify 'Logged in as username' at Top
	public void verifyLoggedInAsDisplayed() {
		WebElement loggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loggedas));
		Assert.assertTrue(loggedIn.isDisplayed(), "User is not logged in!");
	}

	// Click 'Cart' Button Again After Login
	public void clickCartButtonAfterLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.cartButtonAfterLogin)).click();
	}

	// Click 'Proceed To Checkout' Again After Login
	public void clickProceedToCheckoutAfterLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.proceedToCheckoutAfterLogin)).click();
	}

	public void verifyAddressDetailsAndReviewOrder() {
		WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.addressDetails));
		WebElement review = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.reviewOrder));

		Assert.assertTrue(address.isDisplayed(), "Address Details are not visible!");
		Assert.assertTrue(review.isDisplayed(), "Review Your Order section is not visible!");
	}

	// Enter Description in Comment Text Area and Click 'Place Order'
	public void enterCommentAndPlaceOrder(String comment) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.commentTextArea)).sendKeys(comment);
		wait.until(ExpectedConditions.elementToBeClickable(Locators.placeOrderButton)).click();
	}

	// Enter Payment Details
	public void enterPaymentDetails(String name, String cardNum, String cvv, String expMonth, String expYear) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.nameOnCard)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cardNumber)).sendKeys(cardNum);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cvv)).sendKeys(cvv);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.expiryMonth)).sendKeys(expMonth);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.expiryYear)).sendKeys(expYear);
	}

	// Click 'Pay and Confirm Order' Button
	public void clickPayAndConfirmOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.payAndConfirmButton)).click();
	}

	// Verify Success Message
	public void verifySuccessMessage() {
		WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.successmessage));
		Assert.assertTrue(success.isDisplayed(), "Order success message not displayed!");
	}

	// Click 'Delete Account' Button
	public void clickDeleteAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.deleteAccountBtn)).click();
	}

	// Verify 'ACCOUNT DELETED!' and Click 'Continue' Button
	public void verifyAccountDeletedAndContinue() {
		WebElement accountDeleted = wait
				.until(ExpectedConditions.visibilityOfElementLocated(Locators.accountDeletedMessage));
		Assert.assertTrue(accountDeleted.isDisplayed(), "Account deletion message not displayed!");
		wait.until(ExpectedConditions.elementToBeClickable(Locators.continueBtn)).click();
	}
}
