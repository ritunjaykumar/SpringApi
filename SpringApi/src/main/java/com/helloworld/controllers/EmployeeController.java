package com.helloworld.controllers;

import com.helloworld.iservices.IEmployeeService;
import com.helloworld.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //localhost:8080/employee

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/get/{pageNumber}/{pageSize}")
    public ResponseEntity<List<Employee>> getEmployees(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        return new ResponseEntity<>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    //localhost:8080/saveEmployee
    @PostMapping("/save")
    public ResponseEntity<Employee> SaveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    //localhost:8080/delete?id=34
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/get/name/{name}")
    public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable String name) {

        List<Employee> employeeList = employeeService.getEmployeeByName(name);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping("/get/name/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@PathVariable String name, @PathVariable String location) {
        List<Employee> employeeList = employeeService.getEmployeeByNameAndLocation(name, location);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping("/get/name/filter/{keyWord}")
    public ResponseEntity<List<Employee>> getNameByKeyword(@PathVariable String keyWord) {
        List<Employee> employeeList = employeeService.getEmployeeByKeyword(keyWord);

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

}
