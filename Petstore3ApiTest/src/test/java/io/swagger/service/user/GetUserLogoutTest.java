package io.swagger.service.user;

import io.restassured.response.Response;
import io.swagger.dto.UserData;
import io.swagger.model.user.User;
import io.swagger.service.UserService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class GetUserLogoutTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void logout() {
        Response response = UserService.logout();
        assertEquals(response.statusCode(), 200);
    }
}
