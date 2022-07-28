package com.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "John", 25, "male", "IT", 2018, 20000));
        employeeList.add(new Employee(211, "John", 24, "male", "IT", 2018, 20000));
        employeeList.add(new Employee(112, "Jack", 32, "male", "HR", 2018, 20000));
        employeeList.add(new Employee(113, "Jessy", 30, "female", "IT", 2018, 25000));
        employeeList.add(new Employee(114, "Jessica", 22, "female", "HR", 2018, 18000));
        employeeList.add(new Employee(115, "Amber", 26, "female", "HR", 2018, 22000));
        employeeList.add(new Employee(116, "Tom", 25, "male", "IT", 2018, 24000));
        employeeList.add(new Employee(117, "Ann", 27, "male", "IT", 2018, 27000));
        employeeList.add(new Employee(118, "Joseph", 30, "male", "Accounts", 2018, 30000));
        employeeList.add(new Employee(119, "Jeanie", 35, "female", "Accounts", 2018, 40000));
        employeeList.add(new Employee(120, "George", 45, "male", "HR", 2018, 50000));

        //Get the count of male and female employees in the organization
        getCountOfGender(employeeList);
        System.out.println("\n");

        //Get the count of all department in the organization
        getCountofDept(employeeList);
        System.out.println("\n");

        //Get the number of employees in each department
        getCountofEmpInDept(employeeList);
        System.out.println("\n");

        //Get the avg age of male & female employee
        getAvgAgeOfMaleFemaleEmp(employeeList);
        System.out.println("\n");
    }

    private static void getAvgAgeOfMaleFemaleEmp(List<Employee> employeeList) {
        System.out.println("Print the avg age of male & female employee : ");
        Map<String, Double> averageAgeOfMaleAndFemaleEmployee = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageAgeOfMaleAndFemaleEmployee);

    }

    private static void getCountofEmpInDept(List<Employee> employeeList) {
        System.out.println("Print the number of employees in each departments of organization : ");
        Map<String, Long> countOfDept = employeeList.stream().collect(Collectors.
                groupingBy(Employee::getDepartment,
                        Collectors.counting()));
        System.out.println(countOfDept);

    }

    private static void getCountofDept(List<Employee> employeeList) {
        System.out.println("Print the number of departments in an organization : ");
        employeeList.stream().map(e -> e.getDepartment()).distinct().forEach(System.out::println);
    }

    private static void getCountOfGender(List<Employee> employeeList) {
        System.out.println("Print number of male and female employees in an organization : ");
        Map<String, Long> noOfMaleFemaleEmployees = employeeList.stream().collect(Collectors.
                groupingBy(Employee::getGender,
                        Collectors.counting()));
        System.out.println(noOfMaleFemaleEmployees);
    }
}
