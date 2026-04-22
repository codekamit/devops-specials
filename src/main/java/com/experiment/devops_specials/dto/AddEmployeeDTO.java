package com.experiment.devops_specials.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class AddEmployeeDTO {
    private Long employeeId;
    private String name;
    private String email;
    private String departmentName;
}
