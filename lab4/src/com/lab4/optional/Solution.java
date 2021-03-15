package com.lab4.optional;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private Problem problem;

    public Solution(Problem problem) {
        this.problem = problem;
    }

    public void createSolution() {
        ArrayList<Student> studentList = (ArrayList<Student>) problem.getStudentList();
        for (Student std : studentList)
            for (int idx = 0; idx < problem.getStudentPreferences().get(std).size(); idx++) {
                List<School> schoolsPref = new ArrayList<School>(problem.getStudentPreferences().get(std));
                School school = schoolsPref.get(idx);
                if (school.getCapacity() > 0) {
                    std.setAssigned(school);
                    school.setCapacity(school.getCapacity() - 1);
                }
            }

    }
}
