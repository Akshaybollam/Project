package com.ecommerce.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class RemoveProductsFromCartPage {
	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest test;

	// Constructor
	public RemoveProductsFromCartPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Verify Home Page is Displayed
	public void verifyHomePageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.PageIdentifier));
		assert element.isDisplayed();
	}

	// Click "View Product"
	public void clickOnProduct() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewProductButn));
		element.click();
	}

	// Add Product to Cart
	public void addProductToCart() {
		WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.addToCartButn));
		addButton.click();
	}

	// Click "Continue Shopping"
	public void clickContinueShopping() {
		WebElement continueShopping = wait.until(ExpectedConditions.elementToBeClickable(Locators.continueShoppingBtn));
		continueShopping.click();
	}

	// Click Cart Button
	public void clickCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.cartBtn)).click();
	}

	// Verify Cart Page is Displayed
	public void verifyCartPageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartPageHeader));
		assert element.isDisplayed();
	}

	// Remove Product from Cart
	public void removeProductFromCart() {
		List<WebElement> removeButtons = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.removeProductButtons));
		if (!removeButtons.isEmpty()) {
			removeButtons.get(0).click();// remove first product
		}
	}

	// Verify Product is Removed
	public void verifyProductIsRemoved() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartEmptyMessage));
		WebElement emptyMessage = driver.findElement(Locators.cartEmptyMessage);
		assert emptyMessage.isDisplayed();
	}
}
