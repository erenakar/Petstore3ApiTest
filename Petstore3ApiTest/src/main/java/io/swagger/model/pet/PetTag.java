package io.swagger.model.pet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PetTag {

    private int id;
    private String name;

    @JsonCreator
    public PetTag(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public PetTag setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PetTag setName(String name) {
        this.name = name;
        return this;
    }
}
