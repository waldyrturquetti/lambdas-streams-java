package org.example.exercise1;


import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
@ToString
public class Employee {

    private String name;
    private double salary;
    private LocalDate employmentDate;

    public Employee(String name, double salary, LocalDate employmentDate) {
        this.name = name;
        this.salary = salary;
        this.employmentDate = employmentDate;
    }
}
