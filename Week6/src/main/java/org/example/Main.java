package org.example;

import org.example.dao.StudentDAO;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        System.out.println(dao.getStudents().toString());
    }
}