package com.experiment.devops_specials.service;


import com.experiment.devops_specials.dto.AddEmployeeDTO;
import com.experiment.devops_specials.entity.Employee;
import com.experiment.devops_specials.exceptions.ObjectAlreadyExists;
import com.experiment.devops_specials.mapper.EmployeeMapper;
import com.experiment.devops_specials.repo.DepartmentRepo;
import com.experiment.devops_specials.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmployeeService {

    private static final EmployeeMapper EMPLOYEE_MAPPER = EmployeeMapper.INSTANCE;
    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;

    @Transactional
    public void addEmployee(AddEmployeeDTO dto) {
        log.info("Attempting to add employee with email: {}", dto.getEmail());
        if(employeeRepo.existsByEmail(dto.getEmail())) {
            log.warn("Employee with email {} already exists", dto.getEmail());
            throw new ObjectAlreadyExists(String.format("Employee with email %s already exists", dto.getEmail()));
        }
        departmentRepo.findByDepartmentName(dto.getDepartmentName()).ifPresentOrElse(department -> {
            log.info("Department {} found, associating employee", dto.getDepartmentName());
            Employee employee = EMPLOYEE_MAPPER.getEmployee(dto);
            employee.setDepartment(department);
            employeeRepo.save(employee);
            log.info("Employee {} added successfully with department {}", dto.getEmail(), dto.getDepartmentName());
        }, () -> {
            log.info("Department {} not found, adding employee without department", dto.getDepartmentName());
            Employee employee = EMPLOYEE_MAPPER.getEmployee(dto);
            employeeRepo.save(employee);
            log.info("Employee {} added successfully without department", dto.getEmail());
        });
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepo.getAllEmployees();
        log.info("Retrieved {} employees", employees.size());
        return employees;
    }
}
