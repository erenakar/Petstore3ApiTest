package io.swagger.service.pet;

import io.swagger.dto.PetData;
import io.swagger.model.pet.Pet;
import io.swagger.model.pet.PetStatus;
import io.swagger.model.pet.PetWithMissingId;
import io.swagger.service.PetService;
import org.testng.annotations.*;
import io.restassured.response.Response;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class PutPetTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void updatePet() {
        Pet petRequest = PetData.pet();

        Pet pet = PetService.updatePet(petRequest);
        PetService.compareInputAndOutput(pet, petRequest);
    }

    @Test
    public static void updatePetNotFound() {
        Pet petRequest = PetData.petWithRandomId();

        Response response = PetService.updatePetGetResponse(petRequest);
        assertEquals(response.statusCode(), 404);
    }

    @Test
    public static void updatePetWithMissingId() {
        PetWithMissingId petRequest = PetData.petWithMissingId();

        Response response = PetService.updatePetGetResponse(petRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void updatePetWithInvalidStatus() {
        Pet petRequest = PetData.petWithStatus(PetStatus.INVALID);

        Response response = PetService.updatePetGetResponse(petRequest);
        assertEquals(response.statusCode(), 400);
    }
}
