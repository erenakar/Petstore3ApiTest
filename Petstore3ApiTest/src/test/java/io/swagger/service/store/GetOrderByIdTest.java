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

public class GetOrderByIdTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void getOrderById() {
        //Precondition: Create a new order
        int id = Helpers.randomIdGenerator();
        Order orderRequest = StoreData.order(id);

        Response response = StoreService.createOrderGetResponse(orderRequest);
        assertEquals(response.statusCode(), 200);

        System.out.println(id);

        //Actual test
        Order order = StoreService.getOrderById(id);
        StoreService.compareOrderInputAndOutput(order, orderRequest);
    }

    @Test
    public static void getOrderByIdNotFound() {
        int id = Helpers.randomIdGenerator();

        Response response = StoreService.getOrderByIdGetResponse(id);
        assertEquals(response.statusCode(), 404);
    }
}
