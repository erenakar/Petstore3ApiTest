package io.swagger.service.pet;

import io.restassured.response.Response;
import io.swagger.dto.PetData;
import io.swagger.model.pet.Pet;
import io.swagger.model.pet.PetStatus;
import io.swagger.service.Helpers;
import io.swagger.service.PetService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class PostPetByIdTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void updatePetNameById() {
        String name = Helpers.randomStringGenerator();
        Pet petRequest = PetData.petWithName(name);

        Pet pet = PetService.updatePetNameById(petRequest);
        PetService.compareInputAndOutput(pet, petRequest);
    }

    @Test
    public static void updatePetStatusById() {
        Pet petRequest = PetData.petWithStatus(PetStatus.PENDING);

        Pet pet = PetService.updatePetStatusById(petRequest);
        PetService.compareInputAndOutput(pet, petRequest);
    }

    @Test
    public static void updatePetNameAndStatusById() {
        String name = Helpers.randomStringGenerator();
        Pet petRequest = PetData.petWithName(name);
        petRequest.setStatus(PetStatus.SOLD);

        Pet pet = PetService.updatePetById(petRequest);
        PetService.compareInputAndOutput(pet, petRequest);
    }

    @Test
    public static void updatePetByIdWithInvalidStatus() {
        Pet petRequest = PetData.petWithStatus(PetStatus.INVALID);

        Response response = PetService.updatePetByIdGetResponse(petRequest);
        assertEquals(response.statusCode(), 400);
    }
}
