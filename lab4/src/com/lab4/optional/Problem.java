package com.lab4.optional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem {

    private ArrayList<Student> studentList;
    private ArrayList<School> schoolsList;
    private HashMap<Student, Set<School>> studentPreferences;
    private HashMap<School, Set<Student>> schoolPreferences;

    public Problem(ArrayList<Student> studentList, ArrayList<School> schoolsList) {
        this.studentList = studentList;
        this.schoolsList = schoolsList;
    }

    public Problem(ArrayList<Student> studentList, ArrayList<School> schoolsList, HashMap<Student, Set<School>> studentPreferences, HashMap<School, Set<Student>> schoolPreferences) {
        this.studentList = studentList;
        this.schoolsList = schoolsList;
        this.schoolPreferences = schoolPreferences;
        this.studentPreferences = studentPreferences;
    }

    public void setSchoolPreferences(HashMap<School, Set<Student>> schoolPreferences) {
        this.schoolPreferences = schoolPreferences;
    }

    public HashMap<School, Set<Student>> getSchoolPreferences() {
        return schoolPreferences;
    }

    public void setStudentPreferences(HashMap<Student, Set<School>> studentPreferences) {
        this.studentPreferences = studentPreferences;
    }

    public HashMap<Student, Set<School>> getStudentPreferences() {
        return studentPreferences;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public List getStudentList() {
        return studentList;
    }

    public void setSchoolsList(ArrayList<School> schoolsList) {
        this.schoolsList = schoolsList;
    }

    public List getSchoolsList() {
        return schoolsList;
    }

    public List<Student> studentsAccepts(List<School> target) {
        return studentList.stream()
                .filter(std -> studentPreferences.get(std).containsAll(target))
                .collect(Collectors.toList());
    }

    public List<School> schoolAccepts(List<Student> target) {
        return schoolsList.stream()
                .filter(sch -> schoolPreferences.get(sch).containsAll(target))
                .collect(Collectors.toList());
    }
}
