package io.swagger.dto;

import io.swagger.model.pet.PetCategory;
import io.swagger.model.pet.PetStatus;
import io.swagger.model.pet.PetTag;
import io.swagger.model.pet.Pet;
import io.swagger.model.pet.PetWithMissingId;
import io.swagger.service.Helpers;

public class PetData {

    public static Pet pet() {
        return new Pet()
                .setId(10)
                .setName("doggie")
                .setCategory(new PetCategory(1, "Dogs"))
                .setPhotoUrls(new String[]{"string"})
                .setTags(new PetTag[]{new PetTag(0, "string")})
                .setStatus(PetStatus.AVAILABLE);
    }

    public static Pet pet(int id) {
        return pet()
                .setId(id);
    }

    public static Pet petWithRandomId() {
        return pet(Helpers.randomIdGenerator());
    }

    public static Pet petWithName(String name) {
        return pet()
                .setName(name);
    }

    public static Pet petWithStatus(String status) {
        return pet()
                .setStatus(status);
    }

    public static PetWithMissingId petWithMissingId() {
        return new PetWithMissingId()
                .setName("doggie")
                .setCategory(new PetCategory(1, "Dogs"))
                .setPhotoUrls(new String[]{"string"})
                .setTags(new PetTag[]{new PetTag(0, "string")})
                .setStatus(PetStatus.AVAILABLE);
    }
}
