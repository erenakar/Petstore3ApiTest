package io.swagger.service;

import java.util.UUID;

public class Helpers {

    public static int randomIdGenerator() {
        final java.util.Random random = new java.util.Random();

        return random.nextInt(10000) + 10000;
    }

    public static String randomStringGenerator() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
