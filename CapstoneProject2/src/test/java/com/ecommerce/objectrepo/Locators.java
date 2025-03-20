package com.ecommerce.objectrepo;

import org.openqa.selenium.By;

public class Locators {
	// locators for registration
	public static By signupLoginLink = By.xpath("//a[contains(text(),' Signup / Login')]");
	public static By newUserSignupText = By.xpath("//h2[contains(text(),'New User Signup!')]");
	public static By nameField = By.name("name");
	public static By emailField = By.xpath("//input[@data-qa='signup-email']");
	public static By signupButton = By.xpath("//button[contains(text(),'Signup')]");
	public static By enterAccountInfo = By.xpath("//b[contains(text(),'Enter Account Information')]");
	public static By titleMr = By.id("id_gender1");
	public static By passwordField = By.id("password");
	public static By dayDropdown = By.id("days");
	public static By monthDropdown = By.id("months");
	public static By yearDropdown = By.id("years");
	public static By newsletterCheckbox = By.id("newsletter");
	public static By optinCheckbox = By.id("optin");
	public static By firstName = By.id("first_name");
	public static By lastName = By.id("last_name");
	public static By company = By.id("company");
	public static By address1 = By.id("address1");
	public static By address2 = By.id("address2");
	public static By countryDropdown = By.id("country");
	public static By state = By.id("state");
	public static By city = By.id("city");
	public static By zipcode = By.id("zipcode");
	public static By mobileNumber = By.id("mobile_number");
	public static By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");
	public static By accountCreatedText = By.xpath("//b[contains(text(),'Account Created!')]");
	public static By continueButton = By.xpath("//a[contains(text(),'Continue')]");
	public static By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]//b");
	public static By deleteAccountButton = By.xpath("//a[contains(text(),' Delete Account')]");
	public static By accountDeletedText = By.xpath("//b[contains(text(),'Account Deleted!')]");

	// locators for login with valid credentials
	public static By signupLogin = By.xpath("//a[contains(text(),' Signup / Login')]");
	public static By loginHeader = By.xpath("//h2[contains(text(),'Login to your account')]");
	public static By email = By.xpath("//input[@data-qa='login-email']");
	public static By password = By.xpath("//input[@data-qa='login-password']");
	public static By loginButton = By.xpath("//button[contains(text(),'Login')]");

	// locators for login Invalid credentials
	public static By signuporLogin = By.xpath("//a[contains(text(),' Signup / Login')]");
	public static By login = By.xpath("//h2[contains(text(),'Login to your account')]");
	public static By emailfield = By.xpath("//input[@data-qa='login-email']");
	public static By passwordfield = By.xpath("//input[@data-qa='login-password']");
	public static By loginbutton = By.xpath("//button[contains(text(),'Login')]");
	public static By errorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

	// locators for logout page
	public static By signuporlogin = By.xpath("//a[contains(text(),' Signup / Login')]");
	public static By log = By.xpath("//h2[contains(text(),'Login to your account')]");
	public static By emailid = By.xpath("//input[@data-qa='login-email']");
	public static By pass = By.xpath("//input[@data-qa='login-password']");
	public static By loginbtn = By.xpath("//button[contains(text(),'Login')]");
	public static By loggedInas = By.xpath("//a[contains(text(),'Logged in as')]//b");
	public static By logoutButton = By.xpath("//a[contains(text(),'Logout')]");
	public static By loginAgainHeader = By.xpath("//h2[contains(text(),'Login to your account')]");

	// locaters for register with existing email
	public static By signupLoginButton = By.xpath("//a[contains(text(),' Signup / Login')]");
	public static By newusersignuptext = By.xpath("//h2[contains(text(),'New User Signup!')]");
	public static By namefield = By.name("name");
	public static By mail = By.xpath("//input[@data-qa='signup-email']");
	public static By signupbutton = By.xpath("//button[contains(text(),'Signup')]");
	public static By emailError = By.xpath("//p[contains(text(),'Email Address already exist!')]");

	// locaters for contactus page
	public static By contactus = By.xpath("//a[normalize-space()='Contact us']");
	public static By getInTouchText = By.xpath("//h2[contains(text(),'Get In Touch')]");
	public static By name = By.name("name");
	public static By mailid = By.name("email");
	public static By subjectField = By.name("subject");
	public static By messageField = By.name("message");
	public static By fileUpload = By.name("upload_file");
	public static By submitButton = By.name("submit");
	public static By successMessage = By
			.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");
	public static By homeButton = By.xpath("//a[contains(text(),'Home')]");

	// locaters for testcases page
	public static By testCasesButton = By.linkText("Test Cases");
	public static By homePageTitle = By.xpath("//title[contains(text(),'Automation Exercise')]");

	// Locators for add to cart Page
	public static By homePageIdentifier = By.xpath("//div[@class='item active']//span[1]");
	public static By productsButton = By.xpath("//a[@href='/products']");
	public static By firstProduct = By.cssSelector("a[href='/product_details/1']");
	public static By firstProductAddToCart = By.cssSelector("button[type='button']");
	public static By continueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	public static By secondProduct = By.cssSelector("a[href='/product_details/2']");
	public static By secondProductAddToCart = By.xpath("//button[@type='button']");
	public static By viewCartButton = By.xpath("//i[@class='fa fa-shopping-cart']");
	public static By cartItems1 = By.xpath("//a[normalize-space()='Blue Top']");
	public static By cartItems2 = By.xpath("//a[normalize-space()='Men Tshirt']");
	public static By productPrices = By.xpath("//td[@class='cart_price']//p");
	public static By productQuantities = By.xpath("//td[@class='cart_quantity']//button");
	public static By productTotalPrices = By.xpath("//td[@class='cart_total']//p");

	// Locators for cart subscription page
	public static By homePage = By.xpath("//span[text()='Automation']");
	public static By cartButton = By.xpath("//a[@href='/view_cart']");
	public static By subscriptionText = By.xpath("//h2[text()='Subscription']");
	public static By emailInput = By.xpath("//input[@id='susbscribe_email']");
	public static By subscribeButton = By.xpath("//button[@id='subscribe']");
	public static By successmsg = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");

	// Locators for product quantity page
	public static By home = By.xpath("//span[text()='Automation']");
	public static By viewProductButton = By.xpath("(//a[text()='View Product'])[1]"); // First product
	public static By productDetail = By.xpath("//h2[contains(text(),'Blue Top')]");
	public static By quantityField = By.xpath("//input[@id='quantity']");
	public static By addToCartButton = By.xpath("//button[@type='button']");
	public static By viewCartbtn = By.linkText("View Cart");
	public static By cartQuantity = By.xpath("//button[contains(text(),'4')]");

	// Locators for product review
	public static By productsBtn = By.xpath("//a[@href='/products']");
	public static By allProductsHeader = By.xpath("//h2[text()='All Products']");
	public static By viewProductBtn = By.xpath("(//a[text()='View Product'])[1]"); // First product
	public static By reviewSection = By.xpath("//a[normalize-space()='Write Your Review']");
	public static By nam = By.xpath("//input[@id='name']");
	public static By em = By.xpath("//input[@id='email']");
	public static By reviewField = By.xpath("//textarea[@id='review']");
	public static By submitBtn = By.xpath("//button[@id='button-review']");
	public static By success = By.xpath("//span[contains(text(),'Thank you for your review.')]");

	// Locators for products page
	public static By homeIdentifier = By.xpath("//span[text()='Automation']");
	public static By productButton = By.xpath("//a[@href='/products']");
	public static By ProductsHeader = By.xpath("//h2[text()='All Products']");
	public static By searchInput = By.id("search_product");
	public static By searchButton = By.id("submit_search");
	public static By searchedProductsHeader = By.xpath("//h2[text()='Searched Products']");
	public static By productResults = By.xpath("//div[@class='productinfo text-center']");

	// Locators to Recommended page
	public static By recommendedItemsSection = By.xpath("//h2[normalize-space()='recommended items']");
	public static By recommended = By.xpath("//div[@class='item active']//p[contains(text(),'Summer White Top')]");
	public static By CartButton = By.xpath("//div[@class='item active']//div[3]//div[1]//div[1]//div[1]//a[1]");
	public static By viewButton = By.linkText("View Cart");
	public static By cartItems = By.xpath("//a[normalize-space()='Summer White Top']");

	// Locators for remove products from cart page
	public static By PageIdentifier = By.xpath("//div[@class='item active']//span[1]");
	public static By viewProductButn = By.cssSelector("a[href='/product_details/1']");
	public static By addToCartButn = By.cssSelector(".btn.btn-default.cart");
	public static By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
	public static By cartBtn = By.linkText("Cart");
	public static By cartPageHeader = By.xpath("//li[@class='active']");
	public static By removeProductButtons = By.xpath("//a[@class='cart_quantity_delete']");
	public static By cartEmptyMessage = By.xpath("//b[normalize-space()='Cart is empty!']");

//  Locators fro scroll page using arrow
	public static By Identifier = By.xpath("//span[text()='Automation']");
	public static By subscriptionSection = By.xpath("//h2[normalize-space()='Subscription']");
	public static By scrollUpArrow = By.xpath("//i[@class='fa fa-angle-up']");
	public static By topText = By
			.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]");

	// locators for scrollow without using arrow
	public static By homePageverify = By.xpath("//div[@class='item active']//span[1]");
	public static By subscription = By.xpath("//h2[normalize-space()='Subscription']");
	public static By toptext = By
			.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]");

	// Locators// Product Detail Page Locators //Verify Product Page
	public static By homePagevalidate = By.xpath("//span[text()='Automation']");
	public static By productsButn = By.xpath("//a[@href='/products']");
	public static By allProducts = By.xpath("//h2[text()='All Products']");
	public static By productList = By.xpath("//div[@class='productinfo text-center']");
	public static By firstProductViewButton = By.xpath("(//a[text()='View Product'])[1]");
	public static By productName = By.xpath("//h2[contains(text(),'Blue Top')]");
	public static By productCategory = By.xpath("//p[contains(text(),'Category')]");
	public static By productPrice = By.xpath("//span[contains(text(),'Rs. 500')]");
	public static By productAvailability = By.xpath("//b[contains(text(),'Availability:')]");
	public static By productCondition = By.xpath("//b[contains(text(),'Condition:')]");
	public static By productBrand = By.xpath("//b[contains(text(),'Brand:')]");

	// Locators for verify subscription in home page
	public static By homeverify = By.xpath("//span[text()='Automation']"); // Element to verify Home Page
	public static By subscriptiontext = By.xpath("//h2[text()='Subscription']");
	public static By ema = By.id("susbscribe_email");
	public static By subscribeBtn = By.id("subscribe");
	public static By successMsg = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");

	// Locators for verify category
	public static By categorySidebar = By.xpath("//div[@class='left-sidebar']/h2[contains(text(),'Category')]");
	public static By womenCategory = By.xpath("//a[normalize-space()='Women']");
	public static By dressCategory = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
	public static By categoryHeader = By.xpath("//h2[@class='title text-center']");
	public static By menCategory = By.xpath("//a[normalize-space()='Men']");
	public static By menSubCategory = By.xpath("//a[normalize-space()='Jeans']");
	public static By menCategoryHeader = By.xpath("//h2[@class='title text-center']");

	// Locators for viewBrandProducts page
	public static By productbuton = By.xpath("//a[@href='/products']");
	public static By brandsSidebar = By.xpath("//div[@class='brands_products']//h2");
	public static By firstBrand = By.xpath("//a[@href='/brand_products/Polo']");
	public static By brandHeader = By.xpath("//h2[@class='title text-center']");// same for both products
	public static By secondBrand = By.xpath("//a[@href='/brand_products/H&M']");
	public static By productGrid = By.xpath("//div[@class='features_items']");

	// Locators for register while checkout
	public static By pageIdentifier = By.xpath("//div[@class='item active']//span[1]");
	public static By clickproduct = By.xpath("//a[@href='/products']");
	public static By productItem = By
			.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
	public static By addToCartButtons = By.xpath("//button[@type='button']");
	public static By cartbn = By.xpath("//u[normalize-space()='View Cart']");
	public static By cartHeader = By.xpath("//li[@class='active']");
	public static By proceedToCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	public static By registerLoginButton = By.xpath("//p[2]");
	public static By registername = By.name("name");
	public static By registeremail = By.xpath("//input[@data-qa='signup-email']");
	public static By signupbn = By.xpath("//button[contains(text(),'Signup')]");
	public static By registerpassword = By.xpath("//input[@name='password']");
	public static By day = By.id("days");
	public static By month = By.id("months");
	public static By year = By.id("years");
	public static By firstNameField = By.xpath("//input[@name='first_name']");
	public static By lastNameField = By.xpath("//input[@name='last_name']");
	public static By addressField = By.id("address1");
	public static By countryField = By.id("country");
	public static By stateField = By.xpath("//input[@name='state']");
	public static By cityField = By.xpath("//input[@name='city']");
	public static By zipcodeField = By.xpath("//input[@name='zipcode']");
	public static By mobileNumberField = By.xpath("//input[@name='mobile_number']");
	public static By createAccountBtn = By.xpath("//button[contains(text(),'Create Account')]");
	public static By accountCreatedMessage = By.xpath("//b[normalize-space()='Account Created!']");
	public static By continueBtn = By.xpath("//a[contains(text(),'Continue')]");
	public static By loggedas = By.xpath("//li[10]//a[1]");
	public static By cartButtonAfterLogin = By
			.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]");
	public static By proceedToCheckoutAfterLogin = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	public static By addressDetails = By.xpath("//h2[contains(text(),'Address Details')]");
	public static By reviewOrder = By.xpath("//h2[contains(text(),'Review Your Order')]");
	public static By commentTextArea = By.xpath("//textarea[@name='message']");
	public static By placeOrderButton = By.xpath("//a[@class='btn btn-default check_out']");
	public static By nameOnCard = By.xpath("//input[@name='name_on_card']");
	public static By cardNumber = By.xpath("//input[@name='card_number']");
	public static By cvv = By.xpath("//input[@name='cvc']");
	public static By expiryMonth = By.xpath("//input[@name='expiry_month']");
	public static By expiryYear = By.xpath("//input[@name='expiry_year']");
	public static By payAndConfirmButton = By.xpath("//button[contains(text(),'Pay and Confirm Order')]");
	public static By successmessage = By
			.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
	public static By deleteAccountBtn = By.xpath("//a[contains(text(),'Delete Account')]");
	public static By accountDeletedMessage = By.xpath("//b[normalize-space()='Account Deleted!']");

	// Locators for login before checkout
	public static By signuploginButton = By.xpath("//a[text()=' Signup / Login']");
	public static By emailinput = By.xpath("//input[@data-qa='login-email']");
	public static By passwordInput = By.xpath("//input[@data-qa='login-password']");
	public static By loginbton = By.xpath("//button[@data-qa='login-button']");
	public static By loggedinas = By.xpath("//a[contains(text(),'Logged in as')]//b");
	public static By clickproducts = By.xpath("//a[@href='/products']");
	public static By viewproduct = By
			.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
	public static By Addtocart = By.xpath("//button[@type='button']");
	public static By viewcarttext = By.xpath("//u[normalize-space()='View Cart']");
	public static By cartverify = By.xpath("//li[@class='active']");
	public static By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	public static By addressdetails = By.xpath("//h2[text()='Address Details']");
	public static By revieworder = By.xpath("//h2[text()='Review Your Order']");
	public static By commenttextArea = By.xpath("//textarea[@name='message']");
	public static By placeorderButton = By.xpath("//a[text()='Place Order']");
	public static By nameOncard = By.xpath("//input[@name='name_on_card']");
	public static By cardnumber = By.xpath("//input[@name='card_number']");
	public static By cvvnumber = By.xpath("//input[@name='cvc']");
	public static By expirymonth = By.xpath("//input[@name='expiry_month']");
	public static By expiryyear = By.xpath("//input[@name='expiry_year']");
	public static By payAndConfirmbutton = By.xpath("//button[@id='submit']");
	public static By successmssage = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
	public static By invoicedownload = By.xpath("//a[@class='btn btn-default check_out']");

	// Locators for search product page
	public static By productsbutton = By.xpath("//a[@href='/products']");
	public static By allProductsheader = By.xpath("//h2[text()='All Products']");
	public static By searchinput = By.xpath("//input[@id='search_product']");
	public static By searchbutton = By.xpath("//button[@id='submit_search']");
	public static By searchedproductsHeader = By.xpath("//h2[text()='Searched Products']");
	public static By searchedProduct = By.xpath("//div[@class='productinfo text-center']");

	public static By viewproductButton = By.xpath("//a[normalize-space()='View Product']");
	public static By addtoCartButton = By.xpath("//button[@type='button']");
	public static By clickshopping = By.xpath("//button[@class='btn btn-success close-modal btn-block']");

	public static By cartbutton = By
			.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]");
	public static By cartitems = By.xpath("//table[@id='cart_info_table']//tr");

	public static By signupoginButton = By.xpath("//a[text()=' Signup / Login']");
	public static By emailnput = By.xpath("//input[@data-qa='login-email']");
	public static By passwordinput = By.xpath("//input[@data-qa='login-password']");
	public static By loginbtton = By.xpath("//button[@data-qa='login-button']");

	public static By removeproductButtons = By.xpath("//a[@class='cart_quantity_delete']");
	public static By emptyCartMessage = By.xpath("//b[normalize-space()='Cart is empty!']");

	// Locators for register before checkout
	public static By signin = By.xpath("//a[contains(text(),'Signup / Login')]");
	public static By entername = By.name("name");
	public static By entermail = By.xpath("//input[@data-qa='signup-email']");
	public static By signupBtn = By.xpath("//button[contains(text(),'Signup')]");
	public static By enterAccountinfo = By.xpath("//b[contains(text(),'Enter Account Information')]");
	public static By titlemr = By.id("id_gender1");
	public static By enterpassword = By.id("password");
	public static By enterday = By.id("days");
	public static By entermonth = By.id("months");
	public static By enteryear = By.id("years");
	public static By newslettercheckbox = By.id("newsletter");
	public static By optincheckbox = By.id("optin");
	public static By firstname = By.id("first_name");
	public static By lastname = By.id("last_name");
	public static By companydetails = By.id("company");
	public static By addressone = By.id("address1");
	public static By addresstwo = By.id("address2");
	public static By entercountry = By.id("country");
	public static By enterstate = By.id("state");
	public static By entercity = By.id("city");
	public static By enterzipcode = By.id("zipcode");
	public static By entermobileNumber = By.id("mobile_number");
	public static By createaccountButton = By.xpath("//button[contains(text(),'Create Account')]");
	public static By accountCreatedMsg = By.xpath("//b[normalize-space()='Account Created!']");
	public static By continuebutton = By.xpath("//a[contains(text(),'Continue')]");
	public static By loggedInUser = By.cssSelector("li:nth-child(10) a:nth-child(1)");
	public static By products = By.xpath("//a[contains(text(),'Products')]");
	public static By firstproduct = By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
	public static By addTocartButton = By.xpath("//button[@type='button']");
	public static By cartutton = By.xpath("//u[normalize-space()='View Cart']");
	public static By proceedTocheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	public static By addresdetails = By.xpath("//h2[normalize-space()='Address Details']");
	public static By revieworders = By.xpath("//h2[normalize-space()='Review Your Order']");
	public static By commentArea = By.name("message");
	public static By placeorderbutton = By.xpath("//a[@class='btn btn-default check_out']");
	public static By nameonCard = By.name("name_on_card");
	public static By cardnumbers = By.name("card_number");
	public static By cvc = By.name("cvc");
	public static By expirationMonth = By.name("expiry_month");
	public static By expirationYear = By.name("expiry_year");
	public static By payAndconfirmButton = By.xpath("//button[contains(text(),'Pay and Confirm Order')]");
	public static By successmssg = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
	public static By deleteaccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
	public static By accountdeletedMessage = By.xpath("//b[normalize-space()='Account Deleted!']");
}
