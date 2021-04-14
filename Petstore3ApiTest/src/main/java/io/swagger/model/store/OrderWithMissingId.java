package io.swagger.model.store;

public class OrderWithMissingId extends BaseOrder {

    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public int getPetId() {
        return petId;
    }

    public OrderWithMissingId setPetId(int petId) {
        this.petId = petId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderWithMissingId setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getShipDate() { return shipDate; }

    public OrderWithMissingId setShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrderWithMissingId setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean getComplete() {
        return complete;
    }

    public OrderWithMissingId setComplete(boolean complete) {
        this.complete = complete;
        return this;
    }
}
