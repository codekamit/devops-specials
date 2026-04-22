package com.experiment.devops_specials.repo;

import com.experiment.devops_specials.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);

    @Query("SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> getAllEmployees();
}
