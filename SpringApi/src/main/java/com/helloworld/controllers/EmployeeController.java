package com.helloworld.controllers;

import com.helloworld.iservices.IEmployeeService;
import com.helloworld.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //localhost:8080/employees

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/get")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/get/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    //localhost:8080/saveEmployee
    @PostMapping("/save")
    public Employee SaveEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    //localhost:8080/delete?id=34
    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
    }

}
