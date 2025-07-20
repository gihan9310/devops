package com.gihanz.devops.practical;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

/**
 * Represents a user with an optional role.
 */
public class User {
    private final int id;
    private final String name;
    private final String role; // may be null

    public User(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
}
