package io.swagger.service.user;

import io.restassured.response.Response;
import io.swagger.dto.UserData;
import io.swagger.model.user.User;
import io.swagger.service.Helpers;
import io.swagger.service.UserService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class DeleteUserByUsernameTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void deleteUser() {
        //Precondition: Create a new user
        String username = Helpers.randomStringGenerator();
        User userRequest = UserData.user(username);

        Response response = UserService.createUserGetResponse(userRequest);
        assertEquals(response.statusCode(), 200);

        //Actual test
        response = UserService.deleteUserByUsername(username);
        assertEquals(response.statusCode(), 200);

        response = UserService.getUserByUsernameGetResponse(username);
        assertEquals(response.statusCode(), 404);
    }

    @Test
    public static void deleteUserNotFound() {
        String username = Helpers.randomStringGenerator();

        Response response = UserService.deleteUserByUsername(username);
        assertEquals(response.statusCode(), 404);
    }
}
