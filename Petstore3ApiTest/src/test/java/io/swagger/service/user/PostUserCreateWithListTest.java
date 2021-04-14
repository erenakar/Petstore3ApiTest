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

public class PostUserCreateWithListTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void createUserWithList() {
        User[] usersRequest = new User[] {UserData.userWithRandomId()};

        User[] users = UserService.createUser(usersRequest);
        UserService.compareInputAndOutput(users, usersRequest);
    }

    @Test
    public static void createMultipleUsers() {
        User[] usersRequest = new User[] {UserData.userWithRandomId(), UserData.userWithRandomId()};

        User[] users = UserService.createUser(usersRequest);
        UserService.compareInputAndOutput(users, usersRequest);
    }

    @Test
    public static void createMultipleUsersWithSameId() {
        int id = Helpers.randomIdGenerator();
        User[] usersRequest = new User[] {UserData.user(id), UserData.user(id)};

        Response response = UserService.createUserGetResponse(usersRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void createMultipleUsersWithExistingAndNonExistingIds() {
        User[] usersRequest = new User[] {UserData.user(), UserData.userWithRandomId()};

        Response response = UserService.createUserGetResponse(usersRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void createUserWithListWithMissingId() {
        UserWithMissingId[] usersRequest = new UserWithMissingId[] {UserData.userWithMissingId()};

        Response response = UserService.createUserGetResponse(usersRequest);
        assertEquals(response.statusCode(), 400);
    }
}
