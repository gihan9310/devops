package com.gihanz.devops.services;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.devops.dtos.StudentDto;
import com.gihanz.devops.entities.Student;
import com.gihanz.devops.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentDto save(StudentDto student) {
        return studentRepository.save(student.getEntity()).getDto();
    }

    public StudentDto delete(StudentDto student) {
        studentRepository.delete(student.getEntity());
        return student;
    }

    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(Student::getDto).toList();
    }

    public StudentDto findById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.map(Student::getDto).orElse(null);
    }
}
