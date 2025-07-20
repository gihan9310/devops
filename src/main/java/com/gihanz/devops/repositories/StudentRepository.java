package com.gihanz.devops.repositories;

import com.gihanz.devops.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
