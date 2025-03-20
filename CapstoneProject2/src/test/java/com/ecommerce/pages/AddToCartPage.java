package com.ecommerce.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class AddToCartPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	ExtentTest test;

	// Constructor
	public AddToCartPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.actions = new Actions(driver);
		this.test = test;
	}

	// Verify Home Page is Visible
	public void verifyHomePageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.homePageIdentifier));
		Assert.assertTrue(element.isDisplayed(), "Home page is NOT displayed!");
	}

	// Click on Products Button
	public void clickOnProducts() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locators.productsButton));
		Assert.assertTrue(element.isDisplayed(), "Products button is NOT visible!");
		element.click();
	}

	// Hover over First Product and Click Add to Cart
	public void addFirstProductToCart() {
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstProduct));
		product.click();
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(Locators.firstProductAddToCart));
		Assert.assertTrue(addToCart.isDisplayed(), "'Add to Cart' button is NOT visible for first product!");
		addToCart.click();
	}

	// Click Continue Shopping
	public void clickContinueShopping() {
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Locators.continueShoppingButton));
		Assert.assertTrue(button.isDisplayed(), "'Continue Shopping' button is NOT visible!");
		button.click();
		driver.navigate().back();
	}

	// Hover over Second Product and Click Add to Cart
	public void addSecondProductToCart() {
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.secondProduct));
		product.click();
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(Locators.secondProductAddToCart));
		Assert.assertTrue(addToCart.isDisplayed(), "'Add to Cart' button is NOT visible for second product!");
		addToCart.click();
		driver.navigate().refresh();
	}

	// Click on View Cart Button
	public void clickViewCart() {
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewCartButton));
		Assert.assertTrue(button.isDisplayed(), "'View Cart' button is NOT visible!");
		button.click();
	}

	public void verifyProductsByIndex(String firstProductName, String secondProductName) {
		WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartItems1));
		WebElement secondProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartItems2));

		Assert.assertEquals(firstProduct.getText(), firstProductName, "First product name does not match!");
		Assert.assertEquals(secondProduct.getText(), secondProductName, "Second product name does not match!");
	}

	// Verify Product Prices, Quantity, and Total Price
	public void verifyCartDetails(String expectedPrice1, String expectedPrice2, String expectedTotal1,
			String expectedTotal2) {
		List<WebElement> prices = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.productPrices));
		List<WebElement> quantities = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.productQuantities));
		List<WebElement> totalPrices = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.productTotalPrices));

		// Verify price of first and second product
		Assert.assertEquals(prices.get(0).getText(), expectedPrice1, "First product price is incorrect!");
		Assert.assertEquals(prices.get(1).getText(), expectedPrice2, "Second product price is incorrect!");

		// Verify quantity is 1 for both products
		Assert.assertEquals(quantities.get(0).getText(), "1", "First product quantity is incorrect!");
		Assert.assertEquals(quantities.get(1).getText(), "1", "Second product quantity is incorrect!");

		// Verify total price calculation
		Assert.assertEquals(totalPrices.get(0).getText(), expectedTotal1, "First product total price is incorrect!");
		Assert.assertEquals(totalPrices.get(1).getText(), expectedTotal2, "Second product total price is incorrect!");
	}
}
