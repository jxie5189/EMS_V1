package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String jobTitle;
    private Double annualSalary;

    /*
    @Transient
    private Integer age;

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
     */

    public Employee(String name,
                    Long id,
                    String jobTitle,
                    Double annualSalary) {
        this.name = name;
        this.id = id;
        this.jobTitle = jobTitle;
        this.annualSalary = annualSalary;
    }

    public Employee(String name, String jobTitle, Double annualSalary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.annualSalary = annualSalary;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", annualSalary=" + annualSalary +
                '}';
    }
}
