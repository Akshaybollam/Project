Feature: User Registration and Login

  Background: 
    Given User is on the homepage

  @Register
  Scenario Outline: Register a new user
    When User clicks on Signup or Login button
    And User enters a new "<name>" and "<email>" address
    And User clicks on Signup button
    Then User should see ENTER ACCOUNT INFORMATION form
    And User enters account details
    And User enters personal details and address information
    And User clicks on Create Account button
    Then User should see "Account Created!" message

    Examples: 
      | name  | email              |
      | John  | john4006@gmail.com |
      | Emily | emily78@gmail.com  |

  @Login
  Scenario Outline: Login with valid credentials
    When User clicks on Signup or Login button
    Then User should see "Login to your account"
    And User enters valid "<email>" and "<password>"
    Then User clicks on Login button

    Examples: 
      | email               | password    |
      | testuser23@test.com | Akshay2001@ |

  @LoginInvalid
  Scenario Outline: Login User with incorrect credentials
    When User clicks on Signup or Login button
    And User enters invalid "<email>" and "<password>"
    And User clicks on Login button
    Then User should see "Invalid login credentials" error message

    Examples: 
      | email              | password |
      | wronguser@test.com | Wrong123 |

  @Logout
  Scenario Outline: Verify user is able to log in and log out successfully
    When User clicks on Signup or Login button
    Then I should see Login to your account
    When I enter valid email "<email>" and password "<password>"
    And I click on the Login button
    Then I should see Logged in as "<username>"
    When I click on the Logout button
    Then I should be navigated back to the login page

    Examples: 
      | email               | password    | username |
      | testuser23@test.com | Akshay2001@ | Testuser |

  @LoginExisting
  Scenario Outline: Verify user cannot register with an already registered email
    When User clicks on Signup or Login button
    Then User should see New User Signup! text
    When User enters name "<name>" and already registered email "<email>"
    And User clicks on the Signup button
    Then User should see an error message "Email Address already exist!"

    Examples: 
      | name   | email                     |
      | Akshay | bollamakshay756@gmail.com |

  @ContactUs
  Scenario: User submits the contact form successfully
    When I navigate to the Contact Us page
    Then I should see the GET IN TOUCH heading
    When I fill in the contact form with details
    And I upload a file
    And I click the Submit button and accept the alert
    Then I should see the success message Success! Your details have been submitted successfully.
    When I click the Home button
    Then I should be redirected to the home page

  @TestCases
  Scenario: User navigates to the Test Cases page successfully
    When I click on the Test Cases button
    Then I should be redirected to the Test Cases page

  @VerifySubscription
  Scenario Outline: User successfully subscribes using different emails
    When I scroll down to the Subscription section
    And I enter my email "<email>" and click subscribe
    Then I should see the success message You have been successfully subscribed!

    Examples: 
      | email          |
      | user1@test.com |

  #| user2@test.com       |
  #| testuser@example.com |
  @Recommended
  Scenario: User adds a recommended item to the cart and verifies it
    When User scrolls to the bottom of the page
    Then User should see the RECOMMENDED ITEMS section
    When User clicks Add To Cart on a recommended product
    And User clicks View Cart button
    Then The product should be displayed in the cart

  @scrolluparrow
  Scenario Outline: User verifies scroll up and scroll down on home page
    Then I should see the home page
    When I scroll down to the bottom of the page
    Then I should see Subscription text
    When I click on the button arrow button
    Then I should see expectedText on screen

  @ScrollowWithoutArrow
  Scenario Outline: User verifies scroll up and scroll down without using arrow button
    Then I  see the home page
    When I scroll  to the bottom of the page
    Then I should see section Subscription
    When I scroll u to the top of the page
    Then I should see expectedText

  @RemoveFromCart
  Scenario: Verify product removal from cart
    And I click on View Product
    When I add a product to the cart
    And click continue shopping
    And I navigate to the cart page
    Then I should see the cart page displayed
    When I remove a product from the cart
    Then I should see the product is removed

  @VerifyCategory
  Scenario: Verify category navigation for Women and Men products
    Then I should see categories on the left sidebar
    When I click on the Women category
    And I click on the Dress sub-category under Women
    Then I should see the WOMEN - DRESS PRODUCTS page
    When I click on the Men category
    And I click on the Jeans sub-category under Men
    Then I should see the MEN - JEANS PRODUCTS page

  @registerbeforecheckout
  Scenario: Register and complete checkout process
    When User clicks on Signup or Login button
    When I enter signup details with name "John Doenc" and email "johndoe4098@example.com"
    And I enter account details with password "password123", day "10", month "January", year "1990"
    And I enter address details "John", "Doe", "Company", "123 Street", "Apt 4B", "United States", "California", "Los Angeles", "90001", "1234567890"
    Then I should see account created message
    When I click Continue
    Then I should be logged in as a user
    When I add products to cart and go to cart page
    And I proceed with checkout
    Then I should see address and order review details
    When I enter comment "Please deliver soon" and place the order
    And I enter the payment details "John Doe", "4111111111111111", "123", "12", "2025"
    And I confirm  order
    Then I should see success message
    When I delete the account
    Then I should see account deleted message
