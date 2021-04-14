package io.swagger.model.pet;

import org.apache.commons.lang3.ArrayUtils;

public class Pet extends BasePet {

    private int id;
    private String name;
    private PetCategory category;
    private String[] photoUrls;
    private PetTag[] tags;
    private String status;

    public int getId() {
        return id;
    }

    public Pet setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    public PetCategory getCategory() {
        return category;
    }

    public Pet setCategory(PetCategory category) {
        this.category = category;
        return this;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Pet setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public PetTag[] getTags() {
        return tags;
    }

    public Pet setTags(PetTag[] tags) {
        this.tags = tags;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Pet setStatus(String status) {
        this.status = status;
        return this;
    }

    public Pet addImage(String image) {
        this.photoUrls = ArrayUtils.add(this.photoUrls, image);
        return this;
    }
}
