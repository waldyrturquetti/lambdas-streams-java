package org.example.exercise1;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeLoader {

    public EmployeeLoader() {}

    public static List<Employee> loadFromFile(String fileName) {

        try {
            List<String> employeeStrings = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            return employeeStrings.stream()
                    .map(e -> {
                        String[] values = e.split(";");
                        return Employee.builder()
                                .name(values[0])
                                .salary(Double.parseDouble(values[1]))
                                .employmentDate(LocalDate.of(Integer.parseInt(values[2]),
                                                Integer.parseInt(values[3]), Integer.parseInt(values[4])))
                                .build();
                    }).collect(Collectors.toList());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return new ArrayList<>();
    }
}
