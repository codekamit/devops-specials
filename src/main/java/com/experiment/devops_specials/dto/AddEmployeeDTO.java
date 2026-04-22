package com.experiment.devops_specials.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeDTO {
    private Long employeeId;
    private String name;
    private String email;
    private String departmentName;
}
