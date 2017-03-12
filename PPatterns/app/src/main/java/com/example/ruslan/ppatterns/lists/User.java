package com.example.ruslan.ppatterns.lists;

/**
 * Created by Ruslan on 11.03.2017.
 */

public class User {
    private String name;
    private String surename;
    private String email;

    public User(String name, String surename, String email) {
        this.surename = surename;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
    }

    public String getEmail() {
        return email;
    }
}
