Feature: Product Search Functionality

  Background: 
    Given User is on the home page

  @Products
  Scenario: Verify search functionality on products page
    When User clicks on the Products button
    Then User should be navigated to the ALL PRODUCTS page
    When User enters product name "T-Shirt" in search input and clicks search button
    Then User should see the SEARCHED PRODUCTS section
    And User should see all related products displayed

  @ProductVerify
  Scenario: Verify user can view product details
    When User clicks on the Products button
    Then User should be navigated to the ALL PRODUCTS page
    And The products list should be visible
    When User clicks on View Product of the first product
    Then User should be navigated to the product detail page
    And User should see the product details: name, category, price, availability, condition, brand

  @CartPage
  Scenario Outline: Verify user can add multiple products to cart and verify details
    When I click on the Products button
    And I hover over the first product and add it to the cart
    And I click Continue Shopping
    And I hover over the second product and add it to the cart
    And I click View Cart button
    Then Both products should be in the Cart with "<First Product>" and "<Second Product>"
    And Product details should be "<Price1>", "<Price2>", "<Total1>", "<Total2>"

    Examples: 
      | First Product | Second Product | Price1  | Price2  | Total1  | Total2  |
      | Blue Top      | Men Tshirt     | Rs. 500 | Rs. 400 | Rs. 500 | Rs. 400 |

  @CartSubscription
  Scenario Outline: User subscribes from Cart page
    When User clicks on the Cart button and scrolls to footer
    Then SUBSCRIPTION text should be visible
    When User enters email "<email>" and clicks the subscribe button
    Then Subscription success message should be displayed

    Examples: 
      | email              |
      | testuser1@mail.com |

  @VerifyProductQuantity
  Scenario Outline: Verify product quantity is correctly updated in the cart
    When I click on View Product for a product
    And I verify the product detail page is opened
    And I increase the quantity to <quantity>
    And I click on Add to cart button
    And I click on View Cart button
    Then The cart should contain product with quantity <quantity>

    Examples: 
      | quantity |
      |        4 |

  @Reviewproduct
  Scenario Outline: User adds a review on a product
    When I click on Products button
    Then I should be navigated to ALL PRODUCTS page
    When I click on View Product button
    Then I should see Write Your Review section
    When I enter "<name>", "<email>", and "<review>"
    And I click on Submit button
    Then I should see success message Thank you for your review.

    Examples: 
      | name        | email              | review                   |
      | John Doe    | john@example.com   | Great quality product!   |
      | Alice Smith | alice@gmail.com    | Fast shipping, loved it! |
      | Mike Ross   | mike.ross@test.com | Highly recommended!      |

  @VerifyBrand
  Scenario: Verify brand navigation and products visibility
    When I click on the Products button
    Then I should see the Brands sidebar on the left
    When I click on the first brand
    Then I should see the first brand's product page displayed
    When I click on the second brand
    Then I should see the second brand's product page displayed

  @searchProduct
  Scenario Outline: Verify searched products remain in the cart after login
    When I click  Products button
    Then I should be navigated to the All Products page
    When I search for "<productName>"
    Then I should see SEARCHED PRODUCTS
    And I should see all searched products
    Then I click on the view product
    And I click on the Add to Cart
    Then I click on continue shopping
    When I click  Signup or Login button
    And I enter emailid "<email>" and password "<password>"
    And I click on Login
    And I navigate back to the Cart page
    Then I should see the products in the cart after login
    When I remove all products from the cart
    Then I should see Cart is empty! Click here to buy products

    Examples: 
      | productName | email                     | password    |
      | Men Tshirt  | bollamakshay756@gmail.com | Akshay2001@ |

  @Registerwhilecheckout
  Scenario Outline: User places order and registers during checkout
  	When I click on products in home page
    And I add product into cart
    And I go to cart page
    Then I should able to see the cart page
    When I proceed to checkout
    When I click on Register or Login buttons
    When I fill in the signup details with "<name>", "<email>", "<password>", "<firstName>", "<lastName>","<company>", "<address>", "<state>", "<city>", "<zipcode>", "<mobile>"
    Then I should see account created message and click continue
    Then I should be logged in as user
    When I go to cart page again
    And I proceed to checkout after login
    Then I should see address details and review order section
    When I enter "<comment>" in comment text area and place the order
    And I enter payment details with "<nameOnCard>", "<cardNumber>", "<cvc>", "<expiryMonth>", "<expiryYear>"
    And I confirm the order
    Then I should see order confirmation message
    When I delete my account
    Then I should see account deleted message and click continue

    Examples: 
      | name     | email                 | password    | firstName | lastName | company  | address     | state      | city        | zipcode | mobile     | comment                | nameOnCard | cardNumber       | cvc | expiryMonth | expiryYear |
      | John Doe | john14582@example.com | Password123 | John      | Doe      | TechCorp | 123 Main St | California | Los Angeles |   90001 | 9876543210 | Please deliver quickly | John Doe   | 4111111111111111 | 123 |          12 |       2026 |

  @placeorderafterlogin
  Scenario Outline: User places an order after logging in
    And I click on Signup or Login button
    When I enter email "<email>" and password "<password>"
    And I click on Login button
    Then I should see Logged in as username at the top
    And I click on products
    When I click on view product
    And I click on the Add to cart button
    Then I click on view cart
    Then I should see the cart page is displayed
    When I click on Proceed to Checkout
    Then I should see Address Details and Review Order sections
    When I enter "<comment>" in the comment text area
    And I click on Place Order button
    When I enter payment details "<name>", "<card>", "<cvc>", "<month>", "<year>"
    And I click on Pay and Confirm Order button
    Then I should see Congratulations! Your order has been confirmed!
    And Download the Invoice

    Examples: 
      | email                     | password    | comment                | name     | card             | cvc | month | year |
      | bollamakshay756@gmail.com | Akshay2001@ | Please deliver by 5 PM | John Doe | 4111111111111111 | 123 |    12 | 2025 |
      
    
