package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.objectrepo.Locators;

public class ViewBrandProductsPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public ViewBrandProductsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Click 'Products' Button
	public void clickProductsButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.productbuton)).click();
	}

	// Verify Brands Sidebar is Visible
	public void verifyBrandsSidebarIsVisible() {
		WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.brandsSidebar));
		Assert.assertTrue(sidebar.isDisplayed(), "Brand sidebar is not visible!");
	}

	// Click on First Brand
	public void clickFirstBrand() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.firstBrand)).click();
	}

	// Verify Brand Page and Products are Displayed
	public void verifyFirstBrandPageIsDisplayed() {
		WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.brandHeader));
		WebElement products = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productGrid));

		Assert.assertTrue(header.isDisplayed(), "Brand page header is not displayed!");
		Assert.assertTrue(products.isDisplayed(), "Brand products are not displayed!");
	}

	// Click on Second Brand
	public void clickSecondBrand() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.secondBrand)).click();
	}

	// Verify Second Brand Page and Products are Displayed
	public void verifySecondBrandPageIsDisplayed() {
		WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.brandHeader));
		WebElement products = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productGrid));

		Assert.assertTrue(header.isDisplayed(), "Second brand page header is not displayed!");
		Assert.assertTrue(products.isDisplayed(), "Second brand products are not displayed!");
	}
}
