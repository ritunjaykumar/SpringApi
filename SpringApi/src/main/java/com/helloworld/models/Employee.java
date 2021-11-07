package com.helloworld.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name should not be null")
    private String name;

    @Column(name = "age", nullable = false)
    private Long age = 0L;

    @Column(name = "location", nullable = false)
    @NotBlank(message = "location should not be null")
    private String location;

    @Column(name = "email", nullable = false)
    @Email(message = "please enter the valid email")
    @NotBlank(message = "email should not be null")
    private String email;

    @Column(name = "department", nullable = false)
    @NotBlank(message = "department should not be null")
    private String department;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Employee() {
    }

    public Employee(String name, Long age, String location, String
            email, String department) {

        this.name = name;
        this.age = age;
        this.location = location;
        this.email = email;
        this.department = department;
    }

    public Employee(String name, Long age, String location,
                    String email, String department, Date createdAt, Date updateAt) {
        this(name, age, location, email, department);
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

