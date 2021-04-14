package io.swagger.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.swagger.model.store.BaseOrder;
import io.swagger.model.store.Inventory;
import io.swagger.model.store.Order;

import static org.testng.Assert.assertEquals;

public class StoreService {

    public static Inventory getStoreInventory() {
        return RestAssured.given()
                .when().get("/api/v3/store/inventory")
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Inventory.class);
    }

    public static Response createOrderGetResponse(BaseOrder order) {
        return RestAssured.given()
                .when().header("Content-Type", "application/json").body(order)
                .post("/api/v3/store/order");
    }

    public static Order createOrder(Order order) {
        return createOrderGetResponse(order)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Order.class);
    }

    public static Response getOrderByIdGetResponse(int id) {
        return RestAssured.given()
                .when().get("/api/v3/store/order/" + id);
    }

    public static Order getOrderById(int id) {
        return getOrderByIdGetResponse(id)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(Order.class);
    }

    public static Response deleteOrderById(int id) {
        return RestAssured.given()
                .when().delete("/api/v3/store/order/" + id);
    }

    public static void compareInventoryInputAndOutput(Inventory actual, Inventory expected) {
        assertEquals(actual.getAdditionalProp1(), expected.getAdditionalProp1());
        assertEquals(actual.getAdditionalProp2(), expected.getAdditionalProp2());
        assertEquals(actual.getAdditionalProp3(), expected.getAdditionalProp3());
    }

    public static void compareOrderInputAndOutput(Order actual, Order expected) {
        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getPetId(), expected.getPetId());
        assertEquals(actual.getQuantity(), expected.getQuantity());
        assertEquals(actual.getShipDate(), expected.getShipDate());
        assertEquals(actual.getStatus(), expected.getStatus());
        assertEquals(actual.getComplete(), expected.getComplete());
    }
}