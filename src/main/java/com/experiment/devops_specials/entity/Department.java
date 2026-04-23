package com.experiment.devops_specials.entity;

import com.experiment.devops_specials.entity.enums.DepartmentSubject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    private String departmentName;
    private DepartmentSubject departmentSubject;
}