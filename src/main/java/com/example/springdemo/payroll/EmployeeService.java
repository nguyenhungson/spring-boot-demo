package com.example.springdemo.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    Employee addEmployee(Employee newEmployee) {
        return repository.save(newEmployee);
    }

    Employee getOne(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    List<Employee> all() {
        return repository.findAll();
    }

    List<Employee> getByFilter(long id) {
        return repository.getEmployeesByFilter(id);
    }

    Employee updateOne(long emloyeeId, Employee newEmployee) {
        return repository.findById(emloyeeId)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(emloyeeId);
                    return repository.save(newEmployee);
                });
    }

    void deleteOne(long employeeId) {
        repository.deleteById(employeeId);
    }

}
