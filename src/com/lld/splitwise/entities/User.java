package com.lld.splitwise.entities;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String userId;

    public User(String name, String email, String phoneNumber, String userId) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserId() {
        return userId;
    }
}
