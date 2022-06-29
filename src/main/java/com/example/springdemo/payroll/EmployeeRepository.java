package com.example.springdemo.payroll;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employee_payroll WHERE c_id > ?1", nativeQuery = true)
    List<Employee> getEmployeesByFilter(long id);
}
