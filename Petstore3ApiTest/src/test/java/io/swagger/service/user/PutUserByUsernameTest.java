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

public class PutUserByUsernameTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void updateUser() {
        //Precondition: Create a new user
        String username = Helpers.randomStringGenerator();
        User userRequest = UserData.user(username);

        //Actual test
        User user = UserService.updateUser(userRequest);
        UserService.compareInputAndOutput(user, userRequest);
    }

    @Test
    public static void updateUserNotFound() {
        User userRequest = UserData.userWithRandomUsername();

        Response response = UserService.updateUserGetResponse(userRequest);
        assertEquals(response.statusCode(), 404);
    }

    @Test
    public static void updateUserWithMissingId() {
        UserWithMissingId userRequest = UserData.userWithMissingId();

        Response response = UserService.updateUserGetResponse(userRequest);
        assertEquals(response.statusCode(), 400);
    }
}
