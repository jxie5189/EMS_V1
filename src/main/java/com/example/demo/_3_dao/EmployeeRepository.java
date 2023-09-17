package com.example.demo._3_dao;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.id = ?1")
    Optional<Employee> findEmployeeById(Long id);

    @Query("select e from Employee e where e.name = ?1")
    Optional<Employee> findEmployeeByName(String name);




}
