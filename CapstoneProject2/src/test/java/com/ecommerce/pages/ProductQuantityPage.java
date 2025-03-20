package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class ProductQuantityPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public ProductQuantityPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Verify Home Page is Visible
	public void verifyHomePageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.home));
		Assert.assertTrue(element.isDisplayed(), "Home page is NOT displayed!");
	}

	// Click 'View Product' for Any Product on Home Page
	public void clickOnViewProduct() {
		WebElement viewProduct = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewProductButton));
		Assert.assertTrue(viewProduct.isDisplayed(), "'View Product' button is NOT visible!");
		viewProduct.click();
	}

	// Verify Product Detail Page is Opened
	public void verifyProductDetailIsOpened() {
		WebElement productDetailElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(Locators.productDetail));
		Assert.assertTrue(productDetailElement.isDisplayed(), "Product Detail Page is NOT opened!");
	}

	// Set Product Quantity
	public void setProductQuantity(int quantity) {
		WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.quantityField));
		quantityInput.clear();
		quantityInput.sendKeys(String.valueOf(quantity));
	}

	// Click Add to Cart Button
	public void clickAddToCart() {
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(Locators.addToCartButton));
		addToCart.click();
	}

	// Click View Cart Button
	public void clickViewCart() {
		WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewCartbtn));
		viewCart.click();
	}

	// Verify Product Quantity in Cart
	public void verifyProductQuantityInCart(int expectedQuantity) {
		WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartQuantity));
		String actualQuantity = quantityInput.getText(); // Get value from input field
		Assert.assertEquals(actualQuantity, String.valueOf(expectedQuantity),
				"Product quantity in cart does NOT match!");

	}
}
