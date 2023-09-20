package com.example.demo;

import com.example.demo._3_dao.EmployeeRepository;
import com.example.demo._3_dao.Request_VacationRepository;
import com.example.demo.model.Employee;
import com.example.demo.model.Request_Vacation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepositoryrepository,
                                        Request_VacationRepository requestVacationRepository){
        return args -> {
            Employee jack = new Employee("jack");
            Employee john  = new Employee("john");

            Request_Vacation test = new Request_Vacation(
                    LocalDate.of(2023, Month.JANUARY, 15),
                    LocalDate.of(2023, Month.JANUARY, 5),
                    LocalDate.of(2023, Month.JANUARY, 17));



            employeeRepositoryrepository.saveAll(
                    List.of(jack, john)
            );

            requestVacationRepository.save(
                    test
            );
        };
    }
}
