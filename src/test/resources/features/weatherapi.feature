Feature: User should be able to get weather forecast data using weather API
  User should call the weather api with valid APPID and get forecast information
  Scenario Outline: user can get forecast data for any city
    Given a "<city>" and "<country>" and api key
    When a user calls the weather api with the api key
    Then the user should see the weather data for the city
    Examples:
    |city|country|
    |Baltimore|us|
    |London   |uk|
    |Tokyo    |jp|
    |Chicago  |us|
    |Toronto  |ca|
    |Istanbul |tr|