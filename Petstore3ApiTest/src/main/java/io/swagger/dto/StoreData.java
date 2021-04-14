package io.swagger.dto;

import io.swagger.model.store.*;
import io.swagger.service.Helpers;

import java.util.Date;

public class StoreData {

    public static Inventory inventory() {
        return new Inventory(50, 100, 50);
    }

    public static Order order() {
        return new Order()
                .setId(1)
                .setPetId(10)
                .setQuantity(1)
                .setShipDate(new OrderShipDate(new Date()).getTimeStamp())
                .setStatus(OrderStatus.PLACED)
                .setComplete(false);
    }

    public static Order order(int id) {
        return order().setId(id);
    }

    public static Order orderWithRandomId() {
        return order().setId(Helpers.randomIdGenerator());
    }

    public static Order orderWithRandomPetId() {
        return orderWithRandomId().setPetId(Helpers.randomIdGenerator());
    }

    public static OrderWithMissingId orderWithMissingId() {
        return new OrderWithMissingId()
                .setPetId(10)
                .setQuantity(1)
                .setShipDate(new OrderShipDate(new Date()).getTimeStamp())
                .setStatus(OrderStatus.PLACED)
                .setComplete(false);
    }

    public static OrderWithMissingPetId orderWithMissingPetId() {
        return new OrderWithMissingPetId()
                .setId(1)
                .setQuantity(1)
                .setShipDate(new OrderShipDate(new Date()).getTimeStamp())
                .setStatus(OrderStatus.PLACED)
                .setComplete(false);
    }
}
