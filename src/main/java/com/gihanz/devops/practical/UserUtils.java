package com.gihanz.devops.practical;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserUtils {

    /**
     * Count how many users fall under each role.
     * Null roles are grouped under "unknown".
     *
     * @param users a non-null list of users
     * @return a map where keys are roles and values are the number of users with that role
     */
    public static Map<String, Long> countByRole(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(
                        u -> u.getRole() != null ? u.getRole() : "unknown",
                        Collectors.counting()
                ));
    }
}
