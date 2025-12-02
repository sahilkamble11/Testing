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
     @Test
    public void UpdateUserProfile(){
        String requestBody="""
                {
                "id": 1,
                "aadharId": "10564789",
                "firstname": "sahil",
                "lastname": "kamble",
                "email": "sahil.kamble@example.com",
                "contactNumber": "7972542628",
                "password": "12345",
                "userRoles": []
                 }
                """;
        given()
        .header("Content-Type","application/json")
        .body(requestBody)
        .when()
        .put("/api/UserProfile/2")
        .then()
        .statusCode(200)
        .body(equalTo("true"))
        ;
}

@Test
    public void GetUserRoleByContactNo(){
        given()
        .when()
        .get("/api/UserProfile/contactno/7972542628")
        .then()
        .body("id", equalTo(2))
        .body("aadharId", equalTo(null))
        .body("firstname", equalTo("sahil"))
        .body("lastname", equalTo("kamble"))
        .body("email", equalTo("kajal.ghule@example.com"))
        .body("contactNumber", equalTo("7972542628"))
        .body("roles.size()", equalTo(1))
        .body("roles[0].id", equalTo(1))
        .body("roles[0].name", equalTo("admin"))
        .body("roles[0].lob", equalTo(null))
        .statusCode(200);
    }

    @Test
    public void GetAllSmeDetails(){
        given()
        .when()
        .get("/api/UserProfile/SmeUser")
        .then()
         .body("[0].id", equalTo(3))
        .body("[0].userId", equalTo(3))
        .body("[0].firstname", equalTo("nirjala"))
        .body("[0].lastname", equalTo("naik"))
        .body("[0].email", equalTo(null))
        .body("[0].contactNumber", equalTo(null))
        .body("[0].subjects.size()", equalTo(3))
        .body("[0].subjects[0].id", equalTo(0))
        .body("[0].subjects[0].title", equalTo("REACT"))
        .body("[0].subjects[1].title", equalTo("MICROSERVICES"))
        .body("[0].subjects[2].title", equalTo("CSHARP"))
        .body("[1].id", equalTo(5))
        .body("[1].userId", equalTo(5))
        .body("[1].firstname", equalTo("sanika"))
        .body("[1].lastname", equalTo("bhor"))
        .body("[1].email", equalTo(null))
        .body("[1].contactNumber", equalTo(null))
        .body("[1].subjects.size()", equalTo(0))
        .statusCode(200);
    }
    

}
