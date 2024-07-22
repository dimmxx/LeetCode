package org.example.tiproblems;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiTask4 {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Peter", 25, "Male", "Product Development", 12500),
                new Employee(2, "John", 35, "Male", "Product Development", 17000),
                new Employee(3, "Mary", 45, "Female", "Sales and Marketing", 19000),
                new Employee(4, "Olivia", 32, "Female", "Sales and Marketing", 15000),
                new Employee(4, "Leo", 41, "Male", "Infrastructure", 10000)
        );
    }

    public static class Employee {
        private final long id;
        private final String name;
        private final int age;
        private final String gender;
        private final String department;
        private final long salary;

        public Employee(long id, String name, int age, String gender, String department, long salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.department = department;
            this.salary = salary;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        public String getDepartment() {
            return department;
        }

        public long getSalary() {
            return salary;
        }
    }
}

/*
 calculate the max average salary of each department
 */


class Solution {
    public Double solve(Collection<StreamApiTask4.Employee> employees) {
        Map<String, Double> map = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingLong(e -> e.getSalary())));
        Optional<Double> max = map.values().stream()
                .max(Comparator.naturalOrder());

        Double result = max
                .orElse(null);
        return result;
    }
}