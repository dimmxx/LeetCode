package org.example.tiproblems;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class StreamApiTask3 {

    public static void main(String[] args) {
        List<Department> departments = Arrays.asList(
                new Department("Computer Science", Arrays.asList(
                        new Student("John", 20),
                        new Student("Mary", 25),
                        new Student("David", 30),
                        new Student("Jane", 27)
                )),
                new Department("Mathematics", Arrays.asList(
                        new Student("Alice", 22),
                        new Student("Richard", 26),
                        new Student("Bob", 30)
                ))
        );

        // All students older than 25 in 'Mathematics' department:
        List<Student> oldMathStuds = departments.stream()
                .filter(d -> Objects.equals(d.name, "Mathematics"))
                .flatMap(d -> d.students.stream())
                .filter(s -> s.age > 25)
                .toList();
    }

    private static class Student {

        private final String name;
        private final int age;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    private static class Department {

        private final String name;
        private final List<Student> students;
        public Department(String name, List<Student> students) {
            this.name = name;
            this.students = students;
        }
    }
}

/*
Finish the implementation using Stream API to find all students that meets the requirement.
Requirements: student of 25+ years old in Math department
Constraints: each student - independent person, even if you have instance with same name and age in multiple departments
 */