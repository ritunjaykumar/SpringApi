package com.helloworld.irepositories;

import com.helloworld.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(@NotNull String name);

    List<Employee> findByNameAndLocation(String name, String location);
}
