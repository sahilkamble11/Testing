package com.transflower.tflassessment;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


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

    @Test
    public void GetActiveUsersCountAsync(){
        given()
        .when()
        .get("/api/UserAnalytics/ActiveUsercount")
        .then()
        .body(equalTo("No second found."))
        .statusCode(404);

    }

    @Test
    public void GetUserCount(){
        given()
        .when()
        .get("/api/UserAnalytics/allusercount")
        .then()
        .body(equalTo(""))
        .statusCode(200);

    }
}
