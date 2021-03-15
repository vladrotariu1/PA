package com.lab4.compulsory;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Student[] students = IntStream.rangeClosed(0,3)
                .mapToObj(counter -> new Student("S" + counter)).toArray(Student[]::new);
        School[] schools = IntStream.rangeClosed(0,2)
                .mapToObj(counter -> new School("H" + counter)).toArray(School[]::new);

        List<Student> studentList = new LinkedList<>();
        Set<School> schoolList = new TreeSet<>();

        for(Student student : students) {
            studentList.add(student);
        }

        for(School school : schools) {
            schoolList.add(school);
        }

        System.out.println(studentList);
        System.out.println(schoolList);

        Map<Student, Set<School>> studentPreferences = new HashMap<>();
        Map<School, Set<Student>> schoolPreferences = new TreeMap<>();

        studentPreferences.put(students[0], new HashSet<>(Arrays.asList(new School[]{schools[0], schools[1], schools[2]})));
        studentPreferences.put(students[1], new HashSet<>(Arrays.asList(new School[]{schools[0], schools[1], schools[2]})));
        studentPreferences.put(students[2], new HashSet<>(Arrays.asList(new School[]{schools[0], schools[1]})));
        studentPreferences.put(students[3], new HashSet<>(Arrays.asList(new School[]{schools[0], schools[2]})));

        schoolPreferences.put(schools[0], new HashSet<>(Arrays.asList(new Student[]{students[3], students[0], students[1], students[2]})));
        schoolPreferences.put(schools[1], new HashSet<>(Arrays.asList(new Student[]{students[0], students[2], students[1]})));
        schoolPreferences.put(schools[2], new HashSet<>(Arrays.asList(new Student[]{students[0], students[1], students[3]})));

        System.out.println(studentPreferences);
        System.out.println(schoolPreferences);
    }
}
