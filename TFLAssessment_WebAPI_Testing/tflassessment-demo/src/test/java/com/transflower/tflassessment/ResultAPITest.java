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
    @Test
    public void GetAllQuestions()
    {
        given()
        .when()
        .get("/api/Result/subjects ")
        .then()
        .body("[0].id",equalTo(1))
        .body("[0].title",equalTo("COREJAVA"))
         .statusCode(200)
         .body("size()",greaterThan(0));
    }

    @Test
    public void SetCandidateTestStartTime(){
        String requestBody="""
                {
                "hour": 10,
                "minutes": 30,
                "seconds": 0,
                "day": 27,
                "month": 11,
                "year": 2025
                }
                """;
        given()
         .headers("Content-Type","application/json")
         .body(requestBody)
         .when()
          .post("/api/Result/setstarttime/1/tests/1")
          .then()
          .statusCode(200)  
          .body(equalTo("true"));
          
    }

    @Test
    public void SetCandidateTestEndTime(){
        String requestBody="""
                {
                "hour": 10,
                "minutes": 30,
                "seconds": 0,
                "day": 27,
                "month": 11,
                "year": 2025
                }
                """;
        given()
         .headers("Content-Type","application/json")
         .body(requestBody)
        .when()
         .put("/api/Result/setendtime/1/tests/1")
         .then()
         .statusCode(200)  
         .body(equalTo("true"));
    }

    @Test
    public void GetCandidateResultDetails()
    {

        //read sample code from file

        int candidateId=1;
        int candidateTestId=1;

        String apiurl="/api/Result/candidates/"+candidateId+"/tests/"+candidateTestId+"/details";

        // object  expectedREsult=

        given()
        .when()
         .get(apiurl)
        .then()
        .body("candidateId",equalTo(1))
        .body("testId",equalTo(1))
        .body("correctAnswers",equalTo(3))
        .body("incorrectAnswers",equalTo(6))
        .body("skippedQuestions",equalTo(0))
         .statusCode(200)
         .body("size()",greaterThan(0));
    }

     @Test
    public void GetTestResultDetail()
    {
        given()
        .when()
         .get("/api/Result/tests/1/detail")
        .then()
        .body("[0].testId",equalTo(1))
        .body("[0].testName",equalTo("Basic MCQ Test"))
        .body("[0].candidateId",equalTo(2))
        .body("[0].firstName",equalTo("kajal"))
        .body("[0].lastName",equalTo("ghule"))
        .body("[0].subject",equalTo("COREJAVA"))
        .body("[0].score",equalTo(28))
         .statusCode(200)
         .body("size()",greaterThan(0));
    }

    @Test
    public void GetAppearedCandidates()
    {
        given()
        .when()
         .get("/api/Result/candidates/tests/1")
        .then()
        .body("[0].testId",equalTo(1))
        .body("[0].candidateId",equalTo(2))
        .body("[0].firstName",equalTo("kajal"))
        .body("[0].lastName",equalTo("ghule"))
         .statusCode(200)
         .body("size()",greaterThan(0));
    }

     @Test
    public void GetPassedCandidate()
    {
        given()
        .when()
         .get("/api/Result/passedcandidates/tests/1")
        .then()
        .body("[0].testId",equalTo(1))
        .body("[0].candidateId",equalTo(2))
        .body("[0].firstName",equalTo("kajal"))
        .body("[0].lastName",equalTo("ghule"))
        .body("[0].passingLevel",equalTo(5))
        .body("[0].score",equalTo(28))
         .statusCode(200)
         .body("size()",greaterThan(0));
    }

    @Test
    public void GetFailedCandidate()
    {
        given()
        .when()
         .get("/api/Result/failedcandidates/tests/2")
        .then()
        .body("[0].testId",equalTo(2))
        .body("[0].candidateId",equalTo(6))
        .body("[0].firstName",equalTo("sumit"))
        .body("[0].lastName",equalTo("bhor"))
        .body("[0].passingLevel",equalTo(7))
        .body("[0].score",equalTo(1))
         .statusCode(200)
         .body("size()",greaterThan(0));
    }

     @Test
    public void SetPassingLevel(){
        given()
        .when()
         .put("/api/Result/setpassinglevel/1/passingLevel/5")
         .then()
         .statusCode(200)  
         .body(equalTo("true"));
    }

    @Test
    public void GetTestList()
    {
        given()
        .when()
         .get("/api/Result/testlist/2")
        .then()
        .body("[0].testId",equalTo(1))
        .body("[0].testName",equalTo("Basic MCQ Test"))
        .body("[0].score",equalTo(28))
         .statusCode(200)
         .body("size()",greaterThan(0));
    }

    @Test
    public void GetSubjectResultDetails()
    {
        given()
        .when()
         .get("/api/Result/results/subjectresults/3")
        .then()
        .body("[0].testId",equalTo(5))
        .body("[0].subjectId",equalTo(3))
        .body("[0].candidateId",equalTo(8))
        .body("[0].firstName",equalTo("pranita"))
        .body("[0].lastName",equalTo("mane"))
        .body("[0].subject",equalTo("DOTNET"))
        .body("[0].score",equalTo(10))
         .statusCode(200)
         .body("size()",greaterThan(0));
    }

    @Test
    public void GetTestAverageReport()
    {
        given()
        .when()
         .get("/api/Result/results/testaveragereport/2")
        .then()
        .body("[0].subjectName",equalTo("COREJAVA"))
        .body("[0].concept",equalTo("OOPS"))
        .body("[0].totalQuestionsAnswered",equalTo(1))
        .body("[0].correctAnswers",equalTo(1))
        .body("[0].percentageCorrect",equalTo(100))
         .statusCode(200)
         .body("size()",greaterThan(0));
    }

     @Test
    public void GetCandidateScore()
    {
        given()
        .when()
         .get("/api/Result/candidates/1/tests/1/score")
        .then()
        .body(equalTo("3"))
         .statusCode(200);
    }

     @Test
    public void GetCandidateAllScore()
    {
        given()
        .when()
         .get("/api/Result/candidates/1/scores")
        .then()
        .body("[0].testName",equalTo("Basic MCQ Test"))
        .body("[0].score",equalTo(3))
         .statusCode(200);
    }

}
