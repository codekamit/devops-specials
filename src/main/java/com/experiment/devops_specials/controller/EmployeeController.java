package com.experiment.devops_specials.controller;


import com.experiment.devops_specials.dto.AddEmployeeDTO;
import com.experiment.devops_specials.entity.Employee;
import com.experiment.devops_specials.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
@Log4j2
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("add-employee")
    public ResponseEntity<String> addEmployee(@RequestBody AddEmployeeDTO dto) {
        log.info("Received request to add employee with email: {}", dto.getEmail());
        employeeService.addEmployee(dto);
        log.info("Employee with email {} added successfully", dto.getEmail());
        return ResponseEntity.status(201).body("Employee added successfully");
    }

    @GetMapping("get-employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        log.info("Received request to get all employees");
        List<Employee> employees = employeeService.getEmployees();
        log.info("Returning {} employees", employees.size());
        return ResponseEntity.ok(employees);
    }
}
