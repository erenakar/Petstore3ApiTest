package io.swagger.model.store;

public class OrderWithMissingPetId extends BaseOrder {

    private int id;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public int getId() {
        return id;
    }

    public OrderWithMissingPetId setId(int id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderWithMissingPetId setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getShipDate() { return shipDate; }

    public OrderWithMissingPetId setShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrderWithMissingPetId setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean getComplete() {
        return complete;
    }

    public OrderWithMissingPetId setComplete(boolean complete) {
        this.complete = complete;
        return this;
    }
}
