package com.example;

import java.util.function.Function;
import java.util.function.Predicate;

public class  EmployeeUtils {

  public String getFullName(Employee employee) {
    Function<Employee, String> fullName = e -> e.getFirstName() + " " + e.getLastName();
    return fullName.apply(employee);
  }

  public String getManagersLastName(Employee employee) {
    Function<Employee, String> managersLastName = e -> e.getManager().getLastName();
    return managersLastName.apply(employee);
  }

  public boolean hasBeenEmployedLongerThanFiveYears(Employee employee) {
    Predicate<Employee> employedLongerThanFiveYears = e -> e.getYearsOfService() > 5;
    return employedLongerThanFiveYears.test(employee);
  }

  public boolean hasMoreThanThreeDirectReports(Employee employee) {
    Predicate<Employee> moreThanThreeDirectReports = employee1 -> employee.getNumberOfDirectReports() > 3;
    return moreThanThreeDirectReports.test(employee);
  }

  public boolean hasMoreThanThreeYearsOfServiceAndLessThanTwoDirectReports(Employee employee) {
    Predicate<Employee> moreThanThreeYearsOfServiceAndLessThanTwoDirectReports =
            employee1 -> employee1.getYearsOfService() > 3 && employee1.getNumberOfDirectReports() < 2;
    return moreThanThreeYearsOfServiceAndLessThanTwoDirectReports.test(employee);
  }

}
