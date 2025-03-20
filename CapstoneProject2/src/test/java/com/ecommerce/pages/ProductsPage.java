package com.ecommerce.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class ProductsPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public ProductsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Verify Home Page is Visible
	public void verifyHomePageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.homeIdentifier));
		Assert.assertTrue(element.isDisplayed(), "Home page is NOT displayed!");
	}

	// Click on Products Button
	public void clickOnProducts() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locators.productButton));
		Assert.assertTrue(element.isDisplayed(), "Products button is NOT visible!");
		element.click();
	}

	// Verify Navigation to All Products Page
	public boolean verifyAllProductsPageIsDisplayed() {
		boolean result=true;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ProductsHeader));
		Reports.generateReport(driver, test, Status.PASS, "product page is not displayed");
		}
		catch(Exception e) {
			result=false;
			Reports.generateReport(driver, test, Status.FAIL, "products page is not displayed");
		}
		return result;
		// Assert.assertTrue(element.isDisplayed(), "All Products page is NOT
		// displayed!");
	}

	// Search for a Product
	public void searchForProduct(String productName) {
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(Locators.searchInput));
		Assert.assertTrue(searchBox.isDisplayed(), "Search input field is NOT visible!");

		searchBox.clear();
		searchBox.sendKeys(productName);
		driver.findElement(Locators.searchButton).click();
	}

	// Verify Searched Product Header
	public void verifySearchedProductsHeaderIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchedProductsHeader));
		Assert.assertTrue(element.isDisplayed(), "'Searched Products' header is NOT displayed!");
	}

	// Verify All Searched Products are Visible
	public void verifySearchedProductsAreDisplayed() {
		List<WebElement> products = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.productResults));
		Assert.assertFalse(products.isEmpty(), "No searched products are displayed!");
	}
}
