package com.example.springdemo.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.base.Base;
import com.example.springdemo.base.BaseController;

@RestController
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/api/employee")
    Base newEmployee(@RequestBody Employee newEmployee) {
        Employee addSvc = service.addEmployee(newEmployee);
        return ApiResponse(HttpStatus.OK.value(), "OK", addSvc);
    }

    @GetMapping("/api/employees")
    Base getAll() {
        List<Employee> listEmployee = service.all();
        return ApiResponse(HttpStatus.OK.value(), "OK", listEmployee);
    }

    @GetMapping("/api/employee/{id}")
    Base getOne(@PathVariable Long id) {
        Employee emp = service.getOne(id);
        return ApiResponse(HttpStatus.OK.value(), "OK", emp);
    }

    @GetMapping("/api/employees-filter-id")
    Base getAllFilterId(@Param("id") long id) {
        List<Employee> listEmployee = service.getByFilter(id);
        return ApiResponse(HttpStatus.OK.value(), "OK", listEmployee);
    }

    @PutMapping("/api/employee/{id}")
    Base updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        Employee updateSvc = service.updateOne(id, newEmployee);
        return ApiResponse(HttpStatus.OK.value(), "OK", updateSvc);
    }

    @DeleteMapping("/api/employee/{id}")
    Base deleteEmployee(@PathVariable Long id) {
        service.deleteOne(id);
        return ApiResponse(HttpStatus.OK.value(), "OK");
    }

}
