package com.helloworld.iservices;

import com.helloworld.models.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long empID);

    void deleteEmployee(Long empID);

    Employee updateEmployee(Employee employee);
}
