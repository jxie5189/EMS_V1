package com.example.demo;

import com.example.demo._3_dao.EmployeeRepository;
import com.example.demo.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee jack = new Employee("jack");
            Employee john  = new Employee("john");

            repository.saveAll(
                    List.of(jack, john)
            );
        };
    }
}
