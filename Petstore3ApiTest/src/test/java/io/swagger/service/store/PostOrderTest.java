package io.swagger.service.store;

import io.restassured.response.Response;
import io.swagger.dto.StoreData;
import io.swagger.model.store.Order;
import io.swagger.model.store.OrderStatus;
import io.swagger.model.store.OrderWithMissingId;
import io.swagger.model.store.OrderWithMissingPetId;
import io.swagger.service.StoreService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class PostOrderTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void createOrder() {
        Order orderRequest = StoreData.orderWithRandomId();

        Order order = StoreService.createOrder(orderRequest);
        StoreService.compareOrderInputAndOutput(order, orderRequest);
    }

    @Test
    public static void createOrderWithExistingId() {
        Order orderRequest = StoreData.order();

        Response response = StoreService.createOrderGetResponse(orderRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void createOrderWithMissingId() {
        OrderWithMissingId orderRequest = StoreData.orderWithMissingId();

        Response response = StoreService.createOrderGetResponse(orderRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void createOrderWithMissingPetId() {
        OrderWithMissingPetId orderRequest = StoreData.orderWithMissingPetId();

        Response response = StoreService.createOrderGetResponse(orderRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void createOrderWithNonExistingPetId() {
        Order orderRequest = StoreData.orderWithRandomPetId();

        Response response = StoreService.createOrderGetResponse(orderRequest);
        assertEquals(response.statusCode(), 400);
    }

    @Test
    public static void createOrderWithInvalidStatus() {
        Order orderRequest = StoreData.orderWithRandomId().setStatus(OrderStatus.INVALID);

        Response response = StoreService.createOrderGetResponse(orderRequest);
        assertEquals(response.statusCode(), 400);
    }
}
