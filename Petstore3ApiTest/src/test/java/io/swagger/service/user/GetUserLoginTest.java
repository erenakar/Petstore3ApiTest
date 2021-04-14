package io.swagger.service.user;

import io.restassured.response.Response;
import io.swagger.dto.UserData;
import io.swagger.model.user.User;
import io.swagger.model.user.UserWithMissingId;
import io.swagger.service.Helpers;
import io.swagger.service.UserService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class GetUserLoginTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void login() {
        User user = UserData.user();

        String loginInfo = UserService.loginUser(user.getUsername(), user.getPassword());
        //Trim and use the session from the loginInfo if required
    }

    @Test
    public static void loginWithMissingUsername() {
        User user = UserData.user();

        Response response = UserService.loginUserWithMissingUsername(user.getPassword());
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void loginWithMissingPassword() {
        User user = UserData.user();

        Response response = UserService.loginUserWithMissingPassword(user.getUsername());
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void loginWithIncorrectPassword() {
        User user = UserData.user();

        Response response = UserService.loginUserGetResponse(user.getUsername(), Helpers.randomStringGenerator());
        assertEquals(response.statusCode(), 400);
    }
}
