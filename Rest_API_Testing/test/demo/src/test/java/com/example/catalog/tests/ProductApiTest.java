package com.example.catalog.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ProductApiTest {

    @Test
    public void testGetAllProducts() {
        RestAssured.baseURI = "http://localhost:9090";

        given()
            .when().get("/api/products")
            .then()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("[0].name", notNullValue());
    }

    
    @Test
    public void getProductById_shouldReturnOne() {
        RestAssured.baseURI = "http://localhost:9090";
        given()
        .when()
            .get("/api/products/1")
        .then()
            .statusCode(200);
           
    }
 
    @Test
    public void createProduct_shouldReturn200() {
        RestAssured.baseURI = "http://localhost:9090";
        String newProductJson = """
        {
            "id" :4,
            "name": "Wireless Mouse",
            "price": 1500
        }
        """;

        given()
            .contentType(JSON)
            .body(newProductJson)
        .when()
            .post("/api/products")
        .then()
            .statusCode(200) 
            .body("id", notNullValue())
            .body("name", equalTo("Wireless Mouse"))
            .body("price", equalTo(1500.0F));
    }

   
    @Test
    public void updateProduct_shouldReturn200() {
        RestAssured.baseURI = "http://localhost:9090";
        String updatedProductJson = """
        {
            "id": 1,
            "name": "Dell",
            "price": 19000
        }
        """;

        given()
            .contentType(JSON)
            .body(updatedProductJson)
        .when()
            .put("/api/products/2")
        .then()
            .statusCode(200)
            .body("name", equalTo("Dell"))
            .body("price", equalTo(19000.0F));
    }

    @Test
    public void deleteProduct_shouldReturn200() {
        RestAssured.baseURI = "http://localhost:9090";
        given()
        .when()
            .delete("/api/products/3")
        .then()
            .statusCode(200); 
    }

}