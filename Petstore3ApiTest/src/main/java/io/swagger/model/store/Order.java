package io.swagger.model.store;

public class Order extends BaseOrder{

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public int getPetId() {
        return petId;
    }

    public Order setPetId(int petId) {
        this.petId = petId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Order setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getShipDate() { return shipDate; }

    public Order setShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean getComplete() {
        return complete;
    }

    public Order setComplete(boolean complete) {
        this.complete = complete;
        return this;
    }
}
