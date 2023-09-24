package com.example.demo._2_service;

import com.example.demo._3_dao.EmployeeRepository;
import com.example.demo._4_exception.NoEmployeeFoundException;
import com.example.demo.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

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

    public String deleteEmployee(Long employeeId) {
        boolean employeeExist = employeeRepository.existsById(employeeId);
        if (!employeeExist){
            throw new IllegalStateException("Employee does not exist");
        }
        employeeRepository.deleteById(employeeId);
        return "Employee Id "+employeeId+" has been deleted";
    }




    //non-query based method; use setters to automatically upate the entity instead of using JPA
    //works via url inseration
    @Transactional
    public void updateEmployeeName(Long employeeId, String name) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoEmployeeFoundException(employeeId));

        if(name != null && name.length() > 0 && !Objects.equals(employee.getName(), name)){
            employee.setName(name);
        }

        employeeRepository.save(employee);
    }

    public void updateEmployeeJobTitle(Long employeeId, String newJobTitle){
        Employee employee = employeeRepository.findEmployeeById(employeeId).get();
        employee.setJobTitle(newJobTitle);
        employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }
}
