package com.cm.admirable.controller;

import com.cm.admirable.entity.Employee;
import com.cm.admirable.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/create")
    public Employee saveEmployee(@RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
    }


    @GetMapping("/allemployeesbyid/{id}")
    public Employee findAllById(@PathVariable Integer id) {
        System.out.println("Getting Employee ID of: " + id);
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/employeebyemail/{contactEmail}")
    public  Employee findByContactEmail(@PathVariable String contactEmail) {
        return employeeService.getEmployeeByContactEmail(contactEmail);
    }

    @GetMapping("/employeall")
    public List<Employee> findAll() {
        System.out.println("Controller Application Started for Employee");
        return employeeService.getAllEmployees();
    }
}
