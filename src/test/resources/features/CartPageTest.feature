Feature: To Verify Cart Page Functionalities

	@Regression @Priya
  Scenario: Verify user can remove item from cart
    Given user open website
    Then verify user is on login page
    When user login with username "admin" and password "admin123"
    Then verify user is on homepage
    When user click on add to cart button of first item
    Then verify cart icon display qantity of item
    When user click on cart icon
    Then verify user is on cart page
    When user click on remove button
    Then verify cart page is empty
