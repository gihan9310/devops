package com.gihanz.devops.entities;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.devops.dtos.StudentDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@ToString
@Table(name = "STUDENTS")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;

    @JsonIgnore
    public StudentDto getDto(){
        StudentDto student = new StudentDto();
        BeanUtils.copyProperties(this,student);
        return student;
    }
}
