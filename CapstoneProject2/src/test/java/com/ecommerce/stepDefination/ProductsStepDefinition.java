package com.ecommerce.stepDefination;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.pages.AddToCartPage;
import com.ecommerce.pages.CartSubscriptionPage;
import com.ecommerce.pages.LoginBeforeCheckOutPage;
import com.ecommerce.pages.ProductQuantityPage;
import com.ecommerce.pages.ProductReviewPage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.pages.RegisterWhileCheckOutPage;
import com.ecommerce.pages.SearchProductsCartPage;
import com.ecommerce.pages.VerifyProductsPage;
import com.ecommerce.pages.ViewBrandProductsPage;
import com.ecommerce.utility.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ProductsStepDefinition extends Base {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	ProductsPage productspage = new ProductsPage(driver, test);
	AddToCartPage addtocartpage = new AddToCartPage(driver, test);
	VerifyProductsPage verifyproductspage = new VerifyProductsPage(driver, test);
	CartSubscriptionPage cartpagesubscription = new CartSubscriptionPage(driver, test);
	ProductQuantityPage productquantitypage = new ProductQuantityPage(driver, test);
	ProductReviewPage productreviewpage = new ProductReviewPage(driver, test);
	ViewBrandProductsPage viewbrandproductspage = new ViewBrandProductsPage(driver, test);
	SearchProductsCartPage cartpage = new SearchProductsCartPage(driver, test);
	LoginBeforeCheckOutPage checkoutpage = new LoginBeforeCheckOutPage(driver, test);
	RegisterWhileCheckOutPage checkout = new RegisterWhileCheckOutPage(driver, test);

	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
		productspage.verifyHomePageIsDisplayed();
		verifyproductspage.verifyHomePageIsDisplayed();
		cartpagesubscription.verifyHomePageIsDisplayed();
		productquantitypage.verifyHomePageIsDisplayed();
	}

	@When("User clicks on the Products button")
	public void user_clicks_on_the_products_button() {
		productspage.clickOnProducts();
		verifyproductspage.clickOnProducts();
	}

	@Then("User should be navigated to the ALL PRODUCTS page")
	public void user_should_be_navigated_to_the_all_products_page() {
		productspage.verifyAllProductsPageIsDisplayed();
		verifyproductspage.verifyAllProductsPageIsDisplayed();
	}

	@When("User enters product name {string} in search input and clicks search button")
	public void user_enters_product_name_in_search_input_and_clicks_search_button(String productName) {
		productspage.searchForProduct(productName);
	}

	@Then("User should see the SEARCHED PRODUCTS section")
	public void user_should_see_the_searched_products_section() {
		productspage.verifySearchedProductsHeaderIsDisplayed();
	}

	@And("User should see all related products displayed")
	public void user_should_see_all_related_products_displayed() {
		productspage.verifySearchedProductsAreDisplayed();
	}

	// verify products stepdefinition

	@And("The products list should be visible")
	public void the_products_list_should_be_visible() {
		verifyproductspage.verifyProductsListIsDisplayed();
	}

	@When("User clicks on View Product of the first product")
	public void user_clicks_on_view_product_of_the_first_product() {
		verifyproductspage.clickOnFirstProductView();
	}

	@Then("User should be navigated to the product detail page")
	public void user_should_be_navigated_to_the_product_detail_page() {

	}

	@And("User should see the product details: name, category, price, availability, condition, brand")
	public void user_should_see_the_product_details_name_category_price_availability_condition_brand() {
		verifyproductspage.verifyProductDetailPage();

	}

	/// cart page stepdefinition
	@When("I click on the Products button")
	public void i_click_on_the_products_button() {
		addtocartpage.clickOnProducts();
	}

	@And("I hover over the first product and add it to the cart")
	public void i_hover_over_the_first_product_and_add_it_to_the_cart() {
		addtocartpage.addFirstProductToCart();
	}

	@And("I click Continue Shopping")
	public void i_click_continue_shopping() {
		addtocartpage.clickContinueShopping();
	}

	@And("I hover over the second product and add it to the cart")
	public void i_hover_over_the_second_product_and_add_it_to_the_cart() {
		addtocartpage.addSecondProductToCart();
	}

	@And("I click View Cart button")
	public void i_click_view_cart_button() {
		addtocartpage.clickViewCart();
	}

	@Then("Both products should be in the Cart with {string} and {string}")
	public void both_products_should_be_in_the_cart_with_and(String firstProductName, String secondProductName) {
		addtocartpage.verifyProductsByIndex(firstProductName, secondProductName);
	}

	@And("Product details should be {string}, {string}, {string}, {string}")
	public void product_details_should_be(String expectedPrice1, String expectedPrice2, String expectedTotal1,
			String expectedTotal2) {
		addtocartpage.verifyCartDetails(expectedPrice1, expectedPrice2, expectedTotal1, expectedTotal2);
	}

	// cart subscription check Page

	@When("User clicks on the Cart button and scrolls to footer")
	public void user_clicks_on_the_cart_button_and_scrolls_to_footer() {
		cartpagesubscription.clickOnCart();
		cartpagesubscription.scrollToFooter();
	}

	@Then("SUBSCRIPTION text should be visible")
	public void subscription_text_should_be_visible() {
		boolean result = cartpagesubscription.verifySubscriptionText();
		Assert.assertTrue(result);
	}

	@When("User enters email {string} and clicks the subscribe button")
	public void user_enters_email_and_clicks_the_subscribe_button(String email) {
		cartpagesubscription.enterEmailAndSubscribe(email);
	}

	@Then("Subscription success message should be displayed")
	public void subscription_success_message_should_be_displayed() {
		cartpagesubscription.verifySubscriptionSuccess();
	}
	// Verify Product quantity in Cart

	@When("I click on View Product for a product")
	public void i_click_on_view_product_for_a_product() {
		productquantitypage.clickOnViewProduct();
	}

	@And("I verify the product detail page is opened")
	public void i_verify_the_product_detail_page_is_opened() {
		productquantitypage.verifyProductDetailIsOpened();

	}

	@And("I increase the quantity to {int}")
	public void i_increase_the_quantity_to(Integer int1) {
		productquantitypage.setProductQuantity(int1);
	}

	@And("I click on Add to cart button")
	public void i_click_on_add_to_cart_button() {
		productquantitypage.clickAddToCart();
	}

	@And("I click on View Cart button")
	public void i_click_on_view_cart_button() {
		productquantitypage.clickViewCart();
	}

	@Then("The cart should contain product with quantity {int}")
	public void the_cart_should_contain_product_with_quantity(Integer int1) {
		productquantitypage.verifyProductQuantityInCart(int1);
	}
//review page

	@When("I click on Products button")
	public void i_click_on_products_button() {
		productreviewpage.clickOnProducts();
	}

	@Then("I should be navigated to ALL PRODUCTS page")
	public void i_should_be_navigated_to_all_products_page() {
		productreviewpage.verifyAllProductsPageIsDisplayed();
	}

	@When("I click on View Product button")
	public void i_click_on_view_product_button() {
		productreviewpage.clickOnViewProduct();
	}

	@Then("I should see Write Your Review section")
	public void i_should_see_write_your_review_section() {
		boolean result = productreviewpage.verifyReviewSectionIsDisplayed();
		Assert.assertTrue(result);
	}

	@When("I enter {string}, {string}, and {string}")
	public void i_enter_and(String string, String string2, String string3) {
		productreviewpage.enterReviewDetails(string, string2, string3);
	}

	@And("I click on Submit button")
	public void i_click_on_submit_button() {
		productreviewpage.clickSubmitReview();
	}

	@Then("I should see success message Thank you for your review.")
	public void i_should_see_success_message_thank_you_for_your_review() {
		boolean result = productreviewpage.verifySuccessMessage();
		Assert.assertTrue(result);
	}

	// view brand products stepdefinition

	@Then("I should see the Brands sidebar on the left")
	public void i_should_see_the_brands_sidebar_on_the_left() {
		viewbrandproductspage.verifyBrandsSidebarIsVisible();
	}

	@When("I click on the first brand")
	public void i_click_on_the_first_brand() {
		viewbrandproductspage.clickFirstBrand();
	}

	@Then("I should see the first brand's product page displayed")
	public void i_should_see_the_first_brand_s_product_page_displayed() {
		viewbrandproductspage.verifyFirstBrandPageIsDisplayed();
	}

	@When("I click on the second brand")
	public void i_click_on_the_second_brand() {
		viewbrandproductspage.clickSecondBrand();
	}

	@Then("I should see the second brand's product page displayed")
	public void i_should_see_the_second_brand_s_product_page_displayed() {
		viewbrandproductspage.verifySecondBrandPageIsDisplayed();
	}

	// searchproduct stepdefinition

	@When("I click  Products button")
	public void i_click_products_button() {
		cartpage.clickProducts();
	}

	@Then("I should be navigated to the All Products page")
	public void i_should_be_navigated_to_the_all_products_page() {
		cartpage.isAllProductsPageDisplayed();
	}

	@When("I search for {string}")
	public void i_search_for(String string) {
		cartpage.searchProduct(string);
	}

	@Then("I should see SEARCHED PRODUCTS")
	public void i_should_see_searched_products() {
		cartpage.isSearchResultsDisplayed();
	}

	@And("I should see all searched products")
	public void i_should_see_all_searched_products() {
		cartpage.areSearchProductsDisplayed();
	}

	@Then("I click on the view product")
	public void View_product() {
		cartpage.clickViewProduct();
	}

	@And("I click on the Add to Cart")
	public void i_click_on_the_add_to_cart() {
		cartpage.hoverAndAddToCart();
	}

	@Then("I click on continue shopping")
	public void i_click_on_continue_shopping() {
		cartpage.continueshopping();
	}

	@When("I click  Signup or Login button")
	public void i_click_signup_or_login_button() {
		cartpage.click();
	}

	@And("I enter emailid {string} and password {string}")
	public void i_enter_emailid_and_password(String string, String string2) {
		cartpage.login(string, string2);
	}

	@And("I click on Login")
	public void i_click_on_login() {
		cartpage.loginbtn();
	}

	@And("I navigate back to the Cart page")
	public void i_navigate_back_to_the_cart_page() {
		cartpage.clickCartButton();
	}

	@Then("I should see the products in the cart after login")
	public void i_should_see_the_products_in_the_cart_after_login() {
		cartpage.areProductsInCart();
	}

	@When("I remove all products from the cart")
	public void i_remove_all_products_from_the_cart() {
		cartpage.removeAllProductsFromCart();
	}

	@Then("I should see Cart is empty! Click here to buy products")
	public void i_should_see_cart_is_empty_click_here_to_buy_products() {
		boolean result = cartpage.isCartEmptyMessageDisplayed();
		Assert.assertTrue(result);
	}

	// register while checkout
	@When("I click on products in home page")
	public void click_products_homepage() {
		checkout.clickproducthome();
	}

	@And("I add product into cart")
	public void i_add_product_into_cart() {
		checkout.addProductsToCart();
	}

	@And("I go to cart page")
	public void i_go_to_cart_page() {
		checkout.clickCartButton();
	}

	@Then("I should able to see the cart page")
	public void i_should_able_to_see_the_cart_page() {
		checkout.verifyCartPageIsDisplayed();
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		checkout.clickProceedToCheckout();
	}

	@When("I click on Register or Login buttons")
	public void i_click_on_register_or_login_buttons() {
		checkout.clickRegisterLogin();
	}

	@When("I fill in the signup details with {string}, {string}, {string}, {string}, {string},{string}, {string}, {string}, {string}, {string}, {string}")
	public void i_fill_in_the_signup_details_with(String string, String string2, String string3, String string4,
			String string5, String string6, String string7, String string8, String string9, String string10,
			String string11) {
		checkout.fillSignupDetails(string, string2, string3, string4, string5, string6, string7, string8, string9,
				string10, string11);
	}

	@Then("I should see account created message and click continue")
	public void i_should_see_account_created_message_and_click_continue() {
		checkout.verifyAccountCreatedAndContinue();
	}

	@Then("I should be logged in as user")
	public void i_should_be_logged_in_as_user() {
		checkout.verifyLoggedInAsDisplayed();
	}

	@When("I go to cart page again")
	public void i_go_to_cart_page_again() {
		checkout.clickCartButtonAfterLogin();
	}

	@And("I proceed to checkout after login")
	public void i_proceed_to_checkout_after_login() {
		checkout.clickProceedToCheckoutAfterLogin();
	}

	@Then("I should see address details and review order section")
	public void i_should_see_address_details_and_review_order_section() {
		checkout.verifyAddressDetailsAndReviewOrder();
	}

	@When("I enter {string} in comment text area and place the order")
	public void i_enter_in_comment_text_area_and_place_the_order(String string) {
		checkout.enterCommentAndPlaceOrder(string);
	}

	@And("I enter payment details with {string}, {string}, {string}, {string}, {string}")
	public void i_enter_payment_details_with(String string, String string2, String string3, String string4,
			String string5) {
		checkout.enterPaymentDetails(string, string2, string3, string4, string5);
	}

	@And("I confirm the order")
	public void i_confirm_the_order() {
		checkout.clickPayAndConfirmOrder();
	}

	@Then("I should see order confirmation message")
	public void i_should_see_order_confirmation_message() {
		checkout.verifySuccessMessage();
	}

	@When("I delete my account")
	public void i_delete_my_account() {
		checkout.clickDeleteAccount();
	}

	@Then("I should see account deleted message and click continue")
	public void i_should_see_account_deleted_message_and_click_continue() {
		checkout.verifyAccountDeletedAndContinue();
	}

	// login before checkout

	@And("I click on Signup or Login button")
	public void i_click_on_signup_or_login_button() {
		checkoutpage.clickSignupLogin();
	}

	@When("I enter email {string} and password {string}")
	public void i_enter_email_and_password(String string, String string2) {
		checkoutpage.login(string, string2);
	}

	@And("I click on Login button")
	public void i_click_on_login_button() {
	}

	@Then("I should see Logged in as username at the top")
	public void i_should_see_logged_in_as_username_at_the_top() {
		checkoutpage.isUserLoggedIn();
	}

	@And("I click on products")
	public void I_click_productss() {
		checkoutpage.clickproducts();
	}

	@When("I click on view product")
	public void I_click_product() {
		checkoutpage.clickonproduct();
	}

	@And("I click on the Add to cart button")
	public void I_click_card_button() {
		checkoutpage.clickCartButton();
	}

	@Then("I click on view cart")
	public void I_click_view_cart() {
		checkoutpage.clickviewcart();
	}

	@Then("I should see the cart page is displayed")
	public void i_should_see_the_cart_page_is_displayed() {
		boolean result = checkoutpage.verifycartisdisplayed();
		Assert.assertTrue(result);
	}

	@When("I click on Proceed to Checkout")
	public void i_click_on_proceed_to_checkout() {
		checkoutpage.clickProceedToCheckout();
	}

	@Then("I should see Address Details and Review Order sections")
	public void i_should_see_address_details_and_review_order_sections() {
		checkoutpage.isCheckoutPageDisplayed();

	}

	@When("I enter {string} in the comment text area")
	public void i_enter_in_the_comment_text_area(String string) {
		checkoutpage.enterComment(string);
	}

	@And("I click on Place Order button")
	public void i_click_on_place_order_button() {
		checkoutpage.clickPlaceOrder();
	}

	@When("I enter payment details {string}, {string}, {string}, {string}, {string}")
	public void i_enter_payment_details(String string, String string2, String string3, String string4, String string5) {
		checkoutpage.enterPaymentDetails(string, string2, string3, string4, string5);
	}

	@And("I click on Pay and Confirm Order button")
	public void i_click_on_pay_and_confirm_order_button() {
		checkoutpage.clickPayAndConfirm();
	}

	@Then("I should see Congratulations! Your order has been confirmed!")
	public void i_should_see_congratulations_your_order_has_been_confirmed() {
		checkoutpage.isOrderConfirmed();
	}

	@And("Download the Invoice")
	public void download_invoice() {
		checkoutpage.downloadInvoice();
	}
}
