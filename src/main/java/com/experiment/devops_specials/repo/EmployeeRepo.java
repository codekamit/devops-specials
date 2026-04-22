package com.experiment.devops_specials.repo;

import com.experiment.devops_specials.entity.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);

    @EntityGraph(attributePaths = {"department"})
    @Query("SELECT e FROM Employee e")
    List<Employee> getAllEmployees();
}
