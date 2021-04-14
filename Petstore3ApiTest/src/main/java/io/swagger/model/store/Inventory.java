package io.swagger.model.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Inventory {

    private int additionalProp1;
    private int additionalProp2;
    private int additionalProp3;

    @JsonCreator
    public Inventory(@JsonProperty("approved") int additionalProp1,
                     @JsonProperty("placed") int additionalProp2,
                     @JsonProperty("delivered") int additionalProp3) {
        this.additionalProp1 = additionalProp1;
        this.additionalProp2 = additionalProp2;
        this.additionalProp3 = additionalProp3;
    }

    public int getAdditionalProp1() {
        return additionalProp1;
    }

    public Inventory setAdditionalProp1(int additionalProp1) {
        this.additionalProp1 = additionalProp1;
        return this;
    }

    public int getAdditionalProp2() {
        return additionalProp2;
    }

    public Inventory setAdditionalProp2(int additionalProp2) {
        this.additionalProp2 = additionalProp2;
        return this;
    }

    public int getAdditionalProp3() {
        return additionalProp3;
    }

    public Inventory setAdditionalProp3(int additionalProp3) {
        this.additionalProp3 = additionalProp3;
        return this;
    }
}
