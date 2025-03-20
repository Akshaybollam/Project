package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class VerifyCategoryPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public VerifyCategoryPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Verify Categories are Visible on Left Sidebar
	public boolean verifyCategorySidebarIsVisible() {
		boolean result = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.categorySidebar));
			Reports.generateReport(driver, test, Status.PASS, "category side bar is visible");
		} catch (Exception e) {
			result = false;
			Reports.generateReport(driver, test, Status.FAIL, "category side bar is not visible");
		}
		return result;
		// Assert.assertTrue(sidebar.isDisplayed(), "Category sidebar is not visible!");
	}

	// Click 'Women' Category and Verify Navigation
	public void clickWomenCategory() {
		WebElement womenCategoryElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.womenCategory));
		womenCategoryElement.click();
	}

	// Click on 'Dress' Category under 'Women' and Verify Navigation
	public void clickDressCategory() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.dressCategory)).click();
		Assert.assertTrue(isWomenDressPageDisplayed(), "Failed to navigate to WOMEN - DRESS PRODUCTS page!");
	}

	// Verify Category Page is Displayed for 'WOMEN - DRESS PRODUCTS'
	public boolean isWomenDressPageDisplayed() {
		boolean result = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.categoryHeader));
			Reports.generateReport(driver, test, Status.PASS, "women dress page is displayed");
		} catch (Exception e) {
			result = false;
			Reports.generateReport(driver, test, Status.FAIL, "women dress page is not displayed");

		}
		return result;
//		boolean isDisplayed = header.isDisplayed();
//		Assert.assertTrue(isDisplayed, "WOMEN - DRESS PRODUCTS page is not displayed!");
//		return isDisplayed;
	}

	// Click on 'Men' Category and Verify Navigation
	public void clickMenCategory() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.menCategory)).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("category"), "Failed to navigate to Men's category page!");
	}

	// Click on 'Jeans' under 'Men' Category and Verify Navigation
	public void clickMenSubCategory() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.menSubCategory)).click();
		Assert.assertTrue(isMenJeansPageDisplayed(), "Failed to navigate to MEN - JEANS PRODUCTS page!");
	}

	// Verify Category Page is Displayed for 'MEN - JEANS PRODUCTS'
	public boolean isMenJeansPageDisplayed() {
		boolean result = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.menCategoryHeader));
			Reports.generateReport(driver, test, Status.PASS, "men jeans is displayed");
		} catch (Exception e) {
			result = false;
			Reports.generateReport(driver, test, Status.FAIL, "men jeans is not displayed");
		}
		return result;
	}
//		boolean isDisplayed = header.isDisplayed();
//		Assert.assertTrue(isDisplayed, "MEN - JEANS PRODUCTS page is not displayed!");
//		return isDisplayed;
}
