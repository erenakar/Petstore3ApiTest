package io.swagger.service.pet;

import io.restassured.response.Response;
import io.swagger.model.pet.Pet;
import io.swagger.model.pet.PetStatus;
import io.swagger.service.PetService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class GetPetFindByStatusTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void findPetsByStatus() {
        Pet[] pets = PetService.findPetsByStatus(PetStatus.AVAILABLE);
        assertEquals(PetService.isValidPetListByStatus(pets, PetStatus.AVAILABLE), true);
    }

    @Test
    public static void findPetsByStatusEmptyResult() {
        //Precondition: Delete all pets with SOLD status
        Pet[] pets = PetService.findPetsByStatus(PetStatus.SOLD);

        Response response;
        for (Pet pet : pets) {
            response = PetService.deletePetById(pet.getId());
            assertEquals(response.statusCode(), 200);
        }

        //Actual test
        pets = PetService.findPetsByStatus(PetStatus.SOLD);
        assertEquals(PetService.isEmptyList(pets), true);
    }

    @Test
    public static void findPetsByInvalidStatus() {
        Response response = PetService.findPetsByStatusGetResponse(PetStatus.INVALID);
        assertEquals(response.statusCode(), 400);
    }
}
