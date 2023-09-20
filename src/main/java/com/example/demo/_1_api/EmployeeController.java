package com.example.demo._1_api;


import com.example.demo._2_service.EmployeeService;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allemployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path = "{employeeID}")
    public void deleteEmployee(@PathVariable Long employeeID){
        employeeService.deleteEmployee(employeeID);
    }

    @PutMapping("{employeeId}")
    public void updateEmployeeName(
            @PathVariable Long employeeId,
            @RequestParam(required = false) String name
    ){
        employeeService.updateEmployeeName(employeeId, name);
    }









}
