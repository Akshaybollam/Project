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

public class ProductReviewPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public ProductReviewPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	// Click on Products Button
	public void clickOnProducts() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locators.productsBtn));
		Assert.assertTrue(element.isDisplayed(), "Products button is NOT visible!");
		element.click();
	}

	// Verify Navigation to ALL PRODUCTS Page
	public void verifyAllProductsPageIsDisplayed() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.allProductsHeader));
		Assert.assertTrue(element.isDisplayed(), "All Products page is NOT displayed!");
	}

	// Click on View Product Button
	public void clickOnViewProduct() {
		WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewProductBtn));
		Assert.assertTrue(viewButton.isDisplayed(), "'View Product' button is NOT visible!");
		viewButton.click();
	}

	// Verify Write Your Review is Visible
	public boolean verifyReviewSectionIsDisplayed() {
		boolean result = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.reviewSection));
			Reports.generateReport(driver, test, Status.PASS, "review section is displayed");
		} catch (Exception e) {
			result = false;
			Reports.generateReport(driver, test, Status.FAIL, "review section is not displayed");
		}
		return result;
		// Assert.assertTrue(reviewText.isDisplayed(), "'Write Your Review' section is
		// NOT visible!");
	}

	// Enter Name, Email, and Review
	public void enterReviewDetails(String name, String email, String review) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.nam)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.em)).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.reviewField)).sendKeys(review);
	}

	// Click Submit Button
	public void clickSubmitReview() {
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(Locators.submitBtn));
		submit.click();
	}

	// Verify Success Message
	public boolean verifySuccessMessage() {
		boolean result=true;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.success));
		Reports.generateReport(driver, test, Status.PASS, "Success message is dispalyed");
		}
		catch(Exception e) {
			result=false;
			Reports.generateReport(driver, test, Status.FAIL, "success message is not displayed");
		}
		return result;
		// Assert.assertTrue(message.isDisplayed(), "Success message is NOT visible!");
	}
}
