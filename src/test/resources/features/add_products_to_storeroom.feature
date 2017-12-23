Feature: Add products into storeroom
  In order to keep products we consume normally
  As an user
  I want to add products into storeroom

  Scenario: add new products into storeroom
    Given the storeroom is empty
    When I add 1 Milk product into storeroom
    Then the storeroom has 1 products
    And the storeroom has 1 items of Milk

  Scenario: add existent products into storeroom
    Given the storeroom has
      | name | quantity |
      | Milk | 2        |
      | Eggs | 6        |
    When I add 1 Milk product into storeroom
    Then the storeroom has 2 products
    And the storeroom has 3 items of Milk