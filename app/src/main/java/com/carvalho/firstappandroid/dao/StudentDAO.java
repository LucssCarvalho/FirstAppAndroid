package com.carvalho.firstappandroid.dao;

import androidx.annotation.NonNull;

import com.carvalho.firstappandroid.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();
    private static int countIds = 1;

    public void save(Student student) {
        student.setId(countIds);
        students.add(student);
        updateIds();
    }

    private void updateIds() {
        countIds++;
    }

    public void edit(Student student) {
        Student studentFound = searchStudent(student);
        if (studentFound != null) {
            int positionStudent = students.indexOf(studentFound);
            students.set(positionStudent, student);
        }
    }

    @NonNull
    private Student searchStudent(Student student) {
        Student studentFound = null;
        for (Student i :
                students) {
            if (i.getId() == student.getId()) {
                return i;
            }
        }
        return null;
    }

    public List<Student> allStudents() {
        return new ArrayList<>(students);
    }
}
