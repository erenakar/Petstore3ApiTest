package io.swagger.model.user;

public class UserWithMissingId extends BaseUser {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    public String getUsername() {
        return username;
    }

    public UserWithMissingId setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserWithMissingId setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserWithMissingId setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserWithMissingId setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserWithMissingId setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserWithMissingId setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public UserWithMissingId setUserStatus(int userStatus) {
        this.userStatus = userStatus;
        return this;
    }
}
