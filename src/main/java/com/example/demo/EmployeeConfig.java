package com.example.demo;

import com.example.demo._3_dao.EmployeeRepository;
import com.example.demo.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepositoryrepository
                                         ){
        return args -> {
            Employee jack = new Employee("jack", "software developer I", 100000.00);
            Employee john  = new Employee("john", "software developer II", 120000.00);
            Employee joe = new Employee();


            employeeRepositoryrepository.saveAll(
                    List.of(jack, john, joe)
            );

;
        };
    }
}
