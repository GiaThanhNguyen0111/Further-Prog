package org.example;

import org.example.Decorator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        courses.add("1");
        courses.add("1");
        courses.add("1");
        courses.add("1");
        Student basicStudent = new Student();
        basicStudent.setId(1L);
        basicStudent.setGPA(3.5);
        basicStudent.setName("'Thanh");
        basicStudent.setCourses(courses);

        // Adding decorators
        StudentCalculateFee regularStudent = new RegularStudent(basicStudent, 50.0);
        StudentCalculateFee latePaymentStudent = new LatePaymentStudent(regularStudent);
        StudentCalculateFee outstandingResultsStudent = new OutStandingStudent(latePaymentStudent);

        // Calculating fee
        double totalFee = outstandingResultsStudent.calcFee();
        System.out.println("Total Fee: $" + totalFee);
    }
}