package com.carvalho.firstappandroid.dao;

import com.carvalho.firstappandroid.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final static List<Student> students = new ArrayList<>();

    public void save(Student student){
        students.add(student);
    }

    public List<Student> allStudents() {
        return new ArrayList<>(students);
    }
}
