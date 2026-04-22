package com.experiment.devops_specials.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    @Column(unique = true)
    private String email;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Department department;
    @Version
    private Long version;
}
