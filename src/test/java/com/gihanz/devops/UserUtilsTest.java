package com.gihanz.devops;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.devops.practical.User;
import com.gihanz.devops.practical.UserUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
public class UserUtilsTest {

    @Test
    void emptyList_returnsEmptyMap() {
        Map<String, Long> result = UserUtils.countByRole(List.of());
        assertTrue(result.isEmpty(), "Expected empty map for empty user list");
    }

    @Test
    void usersWithNullRole_countedAsUnknown() {
        List<User> users = List.of(
                new User(1, "Alice", null),
                new User(2, "Bob", "admin")
        );

        Map<String, Long> result = UserUtils.countByRole(users);

        assertEquals(1L, result.get("unknown"));
        assertEquals(1L, result.get("admin"));
    }

    @Test
    void multipleUsersSameRole_countedCorrectly() {
        List<User> users = List.of(
                new User(1, "Alice", "editor"),
                new User(2, "Bob", "editor"),
                new User(3, "Charlie", "editor")
        );

        Map<String, Long> result = UserUtils.countByRole(users);

        assertEquals(3L, result.get("editor"));
    }

    @Test
    void mixedRoles_countedSeparately() {
        List<User> users = List.of(
                new User(1, "Alice", "admin"),
                new User(2, "Bob", "admin"),
                new User(3, "Eve", null),
                new User(4, "Sam", "viewer")
        );

        Map<String, Long> result = UserUtils.countByRole(users);

        assertEquals(2L, result.get("admin"));
        assertEquals(1L, result.get("viewer"));
        assertEquals(1L, result.get("unknown"));
    }
}
