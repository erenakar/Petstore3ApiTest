package io.swagger.dto;

import io.swagger.model.user.User;
import io.swagger.model.user.UserWithMissingId;
import io.swagger.service.Helpers;

public class UserData {

    public static User user() {
        return new User()
                .setId(10)
                .setUsername("theUser")
                .setFirstName("John")
                .setLastName("James")
                .setEmail("john@email.com")
                .setPassword("12345")
                .setPhone("12345")
                .setUserStatus(1);
    }

    public static User user(int id) {
        return user().setId(id);
    }

    public static User user(String username) {
        return userWithRandomId().setUsername(username);
    }

    public static User userWithRandomId() {
        return user().setId(Helpers.randomIdGenerator());
    }

    public static User userWithRandomUsername() {
        return userWithRandomId().setUsername(Helpers.randomStringGenerator());
    }

    public static UserWithMissingId userWithMissingId() {
        return new UserWithMissingId()
                .setUsername("theUser")
                .setFirstName("John")
                .setLastName("James")
                .setEmail("john@email.com")
                .setPassword("12345")
                .setPhone("12345")
                .setUserStatus(1);
    }
}
