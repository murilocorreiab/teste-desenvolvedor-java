package com.desafiobackend.backend;

import com.desafiobackend.backend.request.UserRequest;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public final class UserEndpoint {

    public static ValidatableResponse getUserById(final String userId) {
        return given()
                .pathParam("userId", userId)
                .when()
                .get("/users/{userId}")
                .then();
    }

    public static ValidatableResponse getAllUsers() {
        return given()
                .when()
                .get("/users")
                .then();
    }

    public static ValidatableResponse updateUser(final String userId, final UserRequest user) {
        return given()
                .pathParam("userId", userId)
                .accept(ContentType.JSON)
                .with()
                .body(user)
                .when()
                .put("/users/{userId}/update").peek()
                .then();
    }

    public static ValidatableResponse deleteUser(final String userId) {
        return given()
                .pathParam("userId", userId)
                .when()
                .delete("/users/{userId}")
                .then();
    }

    public static ValidatableResponse insertUser(final UserRequest user) {
        return given()
                .contentType(ContentType.JSON)
                .with()
                .body(user)
                .when()
                .post("/users").peek()
                .then();
    }

}
