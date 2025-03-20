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
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class RecommendedPage {

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	// ✅ Constructor
	public RecommendedPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.test = test;
	}

	//

	// ✅ Scroll to Bottom of Page
	public void scrollToBottom() {
		WebElement element = driver.findElement(Locators.recommended);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public boolean verifyRecommendedItemsVisible() {
		boolean result=true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.recommendedItemsSection));
			Reports.generateReport(driver, test, Status.PASS, "Recommended items are visible");
		}
		catch(Exception e) {
			result =false;
			Reports.generateReport(driver, test, Status.FAIL, "Recommended items are not visible");
		}
		// Assert.assertTrue(section.isDisplayed(), "'RECOMMENDED ITEMS' section is NOT
		// visible!");
		return result;
	}

	// Click Add To Cart on Recommended Product
	public void addRecommendedProductToCart() {

		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(Locators.CartButton));
		addToCart.click();
	}

	// Click View Cart Button
	public void clickViewCart() {
		WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewButton));
		viewCart.click();
	}

	// Verify Product is Displayed in Cart
	public void verifyProductInCart() {
		List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.cartItems));
		Assert.assertFalse(items.isEmpty(), "No products found in the cart!");
	}
}
