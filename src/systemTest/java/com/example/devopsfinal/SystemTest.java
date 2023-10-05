package com.example.devopsfinal;

import io.restassured.RestAssured;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * A set of system tests for the TodoController class using RestAssured.
 */
public class SystemTest {

    /**
     * Set up the base URI for RestAssured before each test.
     */
    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
    }


    /**
     * Test the 'getListTest' method, which should return a 200 status code and a list.
     */
    @Test
    void getListTest_ShouldReturn200AndList() {
        given()
                .when()
                .get("/api/emptyList")
                .then()
                .statusCode(200);
        given()
                .param("task", "test")
                .when()
                .post("/api/add")
                .then()
                .statusCode(200)
                .body(IsEqual.equalTo("Task added!"));
        given()
                .when()
                .get("/api/list")
                .then()
                .statusCode(200)
                .body(IsEqual.equalTo("[\"test\"]"));
    }

    /**
     * Test the 'addTaskTest' method, which should return a 200 status code and a confirmation.
     */
    @Test
    void addTaskTest_ShouldReturn200AndConfirmation() {
        given()
                .when()
                .get("/api/emptyList")
                .then()
                .statusCode(200);
        given()
                .param("task", "test")
                .when()
                .post("/api/add")
                .then()
                .statusCode(200)
                .body(IsEqual.equalTo("Task added!"));
    }

    /**
     * Test the 'modifyTaskTest' method, which should return a 200 status code and a confirmation.
     */
    @Test
    void modifyTaskTest_ShouldReturn200AndConfirmation() {
        given()
                .when()
                .get("/api/emptyList")
                .then()
                .statusCode(200);
        given()
                .param("task", "test")
                .when()
                .post("/api/add")
                .then()
                .statusCode(200)
                .body(IsEqual.equalTo("Task added!"));
        given()
                .param("task", "test2")
                .param("index", 0)
                .when()
                .post("/api/modify")
                .then()
                .statusCode(200);
    }

    /**
     * Test the 'deleteTaskTest' method, which should return a 200 status code and a confirmation.
     */
    @Test
    void deleteTaskTest_ShouldReturn200AndConfirmation() {
        given()
                .when()
                .get("/api/emptyList")
                .then()
                .statusCode(200);
        given()
                .param("task", "test")
                .when()
                .post("/api/add")
                .then()
                .statusCode(200)
                .body(IsEqual.equalTo("Task added!"));
        given()
                .param("index", 0)
                .when()
                .post("/api/delete")
                .then()
                .statusCode(200);
    }
}
