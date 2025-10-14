package com.transflower.statuscodeplayground.stepdefs;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class StatusStepDefinitions {

 

    private Response response;
    

    private final RestTemplate restTemplate = new RestTemplate();

    @Given("the Product API is available")
    public void the_product_api_is_available() {
        RestAssured.baseURI = "http://localhost:8080";
    }
    @When("I send GET request to {string}")
    public void iSendGetRequestTo(String path) {
        String url = "http://localhost:8080"+ path;
         response = given().when().get(url);

    }

    @When("I send POST request to {string}")
    public void iSendPostRequestTo(String path) {
        String url = "http://localhost:8080" + path;
        response = given().when().post(url);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
        
    }
}