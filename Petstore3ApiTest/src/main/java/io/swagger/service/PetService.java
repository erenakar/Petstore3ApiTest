package io.swagger.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.swagger.model.pet.BasePet;
import io.swagger.model.pet.Pet;

import java.io.File;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class PetService {

    public static Response updatePetGetResponse(BasePet pet) {
        return RestAssured.given()
                .when().header("Content-Type", "application/json").body(pet)
                .put("/api/v3/pet");
    }

    public static Pet updatePet(Pet pet) {
        return updatePetGetResponse(pet)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Pet.class);
    }

    public static Response createPetGetResponse(BasePet pet) {
        return RestAssured.given()
                .when().header("Content-Type", "application/json").body(pet)
                .post("/api/v3/pet");
    }

    public static Pet createPet(Pet pet) {
        return createPetGetResponse(pet)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Pet.class);
    }

    public static Response findPetsByStatusGetResponse(String petStatus) {
        return RestAssured.given()
                .when().queryParam("status", petStatus)
                .get("/api/v3/pet/findByStatus");
    }

    public static Pet[] findPetsByStatus(String petStatus) {
        return findPetsByStatusGetResponse(petStatus)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Pet[].class);
    }

    public static Pet[] findPetsByTags(String[] petTags) {
        RequestSpecification request = RestAssured.given().when();

        //to combine multiple tags
        for (String petTag : petTags) {
            request.queryParam("tags", petTag);
        }

        return request.get("/api/v3/pet/findByTags")
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Pet[].class);
    }

    public static Response getPetByIdGetResponse(int id) {
        return RestAssured.given()
                .when().get("/api/v3/pet/" + id);
    }

    public static Pet getPetById(int id) {
        return getPetByIdGetResponse(id)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Pet.class);
    }

    public static Pet updatePetNameById(Pet pet) {
        return RestAssured.given()
                .when().queryParam("name", pet.getName())
                .post("/api/v3/pet/" + pet.getId())
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Pet.class);
    }

    public static Pet updatePetStatusById(Pet pet) {
        return RestAssured.given()
                .when().queryParam("status", pet.getStatus())
                .post("/api/v3/pet/" + pet.getId())
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Pet.class);
    }

    public static Response updatePetByIdGetResponse(Pet pet) {
        return RestAssured.given()
                .when().queryParam("name", pet.getName()).queryParam("status", pet.getStatus())
                .post("/api/v3/pet/" + pet.getId());
    }

    public static Pet updatePetById(Pet pet) {
        return updatePetByIdGetResponse(pet)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Pet.class);
    }

    public static Response deletePetById(int id) {
        return RestAssured.given()
                .when().delete("/api/v3/pet/" + id);
    }

    public static Response uploadImageByPetIdGetResponse(int id, String image) {
        File file = new File("src/main/resources/image.png");

        return RestAssured.given()
                .when()
                .multiPart(image, file, "application/octet-stream")
                .post("/api/v3/pet/" + id + "/uploadImage");
    }

    public static Pet uploadImageByPetId(int id, String image) {
        return uploadImageByPetIdGetResponse(id, image)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Pet.class);
    }

    public static void compareInputAndOutput(Pet actualPet, Pet expectedPet) {
        assertEquals(actualPet.getId(), expectedPet.getId());
        assertEquals(actualPet.getName(), expectedPet.getName());
        assertEquals(actualPet.getCategory().getId(), expectedPet.getCategory().getId());
        assertEquals(actualPet.getCategory().getName(), expectedPet.getCategory().getName());
        for (int i = 0; i < actualPet.getPhotoUrls().length; i++) {
            assertEquals(actualPet.getPhotoUrls()[i], expectedPet.getPhotoUrls()[i]);
        }
        for (int i = 0; i < actualPet.getTags().length; i++) {
            assertEquals(actualPet.getTags()[i].getId(), expectedPet.getTags()[i].getId());
            assertEquals(actualPet.getTags()[i].getName(), expectedPet.getTags()[i].getName());
        }
        assertEquals(actualPet.getStatus(), expectedPet.getStatus());
    }

    public static boolean isEmptyList(Pet[] pets) {
        if (pets.length == 0)
            return true;

        return false;
    }

    public static boolean isValidPetListByStatus(Pet[] pets, String petStatus) {
        if (pets.length < 1)
            return false;

        for (Pet pet : pets) {
            assertEquals(pet.getStatus(), petStatus);
        }

        return true;
    }

    //It assumes multiple tags should make an AND logic
    public static boolean isValidPetListByTags(Pet[] pets, String[] inputPetTags) {
        if (pets.length < 1)
            return false;

        for (Pet pet : pets) {
            String[] petTags = new String[pet.getTags().length];

            for (int i = 0; i < petTags.length; i++) {
                petTags[i] = pet.getTags()[i].getName();
            }

            assertEquals(Arrays.asList(petTags).containsAll(Arrays.asList(inputPetTags)), true);
        }

        return true;
    }
}
