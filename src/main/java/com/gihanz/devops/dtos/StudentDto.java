package com.gihanz.devops.dtos;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 * Testing
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.devops.entities.Student;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@ToString
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private String email;

    @JsonIgnore
    public Student getEntity(){
        Student student = new Student();
        BeanUtils.copyProperties(this,student);
        return student;
    }
}
