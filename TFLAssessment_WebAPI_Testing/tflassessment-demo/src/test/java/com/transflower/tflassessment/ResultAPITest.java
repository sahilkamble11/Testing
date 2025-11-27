package com.transflower.tflassessment;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class ResultAPITest {
    static{
        RestAssured.baseURI="http://localhost:5238";
    }
    // @Test
    // public void GetAllQuestions()
    // {
    //     given()
    //     .when()
    //      .get("/api/Result/subjects ")
    //     .then()
    //      .statusCode(200)
    //      .body("size()",greaterThan(0));
    // }

    // @Test
    // public void SetCandidateTestStartTime(){
    //     String requestBody="""
    //             {
    //             "hour": 10,
    //             "minutes": 30,
    //             "seconds": 0,
    //             "day": 27,
    //             "month": 11,
    //             "year": 2025
    //             }
    //             """;
    //     given()
    //      .headers("Content-Type","application/json")
    //      .body(requestBody)
    //      .when()
    //       .post("/api/Result/setstarttime/1/tests/1")
    //       .then()
    //       .statusCode(200)  
    //       .body(equalTo("true"));
          
    // }

    // @Test
    // public void SetCandidateTestEndTime(){
    //     String requestBody="""
    //             {
    //             "hour": 10,
    //             "minutes": 30,
    //             "seconds": 0,
    //             "day": 27,
    //             "month": 11,
    //             "year": 2025
    //             }
    //             """;
    //     given()
    //      .headers("Content-Type","application/json")
    //      .body(requestBody)
    //     .when()
    //      .put("/api/Result/setendtime/1/tests/1")
    //      .then()
    //      .statusCode(200)  
    //      .body(equalTo("true"));
    // }

    // @Test
    // public void GetCandidateResultDetails()
    // {
    //     given()
    //     .when()
    //      .get("/api/Result/candidates/1/tests/1/details")
    //     .then()
    //      .statusCode(200)
    //      .body("size()",greaterThan(0));
    // }

    //  @Test
    // public void GetTestResultDetail()
    // {
    //     given()
    //     .when()
    //      .get("/api/Result/tests/1/detail")
    //     .then()
    //      .statusCode(200)
    //      .body("size()",greaterThan(0));
    // }

    // @Test
    // public void GetAppearedCandidates()
    // {
    //     given()
    //     .when()
    //      .get("/api/Result/candidates/tests/1")
    //     .then()
    //      .statusCode(200)
    //      .body("size()",greaterThan(0));
    // }

    //  @Test
    // public void GetPassedCandidate()
    // {
    //     given()
    //     .when()
    //      .get("/api/Result/passedcandidates/tests/1")
    //     .then()
    //      .statusCode(200)
    //      .body("size()",greaterThan(0));
    // }

    // @Test
    // public void GetFailedCandidate()
    // {
    //     given()
    //     .when()
    //      .get("/api/Result/failedcandidates/tests/2")
    //     .then()
    //      .statusCode(200)
    //      .body("size()",greaterThan(0));
    // }

    //  @Test
    // public void SetPassingLevel(){
    //     given()
    //     .when()
    //      .put("/api/Result/setpassinglevel/1/passingLevel/5")
    //      .then()
    //      .statusCode(200)  
    //      .body(equalTo("true"));
    // }

    @Test
    public void GetTestList()
    {
        given()
        .when()
         .get("/api/Result/testlist/2")
        .then()
         .statusCode(200)
         .body("size()",greaterThan(0));
    }






}
