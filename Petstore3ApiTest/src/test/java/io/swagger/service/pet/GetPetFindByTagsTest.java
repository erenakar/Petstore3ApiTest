package io.swagger.service.pet;

import io.swagger.model.pet.Pet;
import io.swagger.service.Helpers;
import io.swagger.service.PetService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class GetPetFindByTagsTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void findPetsBySingleTag() {
        String[] petTags = {"string"};

        Pet[] pets = PetService.findPetsByTags(petTags);
        assertEquals(PetService.isValidPetListByTags(pets, petTags), true);
    }

    @Test
    public static void findPetsByMultipleTags() {
        String[] petTags = {"string", "stringg"};

        Pet[] pets = PetService.findPetsByTags(petTags);
        assertEquals(PetService.isValidPetListByTags(pets, petTags), true);
    }

    @Test
    public static void getPetByValidAndInvalidTags() {
        String[] petTags = {"string", Helpers.randomStringGenerator()};

        Pet[] pets = PetService.findPetsByTags(petTags);
        assertEquals(PetService.isEmptyList(pets), true);
    }
}
