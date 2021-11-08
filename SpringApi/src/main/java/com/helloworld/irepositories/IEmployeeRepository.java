package com.helloworld.irepositories;

import com.helloworld.models.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByName(@NotNull String name);

    //select * from table where name="some" and location ="india"
    List<Employee> findByNameAndLocation(String name, String location);

    //select I from where name lake %ram%"
    List<Employee> findByNameContaining(String keyword, Sort sort);

    @Query("FROM Employee WHERE name= :name OR location =:location")
    List<Employee> getEmployeeByNameAndLocation(String name, String location);


}
