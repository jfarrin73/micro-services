package com.example.employeeservice.service;

import com.example.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employee);
    EmployeeDto getEmployeeById(Long id);
}
