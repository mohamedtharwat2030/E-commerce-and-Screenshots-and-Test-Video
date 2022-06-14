@smoke
Feature: F08_WishList | user could add products to wishlist
  Scenario: After user add products to wishlist success message is visible
    When user add products to wishlist
    Then wishlist success message is visible
    And user get number of products added to wishlist
    Then number of wishlist products increased
    And user go to wishlist page