package com.transflower.tflassessment;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;


public class UserAnalyticsAPITest {
    static{
        RestAssured.baseURI="http://localhost:5238";
    }
    @Test
    public void GetTotalOnlineSecondsAsync(){
        given()
        .when()
        .get("/api/UserAnalytics/ActiveUserSeconds/1")
        .then()
        .body(equalTo("73"))
        .statusCode(200);
    }
    
}
