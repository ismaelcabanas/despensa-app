Feature: Add new products into storeroom
  In order to fill the storeroom
  As an user
  I want to add new products into storeroom

  Scenario: add new products into storeroom
    Given the storeroom has
      | name | quantity |
      | Milk | 2        |
      | Eggs | 6        |
    When I add 2 items of new Apple product into storeroom
    Then the storeroom has a new Apple product with 2 items