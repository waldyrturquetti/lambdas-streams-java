package org.example;

import org.example.exercise1.Employee;
import org.example.exercise1.EmployeeLoader;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.BiPredicate;


/*
    TODO
     Task 1:
     Create (or reuse from the previous exercices) a class that models an employee with the attributes name (String),
     salary (double), and employmentDate (java.time.LocalDate) and a class called EmployeeLoader with a static
     method List<Employee> loadFromFile(String fileName) that loads the employees from the file.
     Each line in the file is formatted as follows.
        Name;Salary;year;month;day
     If the file does not exist, return an empty list.
     Write a main program with a method that performs an action on pairs of employees selected by
     criteria unknown (at the time of writing) to the method.
     Demonstrate the method with the implementation where the action is to print the pairs and as
     criteria we choose pairs of junior employees (less than two years of work experience) which salary
     differs by more than 20%.
*/

public class App 
{
    public static void main( String[] args )
    {
        String fileName = "\\lambda-exercises-java\\src\\main\\java\\org\\example\\exercise1\\employees.txt";
        List<Employee> employeeList = EmployeeLoader.loadFromFile(System.getProperty("user.dir") + fileName);

        BiPredicate<Employee, Employee> employeePairPredicate = (e1, e2) -> isJuniorEmployee(e1) && isJuniorEmployee(e2);

        employeePairPredicate = employeePairPredicate.and((e1, e2) -> {
            double diff = e1.getSalary() / e2.getSalary();
            return diff > 1.2 || diff < 0.83;
        });

        processPairs(employeeList, employeePairPredicate);
    }

    private static void processPairs(List<Employee> employeeList, BiPredicate<Employee, Employee> employeePairPredicate) {

        for(int i=0; i < employeeList.size() - 1; i++) {
            for(int j = i + 1 ; j < employeeList.size() ; j++) {
                Employee first = employeeList.get(i);
                Employee second = employeeList.get(j);
                if (employeePairPredicate.test(first, second)) {
                    System.out.println(first + " <-> " + second);
                }
            }
        }
    }

    private static boolean isJuniorEmployee(Employee employee) {
        LocalDate today = LocalDate.of(2022, 12, 25);
        return Period.between(employee.getEmploymentDate(), today).getYears() < 2;
    }
}
