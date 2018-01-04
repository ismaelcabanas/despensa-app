Feature: API for creating products
  In order to add new products into storeroom
  As an user
  I want an API for creating products

  Scenario: User call to API to create a new product
    Given I want to add to storeroom 5 units of a new product with name Milk
    When I post data to path /api/v1/products
    Then response status is 201