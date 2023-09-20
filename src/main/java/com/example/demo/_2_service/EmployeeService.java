package com.example.demo._2_service;

import com.example.demo._3_dao.EmployeeRepository;
import com.example.demo._3_dao.Request_VacationRepository;
import com.example.demo.model.Employee;
import com.example.demo.model.Request_Vacation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private Request_VacationRepository requestVacationRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, Request_VacationRepository requestVacationRepository) {
        this.employeeRepository = employeeRepository;
        this.requestVacationRepository = requestVacationRepository;

    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeByName = employeeRepository.findEmployeeByName(employee.getName());
        if(employeeByName.isPresent()){
            throw new IllegalStateException("name taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean employeeExist = employeeRepository.existsById(employeeId);
        if (!employeeExist){
            throw new IllegalStateException("Employee does not exist");
        }
        employeeRepository.deleteById(employeeId);
    }

    public void makeVacationRequest(LocalDate startDate,
                                    LocalDate endDate,
                                    LocalDate returnToWorkDate){
        Request_Vacation vacayReqeust = new Request_Vacation(startDate, endDate, returnToWorkDate);
        requestVacationRepository.save(vacayReqeust);

    }


    //non-query based method
    @Transactional
    public void updateEmployeeName(Long employeeId, String name) {

        Employee employee = employeeRepository.findById(employeeId).get();

        employee.setName(name);
    }
}
