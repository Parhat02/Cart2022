package com.selenium.integration.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WeatherStep {
    @Given("a {string} and {string} and api key")
    public void aAndAndApiKey(String arg0, String arg1) {
    }

    @When("a user calls the weather api with the api key")
    public void aUserCallsTheWeatherApiWithTheApiKey() {
    }

    @Then("the user should see the weather data for the city")
    public void theUserShouldSeeTheWeatherDataForTheCity() {
    }
}
