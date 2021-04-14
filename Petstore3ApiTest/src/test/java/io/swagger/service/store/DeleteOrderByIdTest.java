package io.swagger.service.store;

import io.restassured.response.Response;
import io.swagger.dto.StoreData;
import io.swagger.model.store.Order;
import io.swagger.service.Helpers;
import io.swagger.service.StoreService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class DeleteOrderByIdTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void deleteOrder() {
        //Precondition: Create a new order
        int id = Helpers.randomIdGenerator();
        Order orderRequest = StoreData.order(id);

        Response response = StoreService.createOrderGetResponse(orderRequest);
        assertEquals(response.statusCode(), 200);

        //Actual test
        response = StoreService.deleteOrderById(id);
        assertEquals(response.statusCode(), 200);

        response = StoreService.getOrderByIdGetResponse(id);
        assertEquals(response.statusCode(), 404);
    }

    @Test
    public static void deleteOrderNotFound() {
        int id = Helpers.randomIdGenerator();

        Response response = StoreService.deleteOrderById(id);
        assertEquals(response.statusCode(), 404);
    }
}
