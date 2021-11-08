package com.helloworld.services;

import com.helloworld.irepositories.IEmployeeRepository;
import com.helloworld.iservices.IEmployeeService;
import com.helloworld.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC,"id");
        Page<Employee> employeePage = eRepository.findAll(pages);
        return employeePage.getContent();
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

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return eRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
        return eRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeeByKeyword(String keyword) {
        //TODO add sorting logic
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return eRepository.findByNameContaining(keyword, sort);
    }
}
