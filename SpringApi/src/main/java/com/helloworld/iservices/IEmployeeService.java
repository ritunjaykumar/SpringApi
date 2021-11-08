package com.helloworld.iservices;

import com.helloworld.models.Employee;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long empID);

    void deleteEmployee(Long empID);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeeByName(@NotNull String name);

    List<Employee> getEmployeeByNameAndLocation(String name, String location);

    List<Employee> getEmployeeByKeyword(String keyword);
}
