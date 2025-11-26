package com.transflower.tflassessment;

import static org.hamcrest.Matchers.greaterThan;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class ResultAPITest {
    static{
        RestAssured.baseURI="http://localhost:5238";
    }
    @Test
    public void GetAllQuestions()
    {
        given()
        .when()
         .get("/api/Result/subjects ")
        .then()
         .statusCode(200)
         .body("size()",greaterThan(0));
    }
}
