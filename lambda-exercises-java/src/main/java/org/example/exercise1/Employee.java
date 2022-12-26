package org.example.exercise1;


import lombok.*;

import java.time.LocalDate;
import java.time.Period;

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

    public boolean isJuniorEmployee() {
        LocalDate today = LocalDate.of(2022, 12, 25);
        return Period.between(this.employmentDate, today).getYears() < 2;
    }
}
