package org.example.Problem1.View.Controller;

import org.example.Problem1.View.Model.StudentModel;

import java.util.Set;

public class StudentController implements StudentInterface {

    @Override
    public boolean createStudent(StudentModel studentModel, Set<StudentModel> listStudent) {
        int size = listStudent.size();
        listStudent.add(studentModel);
        if (listStudent.size() > size) {
            return true;
        }
        return false;
    }

    @Override
   public boolean editStudent(StudentModel studentModel, Set<StudentModel> listStudent) {
        boolean found = false;
        for (StudentModel student : listStudent) {
            if (student.equals(studentModel)) {
                found = true;
                listStudent.remove(student);
                break;
            }
        }

        if (!found) {
            return false; // Student not found by reference
        }

        listStudent.add(studentModel);

        return true;
   }

}
