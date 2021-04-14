package io.swagger.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.swagger.model.user.BaseUser;
import io.swagger.model.user.User;

import static org.testng.Assert.assertEquals;

public class UserService {

    public static Response createUserGetResponse(BaseUser user) {
        return RestAssured.given()
                .when().header("Content-Type", "application/json").body(user)
                .post("/api/v3/user");
    }

    public static User createUser(User user) {
        return createUserGetResponse(user)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(User.class);
    }

    public static Response createUserGetResponse(BaseUser[] users) {
        return RestAssured.given()
                .when().header("Content-Type", "application/json").body(users)
                .post("/api/v3/user/createWithList");
    }

    public static User[] createUser(User[] users) {
        return createUserGetResponse(users)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(User[].class);
    }

    public static Response loginUserGetResponse(String username, String password) {
        return RestAssured.given()
                .when().queryParam("username", username).queryParam("password", password)
                .get("/api/v3/user/login");
    }

    public static String loginUser(String username, String password) {
        return loginUserGetResponse(username, password)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().body().asString();
    }

    public static Response loginUserWithMissingUsername(String password) {
        return RestAssured.given()
                .when().queryParam("password", password)
                .get("/api/v3/user/login");
    }

    public static Response loginUserWithMissingPassword(String username) {
        return RestAssured.given()
                .when().queryParam("username", username)
                .get("/api/v3/user/login");
    }

    public static Response logout() {
        return RestAssured.given()
                .when().get("/api/v3/user/logout");
    }

    public static Response getUserByUsernameGetResponse(String username) {
        return RestAssured.given()
                .when().get("/api/v3/user/" + username);
    }

    public static User getUserByUsername(String username) {
        return getUserByUsernameGetResponse(username)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(User.class);
    }

    public static Response updateUserGetResponse(BaseUser user) {
        return RestAssured.given()
                .when().header("Content-Type", "application/json")
                .put("/api/v3/user/" + user.getUsername());
    }

    public static User updateUser(User user) {
        return updateUserGetResponse(user)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(User.class);
    }

    public static Response deleteUserByUsername(String username) {
        return RestAssured.given()
                .when().delete("/api/v3/user/" + username);
    }

    public static void compareInputAndOutput(User actualUser, User expectedUser) {
        assertEquals(actualUser.getId(), expectedUser.getId());
        assertEquals(actualUser.getUsername(), expectedUser.getUsername());
        assertEquals(actualUser.getFirstName(), expectedUser.getFirstName());
        assertEquals(actualUser.getLastName(), expectedUser.getLastName());
        assertEquals(actualUser.getEmail(), expectedUser.getEmail());
        assertEquals(actualUser.getPassword(), expectedUser.getPassword());
        assertEquals(actualUser.getPhone(), expectedUser.getPhone());
        assertEquals(actualUser.getUserStatus(), expectedUser.getUserStatus());
    }

    public static void compareInputAndOutput(User[] actualUsers, User[] expectedUsers) {
        for (int i = 0; i < actualUsers.length; i++) {
            compareInputAndOutput(actualUsers[i], expectedUsers[i]);
        }
    }
}
