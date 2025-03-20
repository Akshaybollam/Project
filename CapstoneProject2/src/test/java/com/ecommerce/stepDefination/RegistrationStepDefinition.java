package com.ecommerce.stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.pages.ContactusPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.LogoutPage;
import com.ecommerce.pages.RecommendedPage;
import com.ecommerce.pages.RegisterBeforeCheckoutPage;
import com.ecommerce.pages.RegisterExistingPage;
import com.ecommerce.pages.RemoveProductsFromCartPage;
import com.ecommerce.pages.ScrollPage;
import com.ecommerce.pages.ScrollwithoutArrowPage;
import com.ecommerce.pages.SignUpPage;
import com.ecommerce.pages.TestCasesPage;
import com.ecommerce.pages.VerifyCategoryPage;
import com.ecommerce.pages.VerifySuscriptionPage;
import com.ecommerce.utility.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinition extends Base {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	SignUpPage signuppage = new SignUpPage(driver, test);
	HomePage page = new HomePage(driver, test);
	LoginPage loginpage = new LoginPage(driver, test);
	LogoutPage logoutpage = new LogoutPage(driver, test);
	RegisterExistingPage regexpage = new RegisterExistingPage(driver, test);
	ContactusPage contactuspage = new ContactusPage(driver, test);
	TestCasesPage testcasespage = new TestCasesPage(driver, test);
	VerifySuscriptionPage verifysuscriptionpage = new VerifySuscriptionPage(driver, test);
	RecommendedPage recommendedpage = new RecommendedPage(driver, test);
	ScrollPage scrollpage = new ScrollPage(driver, test);
	ScrollwithoutArrowPage scroll = new ScrollwithoutArrowPage(driver, test);
	RemoveProductsFromCartPage remove = new RemoveProductsFromCartPage(driver, test);
	VerifyCategoryPage verifycategorypage = new VerifyCategoryPage(driver, test);
	RegisterBeforeCheckoutPage registerPage = new RegisterBeforeCheckoutPage(driver, test);

	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
		boolean actualresult = signuppage.validateHomePageTitle();
		Assert.assertTrue(actualresult);
	}

	@When("User clicks on Signup or Login button")
	public void user_clicks_on_signup_or_login_button() {
		signuppage.clickSignupLogin();
		// Assertion to be added
	}

	@And("User enters a new {string} and {string} address")
	public void user_enters_a_new_and_address(String name, String email) {
		signuppage.enterUserDetails(name, email);
	}

	@And("User clicks on Signup button")
	public void user_clicks_on_signup_button() {
		boolean result = signuppage.clickSignupButton();
		Assert.assertTrue(result);
	}

	@Then("User should see ENTER ACCOUNT INFORMATION form")
	public void user_should_see_enter_account_information_form() {
		signuppage.isAccountInfoVisible();
	}

	@And("User enters account details")
	public void user_enters_account_details() {
		signuppage.fillAccountDetails();
		signuppage.selectPreferences();
	}

	@And("User enters personal details and address information")
	public void user_enters_personal_details_and_address_information() {
		signuppage.fillAddress();
	}

	@And("User clicks on Create Account button")
	public void user_clicks_on_create_account_button() {
		signuppage.createAccount();
		signuppage.isAccountCreatedVisible();//
	}

	@Then("User should see {string} message")
	public void user_should_see_message(String string) {
		signuppage.clickContinue();
		signuppage.isLoggedInVisible();
		signuppage.deleteAccount();
		signuppage.isAccountDeletedVisible();
	}

	// login with valid credentials

	@Then("User should see {string}")
	public void user_should_see(String string) {

		page.verifyLoginPageIsVisible();

	}

	@And("User enters valid {string} and {string}")
	public void user_enters_valid_and(String email, String password) {
		page.enterCredentials(email, password);
	}

	@Then("User clicks on Login button")
	public void user_clicks_on_login_button() {
		page.clickLoginButton();
		page.verifyUserLoggedIn();
	}

	// login with invalid

	@And("User enters invalid {string} and {string}")
	public void user_enters_invalid_and(String email, String password) {
		loginpage.verifyLoginHeader();
		loginpage.enterIncorrectCredentials(email, password);
		loginpage.clickLoginButton();
	}

	@Then("User should see {string} error message")
	public void user_should_see_error_message(String string) {
		loginpage.verifyErrorMessage();
	}

	// logout stepdefinition

	@Then("I should see Login to your account")
	public void i_should_see() {
		boolean result = logoutpage.verifyLoginPageIsVisible();
		Assert.assertTrue(result);
	}

	@When("I enter valid email {string} and password {string}")
	public void i_enter_valid_email_and_password(String email, String password) {
		logoutpage.enterCredentials(email, password);
	}

	@And("I click on the Login button")
	public void click_on_login_button() {
		logoutpage.clickLoginButton();
	}

	@Then("I should see Logged in as {string}")
	public void logged_as_username(String username) {
		logoutpage.verifyUserIsLoggedIn(username);
	}

	@When("I click on the Logout button")
	public void i_click_on_the_logout_button() {
		logoutpage.clickLogoutButton();
	}

	@Then("I should be navigated back to the login page")
	public void i_should_be_navigated_back_to_the_login_page() {
		boolean finalresult = logoutpage.verifyUserIsNavigatedToLoginPage();
		Assert.assertTrue(finalresult);
	}

	// login with register with existing mail

	@Then("User should see New User Signup! text")
	public void user_should_see_text() {
		regexpage.navigateToSignupPage();
		regexpage.isNewUserSignupVisible();
	}

	@When("User enters name {string} and already registered email {string}")
	public void user_enters_name_and_already_registered_email(String name, String email) {
		regexpage.enterNameAndEmail(name, email);
	}

	@And("User clicks on the Signup button")
	public void user_clicks_on_the_signup_button() {
		regexpage.clickSignupButton();
	}

	@Then("User should see an error message {string}")
	public void user_should_see_an_error_message(String string) {
		regexpage.isEmailErrorVisible();
	}

	// contact stepdefinitation
	@When("I navigate to the Contact Us page")
	public void i_navigate_to_the_contact_us_page() {
		contactuspage.contactusbutton();
	}

	@Then("I should see the GET IN TOUCH heading")
	public void i_should_see_the_get_in_touch_heading() {
		boolean result=contactuspage.isGetInTouchVisible();
		Assert.assertTrue(result);
	}

	@When("I fill in the contact form with details")
	public void i_fill_in_the_contact_form_with_details() {
		contactuspage.fillContactForm();
	}

	@When("I upload a file")
	public void i_upload_a_file() {

	}

	@When("I click the Submit button and accept the alert")
	public void i_click_the_submit_button_and_accept_the_alert() {
		contactuspage.clickSubmit();
	}

	@Then("I should see the success message Success! Your details have been submitted successfully.")
	public void i_should_see_the_success_message_success_your_details_have_been_submitted_successfully() {
		boolean result=contactuspage.isSuccessMessageDisplayed();
		Assert.assertTrue(result);
	}

	@When("I click the Home button")
	public void i_click_the_home_button() {
		contactuspage.clickHomeButton();
	}

	@Then("I should be redirected to the home page")
	public void i_should_be_redirected_to_the_home_page() {

	}

	// Testcases stepdefinition
	@When("I click on the Test Cases button")
	public void i_click_on_the_test_cases_button() {
		testcasespage.getHomePageTitle();

	}

	@Then("I should be redirected to the Test Cases page")
	public void i_should_be_redirected_to_the_test_cases_page() {
		testcasespage.clickTestCases();
	}
	// verifysubscruption steps

	@When("I scroll down to the Subscription section")
	public void i_scroll_down_to_the_subscription_section() {
		verifysuscriptionpage.scrollToFooter();
		verifysuscriptionpage.isSubscriptionSuccessMessageDisplayed();
	}

	@And("I enter my email {string} and click subscribe")
	public void i_enter_my_email_and_click_subscribe(String email) {
		verifysuscriptionpage.enterEmailAndSubscribe(email);
	}

	@Then("I should see the success message You have been successfully subscribed!")
	public void i_should_see_the_success_message_you_have_been_successfully_subscribed() {
		verifysuscriptionpage.isSubscriptionSuccessMessageDisplayed();
	}

	// recommended products

	@When("User scrolls to the bottom of the page")
	public void user_scrolls_to_the_bottom_of_the_page() {
		recommendedpage.scrollToBottom();
	}

	@Then("User should see the RECOMMENDED ITEMS section")
	public void user_should_see_the_recommended_items_section() {
		boolean result = recommendedpage.verifyRecommendedItemsVisible();
		Assert.assertTrue(result);
	}

	@When("User clicks Add To Cart on a recommended product")
	public void user_clicks_add_to_cart_on_a_recommended_product() {
		recommendedpage.addRecommendedProductToCart();
	}

	@When("User clicks View Cart button")
	public void user_clicks_view_cart_button() {
		recommendedpage.clickViewCart();
	}

	@Then("The product should be displayed in the cart")
	public void the_product_should_be_displayed_in_the_cart() {
		recommendedpage.verifyProductInCart();
	}

	// scroll up using arrow

	@Then("I should see the home page")
	public void i_should_see_the_home_page() {
		scrollpage.verifyHomePageIsDisplayed();
	}

	@When("I scroll down to the bottom of the page")
	public void i_scroll_down_to_the_bottom_of_the_page() {
		scrollpage.scrollToBottom();
	}

	@Then("I should see Subscription text")
	public void i_should_see_subscription_text() {
		scrollpage.verifySubscriptionIsVisible();
	}

	@When("I click on the button arrow button")
	public void i_click_on_the_button_arrow_button() {
		scrollpage.clickScrollUpArrow();
	}

	@Then("I should see expectedText on screen")
	public void i_should_see_expected_text_on_screen() {
		scrollpage.verifyPageScrolledUp();
	}

	// scrollow without arrow

	@Then("I  see the home page")
	public void i_see_the_home_page() {
		scroll.verifyHomePageIsDisplayed();
	}

	@When("I scroll  to the bottom of the page")
	public void i_scroll_to_the_bottom_of_the_page() {
		scroll.scrollToBottom();
	}

	@Then("I should see section Subscription")
	public void i_should_see_section_subscription() {
		scroll.verifySubscriptionIsVisible();
	}

	@When("I scroll u to the top of the page")
	public void i_scroll_u_to_the_top_of_the_page() {
		scroll.scrollToTop();
	}

	@Then("I should see expectedText")
	public void i_should_see_expected_text() {
		scroll.verifyPageScrolledUp();
	}

	// Remove Product from cart
	@And("I click on View Product")
	public void i_click_on_view_product() {
		remove.clickOnProduct();

	}

	@When("I add a product to the cart")
	public void i_add_a_product_to_the_cart() {
		remove.addProductToCart();
	}

	@And("click continue shopping")
	public void click_continue_shopping() {
		remove.clickContinueShopping();
	}

	@And("I navigate to the cart page")
	public void i_navigate_to_the_cart_page() {
		remove.clickCartButton();
	}

	@Then("I should see the cart page displayed")
	public void i_should_see_the_cart_page_displayed() {
		remove.verifyCartPageIsDisplayed();
	}

	@When("I remove a product from the cart")
	public void i_remove_a_product_from_the_cart() {
		remove.removeProductFromCart();
	}

	@Then("I should see the product is removed")
	public void i_should_see_the_product_is_removed() {
		remove.verifyProductIsRemoved();

	}

	// verify category in home page
	@Then("I should see categories on the left sidebar")
	public void i_should_see_categories_on_the_left_sidebar() {
		boolean result = verifycategorypage.verifyCategorySidebarIsVisible();
		Assert.assertTrue(result);
	}

	@When("I click on the Women category")
	public void i_click_on_the_women_category() {
		verifycategorypage.clickWomenCategory();
	}

	@And("I click on the Dress sub-category under Women")
	public void i_click_on_the_dress_sub_category_under_women() {
		verifycategorypage.clickDressCategory();
	}

	@Then("I should see the WOMEN - DRESS PRODUCTS page")
	public void i_should_see_the_women_dress_products_page() {
		boolean result = verifycategorypage.isWomenDressPageDisplayed();
		Assert.assertTrue(result);
	}

	@When("I click on the Men category")
	public void i_click_on_the_men_category() {
		verifycategorypage.clickMenCategory();
	}

	@And("I click on the Jeans sub-category under Men")
	public void i_click_on_the_jeans_sub_category_under_men() {
		verifycategorypage.clickMenSubCategory();
	}

	@Then("I should see the MEN - JEANS PRODUCTS page")
	public void i_should_see_the_men_jeans_products_page() {
		boolean result = verifycategorypage.isMenJeansPageDisplayed();
		Assert.assertTrue(result);
	}

	// register before checkout

	@When("I enter signup details with name {string} and email {string}")
	public void i_enter_signup_details(String name, String email) {
		registerPage.enterSignupDetails(name, email);
	}

	@And("I enter account details with password {string}, day {string}, month {string}, year {string}")
	public void i_enter_account_details(String password, String day, String month, String year) {
		registerPage.enterAccountInformation(password, day, month, year);
	}

	@And("I enter address details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void i_enter_address_details(String fName, String lName, String comp, String addr1, String addr2,
			String country, String state, String city, String zip, String mobile) {
		registerPage.enterAddressDetails(fName, lName, comp, addr1, addr2, country, state, city, zip, mobile);
	}

	@Then("I should see account created message")
	public void i_should_see_account_created_message() {
		registerPage.verifyAccountCreated();
	}

	@When("I click Continue")
	public void i_click_continue() {
		registerPage.clickContinue();
	}

	@Then("I should be logged in as a user")
	public void i_should_be_logged_in_as_user() {
		registerPage.verifyLoggedInUser();
	}

	@When("I add products to cart and go to cart page")
	public void i_add_products_to_cart_and_go_to_cart_page() {
		registerPage.addProductsToCart();
		registerPage.goToCart();
	}

	@And("I proceed with checkout")
	public void i_proceed_to_checkout() {
		registerPage.proceedToCheckout();
	}

	@Then("I should see address and order review details")
	public void i_should_see_address_and_order_review_details() {
		registerPage.verifyAddressAndOrderReview();
	}

	@When("I enter comment {string} and place the order")
	public void i_enter_comment_and_place_the_order(String comment) {
		registerPage.enterComment(comment);
		registerPage.placeOrder();
	}

	@And("I enter the payment details {string}, {string}, {string}, {string}, {string}")
	public void i_enter_payment_details(String name, String cardNum, String cvc, String expMonth, String expYear) {
		registerPage.enterPaymentDetails(name, cardNum, cvc, expMonth, expYear);
	}

	@And("I confirm  order")
	public void i_confirm_the_order() {
		registerPage.confirmOrder();
	}

	@Then("I should see success message")
	public void i_should_see_success_message() {
		registerPage.verifySuccessMessage();
	}

	@When("I delete the account")
	public void i_delete_my_account() {
		registerPage.deleteAccount();
	}

	@Then("I should see account deleted message")
	public void i_should_see_account_deleted_message() {
		registerPage.verifyAccountDeleted();
	}

}
