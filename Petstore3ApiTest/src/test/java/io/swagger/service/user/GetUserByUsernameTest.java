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

public class GetUserByUsernameTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void getUserByUsername() {
        //Precondition: Create a new user
        String username = Helpers.randomStringGenerator();
        User userRequest = UserData.user(username);

        Response response = UserService.createUserGetResponse(userRequest);
        assertEquals(response.statusCode(), 200);

        //Actual test
        User user = UserService.getUserByUsername(username);
        UserService.compareInputAndOutput(user, userRequest);
    }

    @Test
    public static void getUserByUsernameNotFound() {
        String username = Helpers.randomStringGenerator();

        Response response = UserService.getUserByUsernameGetResponse(username);
        assertEquals(response.statusCode(), 404);
    }
}
