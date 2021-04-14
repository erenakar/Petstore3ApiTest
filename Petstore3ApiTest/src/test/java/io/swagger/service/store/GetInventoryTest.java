package io.swagger.service.store;

import io.swagger.dto.StoreData;
import io.swagger.model.store.Inventory;
import io.swagger.service.StoreService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class GetInventoryTest {

    @BeforeMethod
    public void nameBefore(Method method) {
        System.out.println("==================== " + method.getName().toUpperCase() + " ====================");
    }

    @Test
    public static void getInventory() {
        Inventory inventory = StoreService.getStoreInventory();
        StoreService.compareInventoryInputAndOutput(inventory, StoreData.inventory());
    }
}
