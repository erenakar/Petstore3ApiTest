package io.swagger.service.pet;

import io.restassured.response.Response;
import io.swagger.dto.PetData;
import io.swagger.model.pet.Pet;
import io.swagger.service.Helpers;
import io.swagger.service.PetService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class DeletePetByIdTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void deletePet() {
        //Precondition: Create a new pet
        int id = Helpers.randomIdGenerator();
        Pet petRequest = PetData.pet(id);

        Response response = PetService.createPetGetResponse(petRequest);
        assertEquals(response.statusCode(), 200);

        //Actual test
        response = PetService.deletePetById(id);
        assertEquals(response.statusCode(), 200);

        response = PetService.getPetByIdGetResponse(id);
        assertEquals(response.statusCode(), 404);
    }

    @Test
    public static void deletePetNotFound() {
        int id = Helpers.randomIdGenerator();

        Response response = PetService.deletePetById(id);
        assertEquals(response.statusCode(), 404);
    }
}
