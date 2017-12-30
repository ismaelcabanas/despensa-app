Feature: Add storage of products in storeroom
  In order to add more storage of existent products into storeroom
  As an user
  I want to add more quantity of a existent product

  Scenario: add more items of existent product into storeroom
    Given the storeroom has
      | name | quantity |
      | Milk | 2        |
      | Eggs | 6        |
    When I add 2 items more of Milk product into storeroom
    Then the storeroom has 4 items of Milk