package org.example.Problem1.View.Controller;

import org.example.Problem1.View.Model.StudentModel;

import java.util.Set;

public interface StudentInterface {
    boolean editStudent(StudentModel studentModel, Set<StudentModel> listStudent);
    boolean createStudent(StudentModel studentModel, Set<StudentModel> listStudent);

}
