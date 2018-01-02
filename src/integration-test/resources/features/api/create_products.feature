Feature: API for creating products
  In order to add new products into storeroom
  As an user
  I want an API

  Scenario: Post products
    Given the data of product
      | name | quantity |
      | Milk | 2        |
    When I POST to /products
    Then response status is 201