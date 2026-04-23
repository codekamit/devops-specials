package com.experiment.devops_specials.repo;

import com.experiment.devops_specials.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentName(String departmentName);
}
