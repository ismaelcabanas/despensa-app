Feature: Add new products into storeroom
  In order to know what products I have in my storeroom
  As an user
  I want to add new products into storeroom

  Scenario: add new products into storeroom
    Given the storeroom
    When I add 2 items of new Apple product into storeroom
    Then the storeroom has a new Apple product with 2 items