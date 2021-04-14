package io.swagger.model.pet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PetCategory {

    private int id;
    private String name;

    @JsonCreator
    public PetCategory(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public PetCategory setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PetCategory setName(String name) {
        this.name = name;
        return this;
    }
}
