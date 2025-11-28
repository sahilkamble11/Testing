package com.transflower.tflassessment;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class UserAnalyticsAPITest {
    static{
        RestAssured.baseURI="http://localhost:5238";
    }
    // @Test
    // public void GetTotalOnlineSecondsAsync(){
    //     given()
    //     .when()
    //     .get("/api/UserAnalytics/ActiveUserSeconds/1")
    //     .then()
    //     .body(equalTo("73"))
    //     .statusCode(200);
    // }

    // @Test
    // public void GetActiveUsersCountAsync(){
    //     given()
    //     .when()
    //     .get("/api/UserAnalytics/ActiveUsercount")
    //     .then()
    //     .body(equalTo("2"))
    //     .statusCode(200);

    // }

    // @Test
    // public void GetUserCount(){
    //     given()
    //     .when()
    //     .get("/api/UserAnalytics/allusercount")
    //     .then()
    //     .statusCode(200);

    // }

    //working
    // @Test
    // public void GetTopTenUser(){
    //     given()
    //     .when()
    //     .get("/api/UserAnalytics/toptenuser")
    //     .then()
    //     .body("[0].id", equalTo(5))
    //     .body("[0].firstname", equalTo("sanika"))
    //     .body("[0].lastname", equalTo("bhor"))
    //     .body("[0].email", equalTo("sanika.bhor@example.com"))
    //     .body("[0].userRoles[0].role.name", equalTo("sme"))
    //     .statusCode(200);

    // }

    // @Test
    // public void GetActiveUsers(){
    //     given()
    //     .when()
    //     .get("/api/UserAnalytics/activeUser")
    //     .then()
    //     .statusCode(200);

    // }

    //working
        @Test
    public void GetAllUsers(){
        given()
        .when()
        .get("/api/UserAnalytics/alluser")
        .then()
        .body(equalTo("2"))
        .statusCode(200);

    }
}
