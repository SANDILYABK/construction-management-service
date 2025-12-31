package com.cm.admirable.service;

import com.cm.admirable.entity.Employee;
import com.cm.admirable.repositary.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplement implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public void EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeServiceImplement(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
    @Override
    public Employee getEmployeeByContactEmail(String contactEmail) {

        return employeeRepository.findByContactEmail(contactEmail)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with contact email: " + contactEmail));
    }

}
