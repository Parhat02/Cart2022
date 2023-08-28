@ApiTest
Feature: an authorized user should be able to manage customers and products

  Scenario: an authorized user should be able to get all customers
    Given a valid username and password
    When the user sends a get request to the customer end point
    Then the api should return 200 response code
    And the api should return more than one customer

    Scenario: an authorized user should be able to get all products
      Given a valid username and password
      When the user sends a get request to the product end point
      Then the api should return 200 response code
      And the api should return more than one product

      Scenario Outline: an authorized user should be able to add multiple customers
        Given "<email>" and "<title>" and "<firstName>" and "<lastName>" and "<country>" and "<phone>" and "<status>" and "<language>" and "<ipaddress>" and "<registered>"
        When the user sends  post request to the customer endpoint with payload
        Then the api should return 200 response code and create a new customer
        Examples:
        |email|title|firstName|lastName|country|phone|status|language|ipaddress|registered|
        |abd123@gmail.com|Mr|Abdullah|Karluk|0 |4634646|1   |En      |123.654.987.987|1   |
        |abd124@gmail.com|Mrs|Meery  |Smith |0 |99767464|1  |En      |977.954.325.159|1   |