package com.cm.admirable.service;

import com.cm.admirable.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    Employee getEmployeeByContactEmail(String contactEmail);
}
