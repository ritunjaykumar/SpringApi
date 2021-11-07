package com.helloworld.services;

import com.helloworld.irepositories.IEmployeeRepository;
import com.helloworld.iservices.IEmployeeService;
import com.helloworld.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long empID) {
        Optional<Employee> employeeOptional = eRepository.findById(empID);
        return employeeOptional.orElse(null);
    }

    @Override
    public void deleteEmployee(Long empID) {
        eRepository.deleteById(empID);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }
}
