package com.ecommerce.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class VerifyProductsPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public VerifyProductsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Verify Home Page is Visible
	public void verifyHomePageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.homePagevalidate));
		Assert.assertTrue(element.isDisplayed(), "Home page is NOT displayed!");
	}

	// Click on Products Button
	public void clickOnProducts() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locators.productsButn));
		Assert.assertTrue(element.isDisplayed(), "Products button is NOT visible!");
		element.click();
	}

	// Verify Navigation to All Products Page
	public void verifyAllProductsPageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.allProducts));
		Assert.assertTrue(element.isDisplayed(), "All Products page is NOT displayed!");
	}

	// Verify Products List is Visible
	public void verifyProductsListIsDisplayed() {
		List<WebElement> products = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.productList));
		Assert.assertFalse(products.isEmpty(), "Product list is NOT displayed!");
	}

	// Click on View Product for the First Product
	public void clickOnFirstProductView() {
		WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.firstProductViewButton));
		Assert.assertTrue(viewButton.isDisplayed(), "'View Product' button is NOT visible!");
		viewButton.click();
	}

	// Verify Product Details Page
	public void verifyProductDetailPage() {
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productName)).isDisplayed(),
				"Product Name is NOT visible!");
		Assert.assertTrue(
				wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productCategory)).isDisplayed(),
				"Product Category is NOT visible!");
		Assert.assertTrue(
				wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productPrice)).isDisplayed(),
				"Product Price is NOT visible!");
		Assert.assertTrue(
				wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productAvailability)).isDisplayed(),
				"Product Availability is NOT visible!");
		Assert.assertTrue(
				wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productCondition)).isDisplayed(),
				"Product Condition is NOT visible!");
		Assert.assertTrue(
				wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productBrand)).isDisplayed(),
				"Product Brand is NOT visible!");
	}
}
