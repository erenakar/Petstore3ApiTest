package io.swagger.model.pet;

public class PetWithMissingId extends BasePet {

    private String name;
    private PetCategory category;
    private String[] photoUrls;
    private PetTag[] tags;
    private String status;

    public String getName() {
        return name;
    }

    public PetWithMissingId setName(String name) {
        this.name = name;
        return this;
    }

    public PetCategory getCategory() {
        return category;
    }

    public PetWithMissingId setCategory(PetCategory category) {
        this.category = category;
        return this;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public PetWithMissingId setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public PetTag[] getTags() {
        return tags;
    }

    public PetWithMissingId setTags(PetTag[] tags) {
        this.tags = tags;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PetWithMissingId setStatus(String status) {
        this.status = status;
        return this;
    }
}
