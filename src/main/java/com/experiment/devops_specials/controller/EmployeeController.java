package com.experiment.devops_specials.controller;


import com.experiment.devops_specials.dto.AddEmployeeDTO;
import com.experiment.devops_specials.entity.Employee;
import com.experiment.devops_specials.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("add-employee")
    public ResponseEntity<String> addEmployee(@RequestBody AddEmployeeDTO dto) {
        employeeService.addEmployee(dto);
        return ResponseEntity.status(201).body("Employee added successfully");
    }

    @GetMapping("get-employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }
}
