package com.ecommerce.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class SearchProductsCartPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	Actions actions;

	// Constructor
	public SearchProductsCartPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.actions = new Actions(driver);
		this.test = test;
	}

	// Click on 'Products' button
	public void clickProducts() {
		WebElement productsBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.productsbutton));
		productsBtn.click();
	}

	// Verify user is on the ALL PRODUCTS page
	public boolean isAllProductsPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.allProductsheader)).isDisplayed();
	}

	// Search for a product
	public void searchProduct(String productName) {
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchinput));
		searchBox.clear();
		searchBox.sendKeys(productName);
		WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.searchbutton));
		searchBtn.click();
	}

	// Verify 'SEARCHED PRODUCTS' is visible
	public boolean isSearchResultsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchedproductsHeader)).isDisplayed();
	}

	// Verify all searched products are visible
	public boolean areSearchProductsDisplayed() {
		List<WebElement> products = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.searchedProduct));
		return !products.isEmpty();
	}

	// Click on View Product
	public void clickViewProduct() {
		WebElement viewProduct = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewproductButton));
		viewProduct.click();
	}

	// Hover and Click Add to Cart
	public void hoverAndAddToCart() {
//		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProduct));
//
//		// Hover over the product
//		actions.moveToElement(product).perform();

		// Wait for 'Add to Cart' button to appear and click
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(Locators.addtoCartButton));
		addToCart.click();
	}

	// Click Continue Shopping
	public void continueshopping() {
		WebElement continueShopping = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickshopping));
		continueShopping.click();
	}

	// Click on 'Cart' button
	public void clickCartButton() {
		WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.cartbutton));
		cartBtn.click();
	}

	// Verify products are in the cart
	public boolean areProductsInCart() {
		List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.cartitems));
		return !items.isEmpty();
	}

	public void click() {
		WebElement signupLogin = wait.until(ExpectedConditions.elementToBeClickable(Locators.signupoginButton));
		signupLogin.click();
	}

	// Click 'Signup / Login' button and login
	public void login(String email, String password) {
//		WebElement signupLogin = wait.until(ExpectedConditions.elementToBeClickable(signupLoginButton));
//		signupLogin.click();

		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailnput));
		emailField.clear();
		emailField.sendKeys(email);

		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordinput));
		passwordField.clear();
		passwordField.sendKeys(password);

	}

	public void loginbtn() {
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.loginbtton));
		loginBtn.click();
	}

	// Verify products are still in cart after login
	public boolean areProductsStillInCart() {
		List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.cartitems));
		return !items.isEmpty();
	}

	// Remove all products from the cart
	public void removeAllProductsFromCart() {
		List<WebElement> removeBtns = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.removeproductButtons));
		for (WebElement btn : removeBtns) {
			btn.click();
		}
	}

	// Verify empty cart message
	public boolean isCartEmptyMessageDisplayed() {
		boolean result = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emptyCartMessage));
			Reports.generateReport(driver, test, Status.PASS, "cart empty is displayed");
		} catch (Exception e) {
			result = false;
			Reports.generateReport(driver, test, Status.FAIL, "cart empty is not displayed");
		}
		return result;
	}
}
