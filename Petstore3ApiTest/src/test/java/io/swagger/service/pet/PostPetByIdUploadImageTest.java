package io.swagger.service.pet;

import io.restassured.response.Response;
import io.swagger.dto.PetData;
import io.swagger.model.pet.Pet;
import io.swagger.model.pet.PetWithMissingId;
import io.swagger.service.Helpers;
import io.swagger.service.PetService;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class PostPetByIdUploadImageTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    //Test is disabled until uploadImageByPetIdGetResponse method is working properly
    @Test(enabled = false)
    public static void uploadPetImage() {
        //Precondition: Create a new pet
        int id = Helpers.randomIdGenerator();
        Pet petRequest = PetData.pet(id);

        Response response = PetService.createPetGetResponse(petRequest);
        assertEquals(response.statusCode(), 200);

        //Actual test
        String image = "image";
        Pet pet = PetService.uploadImageByPetId(id, image);
        PetService.compareInputAndOutput(pet, petRequest.addImage(image));
    }

    //Test is disabled until uploadImageByPetIdGetResponse method is working properly
    @Test(enabled = false)
    public static void uploadPetImageWithoutImage() {
        PetWithMissingId petRequest = PetData.petWithMissingId();

        Response response = PetService.updatePetGetResponse(petRequest);
        assertEquals(response.statusCode(), 400);
    }

    //Test is disabled until uploadImageByPetIdGetResponse method is working properly
    @Test(enabled = false)
    public static void uploadPetImageNotFound() {
        Response response = PetService.uploadImageByPetIdGetResponse(Helpers.randomIdGenerator(), "string");
        assertEquals(response.statusCode(), 404);
    }
}
