package io.swagger.service.pet;

import io.restassured.response.Response;
import io.swagger.dto.PetData;
import io.swagger.model.pet.Pet;
import io.swagger.model.pet.PetStatus;
import io.swagger.model.pet.PetWithMissingId;
import io.swagger.service.PetService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class PostPetTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void createPet() {
        Pet petRequest = PetData.petWithRandomId();

        Pet pet = PetService.createPet(petRequest);
        PetService.compareInputAndOutput(pet, petRequest);
    }

    @Test
    public static void createPetWithExistingId() {
        Pet petRequest = PetData.pet();

        Response response = PetService.createPetGetResponse(petRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void createPetWithMissingId() {
        PetWithMissingId petRequest = PetData.petWithMissingId();

        Response response = PetService.createPetGetResponse(petRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void createPetWithInvalidStatus() {
        Pet petRequest = PetData.petWithRandomId().setStatus(PetStatus.INVALID);

        Response response = PetService.createPetGetResponse(petRequest);
        assertEquals(response.statusCode(), 400);
    }
}
