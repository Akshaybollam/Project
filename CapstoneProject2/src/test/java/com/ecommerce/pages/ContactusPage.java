package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.objectrepo.Locators;
import com.ecommerce.utility.Reports;

public class ContactusPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public ContactusPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	public void contactusbutton() {
		driver.findElement(Locators.contactus).click();
	}

	public boolean isGetInTouchVisible() {
		boolean actualresult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.getInTouchText)).isDisplayed();
			Reports.generateReport(driver, test, Status.PASS, "Get in touch is visible");
		} catch (Exception e) {
			actualresult = false;
			Reports.generateReport(driver, test, Status.FAIL, "get in touch is not visible");
		}
		return actualresult;
	}

	public void fillContactForm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.name)).sendKeys("name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mailid)).sendKeys("Aksh146@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.subjectField)).sendKeys("subject");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.messageField)).sendKeys("message");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.fileUpload))
				.sendKeys("C:\\Users\\bolla\\OneDrive\\Desktop\\my documents\\Azure.pdf");
	}

	public void clickSubmit() {
		driver.findElement(Locators.submitButton).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	public boolean isSuccessMessageDisplayed() {
		boolean actualresult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.successMessage)).isDisplayed();
			Reports.generateReport(driver, test, Status.PASS, "success message is displayed");
		} catch (Exception e) {
			actualresult = false;
			Reports.generateReport(driver, test, Status.FAIL, "success message is not displayed");
		}
		return actualresult;
	}

	public void clickHomeButton() {
		WebElement homeBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.homeButton));
		homeBtn.click();
	}
}
