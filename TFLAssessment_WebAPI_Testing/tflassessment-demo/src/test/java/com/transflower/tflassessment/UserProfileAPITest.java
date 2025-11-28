package com.transflower.tflassessment;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class UserProfileAPITest {
     static{
        RestAssured.baseURI="http://localhost:5238";
    }

    @Test
    public void GetUserProfileById(){
        given()
        .when()
        .get("/api/UserProfile/1")
        .then()
        .body("id", equalTo(1))
        .body("aadharId", equalTo("10564789"))
        .body("firstname", equalTo("ravi"))
        .body("lastname", equalTo("tambade"))
        .body("email", equalTo("ravi.tambade@example.com"))
        .body("contactNumber", equalTo("9000000000"))
        .body("password", equalTo(null))
        .body("userRoles.size()", equalTo(0))
        .statusCode(200);
    }
    
}
