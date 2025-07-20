package com.gihanz.devops.controllers;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.devops.dtos.StudentDto;
import com.gihanz.devops.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(name = "find-all")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @DeleteMapping
    public ResponseEntity<StudentDto> deleteStudentById(@RequestBody StudentDto dto) {
        return ResponseEntity.ok(studentService.delete(dto));
    }

    @PostMapping
    public ResponseEntity<StudentDto> save(@RequestBody StudentDto dto) {
        return ResponseEntity.ok(studentService.save(dto));
    }
}
