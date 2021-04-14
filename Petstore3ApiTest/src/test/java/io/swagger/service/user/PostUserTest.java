package io.swagger.service.user;

import io.restassured.response.Response;
import io.swagger.dto.PetData;
import io.swagger.dto.UserData;
import io.swagger.model.pet.Pet;
import io.swagger.model.pet.PetStatus;
import io.swagger.model.pet.PetWithMissingId;
import io.swagger.model.user.User;
import io.swagger.model.user.UserWithMissingId;
import io.swagger.service.PetService;
import io.swagger.service.UserService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class PostUserTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void createUser() {
        User userRequest = UserData.userWithRandomId();

        User user = UserService.createUser(userRequest);
        UserService.compareInputAndOutput(user, userRequest);
    }

    @Test
    public static void createUserWithExistingId() {
        User userRequest = UserData.user();

        Response response = UserService.createUserGetResponse(userRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void createUserWithMissingId() {
        UserWithMissingId userRequest = UserData.userWithMissingId();

        Response response = UserService.createUserGetResponse(userRequest);
        assertEquals(response.statusCode(), 400);
    }
}
