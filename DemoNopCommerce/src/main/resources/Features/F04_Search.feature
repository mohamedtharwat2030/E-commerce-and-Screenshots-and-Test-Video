@smoke
Feature: F04_Search | users will be able to search for products with different parameters
 Scenario Outline: user could search using product name
    When user click on search field in Home page
    And user enter product name in search field "<productName>"
    Then user click on search button
    And user could turned to search page
    And user see products of search result

   Examples:
     |productName|
     |book       |
     |laptop     |
     |nike       |


  Scenario Outline: : user could search using sku
    When user click on search field in Home page
    And user enter product sku  in search field "<productSku>"
    Then user click on search button
    And user could turned to search page
    And user enter to the product detail

    Examples:
      |productSku|
      |SCI_FAITH |
      |APPLE_CAM |
      |SF_PRO_11 |