package org.example;

import org.example.Problem1.View.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentView view = new StudentView();

        while(true) {
            view.addStudent();
            view.editStudent();
        }
    }
}