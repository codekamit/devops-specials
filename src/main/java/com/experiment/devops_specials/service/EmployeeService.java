package com.experiment.devops_specials.service;


import com.experiment.devops_specials.dto.AddEmployeeDTO;
import com.experiment.devops_specials.entity.Employee;
import com.experiment.devops_specials.exceptions.ObjectAlreadyExists;
import com.experiment.devops_specials.mapper.EmployeeMapper;
import com.experiment.devops_specials.repo.DepartmentRepo;
import com.experiment.devops_specials.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private static final EmployeeMapper EMPLOYEE_MAPPER = EmployeeMapper.INSTANCE;
    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;

    @Transactional
    public void addEmployee(AddEmployeeDTO dto) {
        if(employeeRepo.existsByEmail(dto.getEmail())) {
            throw new ObjectAlreadyExists(String.format("Employee with email %s already exists", dto.getEmail()));
        }
        departmentRepo.findByDepartmentName(dto.getDepartmentName()).ifPresentOrElse(department -> {
            Employee employee = EMPLOYEE_MAPPER.getEmployee(dto);
            employee.setDepartment(department);
            employeeRepo.save(employee);
        }, () -> {
            Employee employee = EMPLOYEE_MAPPER.getEmployee(dto);
            employeeRepo.save(employee);
        });
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployees() {
        return employeeRepo.getAllEmployees();
    }
}
